
import java.io.*;
import java.util.PriorityQueue;

public class Solution {
    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = Integer.MAX_VALUE;

    static class Point implements Comparable<Point> {
        int x, y, value;

        public Point(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(Point o) {
            return this.value - o.value;
        }
    }

    static void bfs() {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(0, 0, arr[0][0]));
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            if (p.x == N - 1 && p.y == N - 1) {
                result = Math.min(result, p.value);
            }
            for (int i = 0; i < 4; i++) {
                int pX = p.x + dx[i];
                int pY = p.y + dy[i];
                if (pX < 0 || pY < 0 || pX > N - 1 || pY > N - 1) continue;
                if (visited[pX][pY]) continue;
                visited[pX][pY] = true;
                pq.offer(new Point(pX, pY, p.value + arr[pX][pY]));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            bw.write("#"+(i+1)+" ");
            arr = new int[N][N];
            visited = new boolean[N][N];
            for (int j = 0; j < N; j++) {
                String[] split = br.readLine().split("");
                for (int k = 0; k < N; k++) {
                    arr[j][k] = Integer.parseInt(split[k]);
                }
            }
            bfs();
            bw.write(result + "\n");
            result = Integer.MAX_VALUE;
        }
        bw.close();
        br.close();
    }
}
