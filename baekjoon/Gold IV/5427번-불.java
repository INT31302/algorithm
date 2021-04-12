import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int w, h, result;
    static boolean[][] sVisited, fVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static char[][] map;
    static Queue<Point> sQueue, fQueue;

    static class Point {
        int x, y, cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs() {
        while (!sQueue.isEmpty()) {
            int size = sQueue.size();
            for (int i = 0; i < size; i++) {
                Point p = sQueue.poll();
                if (map[p.x][p.y] == '*') continue;
                for (int j = 0; j < 4; j++) {
                    int px = p.x + dx[j];
                    int py = p.y + dy[j];
                    if (px < 0 || py < 0 || px >= h || py >= w) {
                        result = p.cnt;
                        return;
                    }
                    if (map[px][py] == '#' || map[px][py] == '*') continue;
                    if (sVisited[px][py]) continue;
                    sVisited[px][py] = true;
                    map[px][py] = '@';
                    sQueue.offer(new Point(px, py, p.cnt + 1));
                }
            }
            size = fQueue.size();
            for (int i = 0; i < size; i++) {
                Point p = fQueue.poll();
                for (int j = 0; j < 4; j++) {
                    int px = p.x + dx[j];
                    int py = p.y + dy[j];
                    if (px < 0 || py < 0 || px >= h || py >= w) continue;
                    if (map[px][py] == '#') continue;
                    if (fVisited[px][py]) continue;
                    fVisited[px][py] = true;
                    map[px][py] = '*';
                    fQueue.offer(new Point(px, py));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            sVisited = new boolean[h][w];
            fVisited = new boolean[h][w];
            map = new char[h][w];
            sQueue = new ArrayDeque<>();
            fQueue = new ArrayDeque<>();
            result = 0;
            for (int j = 0; j < h; j++) {
                String s = br.readLine();
                for (int k = 0; k < w; k++) {
                    map[j][k] = s.charAt(k);
                    if (map[j][k] == '@') sQueue.offer(new Point(j, k, 1));
                    if (map[j][k] == '*') fQueue.offer(new Point(j, k));
                }
            }
            bfs();
            if (result != 0) bw.write(result + "\n");
            else bw.write("IMPOSSIBLE\n");
        }
        bw.close();
        br.close();
    }


}
