package app;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int min = Integer.MAX_VALUE;
        boolean isPrimary = true;
        for (int i = M; i <= N; i++) {
            isPrimary = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrimary = false;
                    break;
                }
            }
            if (isPrimary && i != 1) {
                min = Math.min(i, min);
                sum += i;
            }
        }
        if (sum > 0)
            bw.write(sum + "\n" + min + "\n");
        else
            bw.write("-1\n");
        bw.flush();
        bw.close();
        br.close();
    }
}