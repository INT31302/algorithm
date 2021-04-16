import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K, min = Integer.MAX_VALUE;
    static boolean[] visited;

    static class Point {
        int x, cnt;

        public Point(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }

    static void bfs() {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(N, 0));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            visited[p.x] = true;
            if (p.cnt > min) continue;
            if (p.x == K) {
                if (min > p.cnt) {
                    min = p.cnt;
                }
            }
            if (p.x - 1 >= 0) {
                if (!visited[p.x - 1]) queue.offer(new Point(p.x - 1, p.cnt + 1));
            }
            if (p.x + 1 <= 100000)
                if (!visited[p.x + 1]) queue.offer(new Point(p.x + 1, p.cnt + 1));
            if (p.x * 2 <= 100000)
                if (!visited[p.x * 2]) queue.offer(new Point(p.x * 2, p.cnt));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        bfs();
        bw.write(min + "\n");
        bw.close();
        br.close();
    }
}
