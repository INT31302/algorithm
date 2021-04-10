import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

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
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (arr[p.x][p.y] == 3) return true;
            for (int i = 0; i < 4; i++) {
                int px = p.x + dx[i];
                int py = p.y + dy[i];
                if (px < 0 || py < 0 || px >= 100 || py >= 100) continue;
                if (visited[px][py]) continue;
                if (arr[px][py] == 1) continue;
                visited[px][py] = true;
                queue.offer(new Point(px, py));
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            int N = Integer.parseInt(br.readLine());
            bw.write("#" + N + " ");
            arr = new int[100][100];
            visited = new boolean[100][100];
            int x = 0, y = 0;
            for (int j = 0; j < 100; j++) {
                String s = br.readLine();
                for (int k = 0; k < 100; k++) {
                    arr[j][k] = s.charAt(k) - '0';
                    if (arr[j][k] == 2) {
                        x = j;
                        y = k;
                    }
                }
            }
            if (bfs(x, y)) bw.write(1 + "\n");
            else bw.write(0 + "\n");

        }
        bw.close();
        br.close();
    }
}
