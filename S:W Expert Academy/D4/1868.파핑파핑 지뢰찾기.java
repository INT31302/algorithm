import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    static char[][] arr;
    static boolean[][] visited;
    static Queue<Point> zeroQue = new ArrayDeque<>();
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int N;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int check(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int pX = x + dx[i];
            int pY = y + dy[i];
            if (pX < 0 || pY < 0 || pX >= N || pY >= N) continue;
            if (arr[pX][pY] == '*') cnt++;
        }
        return cnt;
    }

    static void bfs(int x, int y) {
        Queue<Point> queue = new ArrayDeque();
        visited[x][y] = true;
        if (arr[x][y] != '0') arr[x][y] = (char) (check(x, y) + '0');
        queue.offer(new Point(x, y));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (arr[p.x][p.y] == '0') {
                for (int i = 0; i < 8; i++) {
                    int pX = p.x + dx[i];
                    int pY = p.y + dy[i];
                    if (pX < 0 || pY < 0 || pX >= N || pY >= N) continue;
                    if (visited[pX][pY]) continue;
                    if (arr[pX][pY] == '*') continue;
                    visited[pX][pY] = true;
                    arr[pX][pY] = (char) (check(pX, pY) + '0');
                    queue.offer(new Point(pX, pY));
                }
            } else {
                visited[p.x][p.y] = true;
                arr[p.x][p.y] = (char) (check(p.x, p.y) + '0');
            }

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            bw.write("#" + (i + 1) + " ");
            int cnt = 0;
            arr = new char[N][N];
            visited = new boolean[N][N];
            for (int j = 0; j < N; j++) {
                String s = br.readLine();
                for (int k = 0; k < N; k++) {
                    arr[j][k] = s.charAt(k);
                }
            }
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (arr[j][k] != '*' && check(j, k) == 0) {
                        arr[j][k] = '0';
                        zeroQue.offer(new Point(j, k));
                    }
                }
            }
            while (!zeroQue.isEmpty()) {
                Point p = zeroQue.poll();
                if(visited[p.x][p.y]) continue;
                bfs(p.x, p.y);
                cnt++;
            }
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (arr[j][k] == '*') continue;
                    if (visited[j][k]) continue;
                    bfs(j, k);
                    cnt++;
                }
            }
            bw.write(cnt + "\n");
        }
        br.close();
        bw.close();
    }
}
