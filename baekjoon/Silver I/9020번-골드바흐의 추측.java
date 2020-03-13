package app;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[10001];
        int size = dp.length;
        boolean isPrimary = true;
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

        int num;
        int min = Integer.MAX_VALUE;
        int[] array = new int[2];
        int result;
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(br.readLine());
            min = Integer.MAX_VALUE;
            for (int j = 2; j <= num; j++) {
                if (dp[j]) {
                    if (dp[num - j]) {
                        result = Math.abs((num - j) - j);
                        if (min > result) {
                            min = result;
                            array[0] = j;
                            array[1] = num - j;
                        }
                    }
                }
            }
            bw.write(array[0] + " " + array[1] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}