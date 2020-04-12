package app;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] array;
    private static int[] count = new int[3];
    static int N;

    private static boolean check(int row, int col, int n) {
        int std = array[row][col];
        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + n; j++) {
                if (std != array[i][j])
                    return false;
            }
        }
        return true;
    }

    private static void calc(int row, int col, int n) {
        if (check(row, col, n)) {
            count[array[row][col] + 1]++;
        } else {
            int s = n / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    calc(row + s * i, col + s * j, s);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        array = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                array[i][j] = Integer.parseInt(st.nextToken());
        }
        calc(0, 0, N);
        for (int i = 0; i < 3; i++) {
            bw.write(count[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}