import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int[][] arr;
    static boolean[][] visited;
    static int idx;
    static int cnt;
    static int[] dx = {0, 0, 1};
    static int[] dy = {-1, 1, 0};

    static class Point {
        int x, y, cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static void bfs(int x, int y) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(x, y, 1));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.x == 99) {
                if (p.cnt <= cnt) {
                    idx = y;
                    cnt = p.cnt;
                }
                return;
            }
            for (int i = 0; i < 3; i++) {
                int px = p.x + dx[i];
                int py = p.y + dy[i];
                if (px < 0 || py < 0 || px >= 100 || py >= 100) continue;
                if (visited[px][py]) continue;
                if (arr[px][py] == 0) continue;
                visited[px][py] = true;
                queue.offer(new Point(px, py, p.cnt + 1));
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            cnt = Integer.MAX_VALUE;
            idx = 100;
            int N = Integer.parseInt(br.readLine());
            arr = new int[100][100];

            bw.write("#" + N + " ");
            for (int j = 0; j < 100; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 100; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            for (int j = 0; j < 100; j++) {
                if (arr[0][j] == 0) continue;
                visited = new boolean[100][100];
                bfs(0, j);
            }
            bw.write(idx + "\n");
        }
        br.close();
        bw.close();
    }
}
