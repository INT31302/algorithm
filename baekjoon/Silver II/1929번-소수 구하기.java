package app;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            /* 해당 숫자가 소수가 아닐 경우 그의 배수도 비소수 처리. */
            String[] input1 = br.readLine().split(" ");
            int start = Integer.parseInt(input1[0]);
            int end = Integer.parseInt(input1[1]);
            boolean[] key = new boolean[end + 1];
            key[0] = key[1] = true;

            for (int i = 2; i * i <= end; i++) {
                if (key[i])
                    continue;
                for (int j = 2 * i; j <= end; j += i) {
                    key[j] = true;
                }
            }
            for (int i = start; i <= end; i++) {
                if (!key[i])
                    bw.write(i + "\n");
            }
            bw.close();
            br.close();
            /* 숫자 하나하나씩 소수인지 판별 */
            String[] input2 = br.readLine().split(" ");
            int M = Integer.parseInt(input2[0]);
            int N = Integer.parseInt(input2[1]);
            boolean flag = true;
            int max;
            for (int i = M; i <= N; i++) {
                max = (int) Math.sqrt(i);
                for (int j = 2; j <= max; j++) {
                    if (i % j == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag == true && i != 1)
                    bw.write(i + "\n");
                flag = true;
            }
            bw.close();
            br.close();
        } catch (IOException e) {
        }
    }
}