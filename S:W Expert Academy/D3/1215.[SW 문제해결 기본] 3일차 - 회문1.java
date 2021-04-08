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

    static class WordPoint {
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
            if (startPoint.x == wordPoint.startPoint.x &&
                    startPoint.y == wordPoint.startPoint.y &&
                    endPoint.x == wordPoint.endPoint.x &&
                    endPoint.y == wordPoint.endPoint.y) return true;
            else return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
        }
    }

    static void dfs(int startX, int startY, int endX, int endY, int depth, char di, StringBuilder s) {
        if (depth == len) {
            StringBuilder reverseS = new StringBuilder(s);
            reverseS.reverse();

            if (s.toString().equals(reverseS.toString())) {
                if (startX == endX) {
                    if (startY > endY) {
                        int temp = startY;
                        startY = endY;
                        endY = temp;
                    }
                } else {
                    if (startX > endX) {
                        int temp = startX;
                        startX = endX;
                        endX = temp;
                    }
                }
                result.add(new WordPoint(new Point(startX, startY), new Point(endX, endY)));
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

        for (int i = 0; i < 10; i++) {
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
