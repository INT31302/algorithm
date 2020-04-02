package app;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] min = { Integer.MAX_VALUE, Integer.MAX_VALUE };
        int temp, sum;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            temp = Integer.parseInt(st.nextToken());
            if (min[0] > temp)
                min[0] = temp;
            temp = Integer.parseInt(st.nextToken());
            if (min[1] > temp)
                min[1] = temp;
        }
        sum = min[1] * N;
        int cnt = N / 6;
        if (N % 6 != 0)
            ++cnt;
        for (int i = 0; i < cnt; i++) {
            if (6 * (i + 1) > N)
                temp = min[0] * (i + 1);
            else
                temp = min[0] * (i + 1) + min[1] * (N - 6 * (i + 1));
            if (temp < sum)
                sum = temp;
        }
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}