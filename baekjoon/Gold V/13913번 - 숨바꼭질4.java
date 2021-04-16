import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int N, K;
    static Point result;

    static class Point {
        int x, cnt;
        ArrayDeque<Integer> arr;

        public Point(int x, int cnt, ArrayDeque<Integer> arr) {
            this.x = x;
            this.cnt = cnt;
            this.arr = arr;
        }
    }

    static void bfs() {
        Queue<Point> queue = new ArrayDeque<>();
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        arr.offer(N);
        queue.offer(new Point(N, 0, arr));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            visited[p.x] = true;
            if (p.x == K) {
                result = p;
                return;
            }
            int px;
            for (int i = 0; i < 3; i++) {
                if (i == 0) px = p.x - 1;
                else if (i == 1) px = p.x + 1;
                else px = p.x * 2;
                if (px >= 0 && px <= 100000) {
                    p.arr.offer(px);
                    if (!visited[px]) queue.offer(new Point(px, p.cnt + 1, p.arr.clone()));
                    p.arr.removeLast();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if (N > K) {
            bw.write(N - K + "\n");
            for (int i = N; i >= K; i--) {
                bw.write(i + " ");
            }
        } else if (N == K) {
            bw.write(0 + "\n");
            bw.write(N + "\n");
        } else {
            visited = new boolean[100001];
            bfs();
            bw.write(result.cnt + "\n");
            while (!result.arr.isEmpty()) {
                bw.write(result.arr.poll() + " ");
            }
        }
        bw.close();
        br.close();
    }
}
