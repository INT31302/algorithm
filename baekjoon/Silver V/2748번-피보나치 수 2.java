package app;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] dp = new long[91];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < 91; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int n = Integer.parseInt(br.readLine());
        bw.write(dp[n] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}