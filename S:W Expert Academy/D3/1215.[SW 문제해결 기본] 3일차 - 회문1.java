import java.io.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution {
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int len;
    static Set<WordPoint> result;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class WordPoint{
        Point startPoint;
        Point endPoint;

        public WordPoint(Point startPoint, Point endPoint) {
            this.startPoint = startPoint;
            this.endPoint = endPoint;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            WordPoint wordPoint = (WordPoint) o;
            if (this.startPoint.x == wordPoint.startPoint.x &&
                    this.startPoint.y == wordPoint.startPoint.y &&
                    this.endPoint.x == wordPoint.endPoint.x &&
                    this.endPoint.y == wordPoint.endPoint.y) {
                return true;
            } else if (this.startPoint.x == wordPoint.endPoint.x &&
                    this.startPoint.y == wordPoint.endPoint.y &&
                    this.endPoint.x == wordPoint.startPoint.x &&
                    this.endPoint.y == wordPoint.startPoint.y) {
                return true;
            } else if (this.endPoint.x == wordPoint.startPoint.x &&
                    this.endPoint.y == wordPoint.startPoint.y &&
                    this.startPoint.x == wordPoint.endPoint.x &&
                    this.startPoint.y == wordPoint.endPoint.y) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return Objects.hash(startPoint, endPoint);
        }
    }

    static void dfs(int startX, int startY, int endX, int endY, int depth, char di, StringBuilder s) {
        if (depth == len) {
            StringBuilder temp = new StringBuilder(s);
            temp.reverse();

            if (s.toString().equals(temp.toString())) {
                result.add(new WordPoint(new Point(startX, startY), new Point(endX, endY)));
                System.out.println(s.toString());
                System.out.println(startX + " " + startY + " " + endX + " " + endY);

                System.out.println();
            }
            return;
        }
        int px = 0, py = 0;
        if (di == 'l') {
            px = endX + dx[0];
            py = endY + dy[0];
        } else if (di == 'r') {
            px = endX + dx[1];
            py = endY + dy[1];
        } else if (di == 'u') {
            px = endX + dx[2];
            py = endY + dy[2];
        } else if (di == 'd') {
            px = endX + dx[3];
            py = endY + dy[3];
        }
        if (px < 0 || py < 0 || px >= 8 || py >= 8) return;
        dfs(startX, startY, px, py, depth + 1, di, s.append(arr[px][py]));
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 1; i++) {
            bw.write("#" + (i + 1) + " ");
            len = Integer.parseInt(br.readLine());
            arr = new char[8][8];
            visited = new boolean[8][8];
            result = new HashSet<>();
            for (int j = 0; j < 8; j++) {
                String temp = br.readLine();
                for (int k = 0; k < 8; k++) {
                    arr[j][k] = temp.charAt(k);
                }
            }
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    StringBuilder s = new StringBuilder();
                    s.append(arr[j][k]);
                    dfs(j, k, j, k, 1, 'l', new StringBuilder(s));
                    dfs(j, k, j, k, 1, 'r', new StringBuilder(s));
                    dfs(j, k, j, k, 1, 'u', new StringBuilder(s));
                    dfs(j, k, j, k, 1, 'd', new StringBuilder(s));
                }
            }

            bw.write(result.size() + "\n");
        }
        bw.close();
        br.close();
    }
}
