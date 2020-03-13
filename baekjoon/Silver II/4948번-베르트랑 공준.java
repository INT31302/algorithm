package app;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int input = Integer.parseInt(br.readLine());
        boolean isPrimary = true;
        int cnt = 0;
        boolean[] dp = new boolean[246913];
        int size = dp.length;
        for (int i = 2; i < size; i++) {
            isPrimary = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrimary = false;
                    break;
                }
            }
            if (isPrimary)
                dp[i] = true;

        }
        while (input != 0) {
            for (int i = input + 1; i <= 2 * input; i++) {
                if (dp[i])
                    cnt++;
            }
            bw.write(cnt + "\n");
            cnt = 0;
            input = Integer.parseInt(br.readLine());
        }
        bw.flush();
        bw.close();
        br.close();
    }
}