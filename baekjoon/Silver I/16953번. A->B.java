import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int A, B, result = Integer.MAX_VALUE;

    static class Point {
        long x;
        int cnt;

        public Point(long x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }

    static void bfs() {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(A, 1));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.x > B) continue;
            if (p.x == B) {
                result = result > p.cnt ? p.cnt : result;
            }
            queue.offer(new Point(p.x * 2, p.cnt + 1));
            queue.offer(new Point(p.x * 10 + 1, p.cnt + 1));
        }
        if (result == Integer.MAX_VALUE) result = -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        bfs();
        bw.write(result + "\n");
        bw.close();
        br.close();

    }
}
