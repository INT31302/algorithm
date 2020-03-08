package app;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int T = Integer.parseInt(br.readLine());
            for (int i = 0; i < T; i++) {
                String temp = br.readLine();
                StringTokenizer st = new StringTokenizer(temp);
                int H = Integer.parseInt(st.nextToken());
                int W = Integer.parseInt(st.nextToken());
                int N = Integer.parseInt(st.nextToken());
                if (N > H * W)
                    return;
                int Y = N % H;
                int X = N / H + 1;
                if (Y == 0) {
                    Y = H;
                    X -= 1;
                }
                if (X < 10)
                    bw.write(Y + "0" + X + "\n");
                else
                    bw.write(Y + "" + X + "\n");
                bw.flush();
            }
            bw.close();
            br.close();
        } catch (IOException e) {

        }
    }
}