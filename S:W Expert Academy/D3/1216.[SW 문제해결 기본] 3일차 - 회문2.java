import java.io.*;
public class Solution {
    static char[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    //    static Set<WordPoint> set;
//
//    static class WordPoint{
//        int startX, startY, endX, endY;
//
//        public WordPoint(int startX, int startY, int endX, int endY) {
//            this.startX = startX;
//            this.startY = startY;
//            this.endX = endX;
//            this.endY = endY;
//        }
//    }
    static int result;

    static void dfs(int x, int y, char direction, StringBuilder sb) {
        StringBuilder tempSb = new StringBuilder(sb);
        tempSb.reverse();
        if (tempSb.toString().equals(sb.toString())) {
            result = Math.max(result, sb.length());
        }
        int px = 0, py = 0;
        if (direction == 'u') {
            px = x + dx[0];
            py = y + dy[0];
        } else if (direction == 'd') {
            px = x + dx[1];
            py = y + dy[1];
        } else if (direction == 'l') {
            px = x + dx[2];
            py = y + dy[2];
        } else if (direction == 'r') {
            px = x + dx[3];
            py = y + dy[3];
        }
        if (px < 0 || py < 0 || px >= 100 || py >= 100) return;
        sb.append(arr[px][py]);
        dfs(px, py, direction, sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            int N = Integer.parseInt(br.readLine());
            bw.write("#" + N + " ");
            result = 0;
            arr = new char[100][100];
            for (int j = 0; j < 100; j++) {
                String st = br.readLine();
                for (int k = 0; k < 100; k++) {
                    arr[j][k] = st.charAt(k);
                }
            }
            for (int j = 0; j < 100; j++) {
                for (int k = 0; k < 100; k++) {
                    StringBuilder s = new StringBuilder();
                    s.append(arr[j][k]);
                    dfs(j, k, 'u', new StringBuilder(s));
                    dfs(j, k, 'd', new StringBuilder(s));
                    dfs(j, k, 'l', new StringBuilder(s));
                    dfs(j, k, 'r', new StringBuilder(s));
                }
            }
            bw.write(result + "\n");
        }
        bw.close();
        br.close();
    }
}
