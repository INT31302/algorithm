import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] fireVistied;
    static boolean[][] jihoonVisited;
    static int result;
    static Queue<Point> jihoon = new ArrayDeque<>();
    static Queue<Point> fire = new ArrayDeque<>();

    static class Point {
        int x, y, cnt;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static void bfs() {
        while (!jihoon.isEmpty()) {
            int size = jihoon.size();
            for (int i = 0; i < size; i++) {
                Point p = jihoon.poll();
                jihoonVisited[p.x][p.y] = true;
                if (arr[p.x][p.y] == 'F') continue;
                for (int j = 0; j < 4; j++) {
                    int px = p.x + dx[j];
                    int py = p.y + dy[j];
                    if (px < 0 || py < 0 || px >= R || py >= C) {
                        result = p.cnt;
                        return;
                    }
                    if (arr[px][py] == '#' || arr[px][py] == 'F') continue;
                    if (jihoonVisited[px][py]) continue;
                    jihoonVisited[px][py] = true;
                    arr[px][py] = 'J';
                    jihoon.offer(new Point(px, py, p.cnt + 1));
                }
            }
            size = fire.size();
            for (int i = 0; i < size; i++) {
                Point point = fire.poll();
                fireVistied[point.x][point.y] = true;
                for (int j = 0; j < 4; j++) {
                    int px = point.x + dx[j];
                    int py = point.y + dy[j];

                    if (px < 0 || py < 0 || px >= R || py >= C) continue;
                    if (arr[px][py] == '#') continue;
                    if (fireVistied[px][py]) continue;
                    arr[px][py] = 'F';
                    fireVistied[px][py] = true;
                    fire.offer(new Point(px, py));
                }
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        fireVistied = new boolean[R][C];
        jihoonVisited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = s.charAt(j);
                if (arr[i][j] == 'J') {
                    jihoon.offer(new Point(i, j, 1));
                }
                if (arr[i][j] == 'F') {
                    fire.offer(new Point(i, j));
                }
            }
        }
        bfs();
        if (result == 0) bw.write("IMPOSSIBLE\n");
        else bw.write(result + "\n");
        bw.close();
        br.close();
    }
}
