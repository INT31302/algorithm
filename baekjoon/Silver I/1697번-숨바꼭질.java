import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K, result;
    static int[] arr = new int[100001];
    static boolean[] visited = new boolean[100001];

    static class Point {
        int p, cnt;

        public Point(int p, int cnt) {
            this.p = p;
            this.cnt = cnt;
        }
    }

    static void bfs() {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(N, 0));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (arr[p.p] == 2) {
                result = p.cnt;
                return;
            }
            if (p.p - 1 >= 0 && !visited[p.p - 1]) {
                visited[p.p - 1] = true;
                queue.offer(new Point(p.p - 1, p.cnt + 1));
            }
            if (p.p + 1 <= 100000 && !visited[p.p + 1]) {
                visited[p.p + 1] = true;
                queue.offer(new Point(p.p + 1, p.cnt + 1));
            }
            if (p.p * 2 <= 100000 && !visited[p.p * 2]) {
                visited[p.p * 2] = true;
                queue.offer(new Point(p.p * 2, p.cnt + 1));
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr[N] = 1;
        arr[K] = 2;
        bfs();
        bw.write(result + "\n");
        bw.close();
        br.close();
    }
}
