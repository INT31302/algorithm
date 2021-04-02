import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dX = {0, 0, -1, 1};
    static int[] dY = {-1, 1, 0, 0};
    static Point startP, endP;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int bfs() {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(startP);
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (arr[p.x][p.y] == 3) {
                return 1;
            }
            for (int i = 0; i < 4; i++) {
                int pX = p.x + dX[i];
                int pY = p.y + dY[i];
                if (pX < 0 || pY < 0 || pX >= 16 || pY >= 16) continue;
                if (visited[pX][pY]) continue;
                if(arr[pX][pY] == 1) continue;
                visited[pX][pY] = true;
                queue.offer(new Point(pX, pY));
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            int N = Integer.parseInt(br.readLine());
            bw.write("#" + (i + 1) + " ");
            arr = new int[16][16];
            visited = new boolean[16][16];
            for (int j = 0; j < 16; j++) {
                String[] split = br.readLine().split("");
                for (int k = 0; k < 16; k++) {
                    arr[j][k] = Integer.parseInt(split[k]);
                    if (arr[j][k] == 2) startP = new Point(j, k);
                    if (arr[j][k] == 3) endP = new Point(j, k);
                }
            }
            bw.write(bfs()+"\n");
        }
        bw.close();
        br.close();
    }
}
