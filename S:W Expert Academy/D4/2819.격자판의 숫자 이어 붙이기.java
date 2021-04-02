import java.io.*;
import java.util.*;

public class Solution {
    static int[][] arr;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static HashSet<String> set;

    static class Point {
        int x, y, cnt;
        String str;

        public Point(int x, int y, int cnt, String str) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.str = str;
        }
    }

    static void bfs(int x, int y) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(x, y, 1, Integer.toString(arr[x][y])));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.cnt == 7) {
                set.add(p.str);
            }
            if (p.cnt == 8) continue;
            for (int i = 0; i < 4; i++) {
                int px = p.x + dx[i];
                int py = p.y + dy[i];
                if (px < 0 || py < 0 || px >= 4 || py >= 4) continue;
                queue.offer(new Point(px, py, p.cnt + 1, p.str + arr[px][py]));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            bw.write("#" + (i + 1) + " ");
            arr = new int[4][4];
            set = new HashSet<>();
            for (int j = 0; j < 4; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 4; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    bfs(j, k);
                }
            }
            bw.write(set.size()+"\n");
        }
        bw.close();
        br.close();
    }
}
