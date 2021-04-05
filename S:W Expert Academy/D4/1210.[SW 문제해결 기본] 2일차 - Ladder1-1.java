import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1};
    static int[] dy = {-1, 1, 0};

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean bfs(int x, int y) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(x, y));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.x == 99) {
                if (arr[p.x][p.y] == 2) return true;
                return false;
            }
            for (int i = 0; i < 3; i++) {
                int px = p.x + dx[i];
                int py = p.y + dy[i];
                if (px < 0 || py < 0 || px >= 100 || py >= 100) continue;
                if (visited[px][py]) continue;
                if (arr[px][py] == 0) continue;
                visited[px][py] = true;
                queue.offer(new Point(px, py));
                break;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            int N = Integer.parseInt(br.readLine());
            bw.write("#" + (i + 1) + " ");
            arr = new int[100][100];

            for (int j = 0; j < 100; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 100; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 0; j < 100; j++) {
                if (arr[0][j] == 1) {
                    visited = new boolean[100][100];
                    if (bfs(0, j)) {
                        bw.write(j + "\n");
                        break;
                    }
                }
            }

        }
        bw.close();
        br.close();
    }
}
