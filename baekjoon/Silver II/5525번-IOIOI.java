package app;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();
        int cnt = 0;
        int temp_cnt = 0;
        for (int i = 1; i < M - 1; i++) {
            if (S.charAt(i - 1) == 'I' && S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
                temp_cnt++;
                i++;
                if (temp_cnt == N) {
                    temp_cnt--;
                    cnt++;
                }
            } else
                temp_cnt = 0;
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}