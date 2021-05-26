import java.io.*;

public class Main {
    static int size;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    static class Point {
        int startX, startY, endX, endY;

        public Point(int startX, int startY, int endX, int endY) {
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }
    }

    static void dfs(int[][] arr, Point p) {
        if (p.startX == p.endX && p.startY == p.endY) {
            sb.append(arr[p.startX][p.startY]);
            return;
        }
        int prevVal = arr[p.startX][p.startY];
        for (int i = p.startX; i <= p.endX; i++) {
            for (int j = p.startY; j <= p.endY; j++) {
                if (prevVal != arr[i][j]) {
                    sb.append("(");
                    dfs(arr, new Point(p.startX, p.startY, (p.startX + p.endX) / 2, (p.startY + p.endY) / 2)); // 0,0,3,3;
                    dfs(arr, new Point(p.startX, (p.startY + p.endY) / 2 + 1, (p.startX + p.endX) / 2, p.endY)); //0,4,3,7;
                    dfs(arr, new Point((p.startX + p.endX) / 2 + 1, p.startY, p.endX, (p.startY + p.endY) / 2)); //4,0,7,3
                    dfs(arr, new Point((p.startX + p.endX) / 2 + 1, (p.startY + p.endY) / 2 + 1, p.endX, p.endY));//4,4,7,7
                    sb.append(")");
                    return;
                }
            }
        }
        sb.append(arr[p.startX][p.startY]);
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        size = Integer.parseInt(br.readLine());
        arr = new int[size][size];
        for (int i = 0; i < size; i++) {
            String s = br.readLine();
            for (int j = 0; j < size; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        dfs(arr, new Point(0, 0, size - 1, size - 1));
        bw.write(sb.toString() + "\n");
        bw.close();
        br.close();
    }
}
/**
 * input
 * 8
 * 11110000
 * 11110000
 * 00011100
 * 00011100
 * 11110000
 * 11110000
 * 11110011
 * 11110011
 * <p>
 * output
 * ((110(0101))(0010)1(0001))
 * <p>
 * condition
 * 첫째 줄에는 영상의 크기를 나타내는 숫자 N 이 주어진다.
 * N 은 언제나 2의 제곱수로 주어지며, 1 ≤ N ≤ 64의 범위를 가진다.
 * 두 번째 줄부터는 길이 N의 문자열이 N개 들어온다.
 * 각 문자열은 0 또는 1의 숫자로 이루어져 있으며, 영상의 각 점들을 나타낸다.
 */
