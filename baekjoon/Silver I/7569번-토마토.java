import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int h;
        int m;
        int n;

        public Point(int h, int m, int n) {
            this.h = h;
            this.m = m;
            this.n = n;
        }
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] dz = {1, -1, 0};
    static int[][][] arr;
    static boolean[][][] visited;
    static Queue<Point> queue = new ArrayDeque<>();
    static int M, N, H;
    static int Day;

    static void bfs() {
        while (!queue.isEmpty()) {
            int cnt = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point p = queue.poll();
                visited[p.h][p.m][p.n] = true;
                for (int j = 0; j < dz.length; j++) {
                    int pz = p.h + dz[j];
                    if (dz[j] == 0) {
                        for (int k = 0; k < dx.length; k++) {
                            int px = p.m + dx[k];
                            int py = p.n + dy[k];
                            if (pz < 0 || pz >= H || px < 0 || px >= N || py < 0 || py >= M) continue;
                            if (visited[pz][px][py]) continue;
                            if (arr[pz][px][py] == -1 || arr[pz][px][py] == 1) continue;
                            arr[pz][px][py] = 1;
                            visited[pz][px][py] = true;
                            queue.offer(new Point(pz, px, py));
                            cnt++;
                        }
                    } else {
                        int px = p.m, py = p.n;
                        if (pz < 0 || pz >= H || px < 0 || px >= N || py < 0 || py >= M) continue;
                        if (visited[pz][px][py]) continue;
                        if (arr[pz][px][py] == -1 || arr[pz][px][py] == 1) continue;
                        arr[pz][px][py] = 1;
                        visited[pz][px][py] = true;
                        queue.offer(new Point(pz, px, py));
                        cnt++;
                    }
                }
            }
            if (cnt != 0) Day++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][N][M];
        visited = new boolean[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][k] == 1) queue.offer(new Point(i, j, k));
                }
            }
        }
        bfs();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(arr[i][j][k] == 0) Day = -1;
                }
            }
        }
        bw.write(Day+"\n");
        bw.close();
        br.close();
    }
}
