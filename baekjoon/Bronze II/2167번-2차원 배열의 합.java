package app;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int sameRow(int[][] dp, int index, int min, int max) {
        int sum = 0;
        for (; min <= max; min++) {
            sum += dp[index][min];
        }
        return sum;
    }

    public static int sameCol(int[][] dp, int index, int min, int max) {
        int sum = 0;
        for (; min <= max; min++) {
            sum += dp[min][index];
        }
        return sum;
    }

    public static int diffrentBoth(int[][] dp, int i, int j, int x, int y) {
        int sum = 0;
        int temp = j;
        for (; i <= x; i++) {
            for (j = temp; j <= y; j++) {
                sum += dp[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(input.nextToken());
        int M = Integer.parseInt(input.nextToken());
        int[][] dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            input = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                dp[i][j] = Integer.parseInt(input.nextToken());
            }
        }
        int K = Integer.parseInt(br.readLine());
        int sum;
        for (int z = 0; z < K; z++) {
            input = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(input.nextToken()) - 1;
            int j = Integer.parseInt(input.nextToken()) - 1;
            int x = Integer.parseInt(input.nextToken()) - 1;
            int y = Integer.parseInt(input.nextToken()) - 1;
            if (i == x)
                sum = sameRow(dp, i, j, y);
            else if (j == y)
                sum = sameCol(dp, j, i, x);
            else
                sum = diffrentBoth(dp, i, j, x, y);
            bw.write(sum + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}