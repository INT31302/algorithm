package app;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());

        }
        for (int i = N - 1; i >= 0; i--) {
            if (K / array[i] > 0) {
                cnt += K / array[i];
                K %= array[i];
            }
            if (K == 0)
                break;
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}