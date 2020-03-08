package app;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(br.readLine());
        int n_sqrt = (int) Math.sqrt(n);
        int cnt = 0;
        long[] pow_array = new long[4];
        if (n - Math.pow(n_sqrt, 2) == 0) {
            cnt = 1;
        } else {
            Loop1: for (int i = 1; i <= n_sqrt; i++) {
                pow_array[0] = (long) Math.pow(i, 2);
                for (int j = 1; j <= i; j++) {
                    pow_array[1] = (long) Math.pow(j, 2);
                    for (int k = 1; k <= j; k++) {
                        pow_array[2] = (long) Math.pow(k, 2);
                        for (int z = 1; z <= k; z++) {
                            pow_array[3] = (long) Math.pow(z, 2);
                            if (pow_array[2] + pow_array[3] == n) {
                                if (cnt > 2) {
                                    cnt = 2;
                                    break Loop1;
                                } else
                                    cnt = 2;
                            } else if (pow_array[1] + pow_array[2] + pow_array[3] == n) {
                                cnt = 3;
                            } else if (pow_array[0] + pow_array[1] + pow_array[2] + pow_array[3] == n) {
                                cnt = 4;
                            }
                        }
                    }
                }
            }
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}