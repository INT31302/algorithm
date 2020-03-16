package app;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int i = 2;
        while (N != 1) {
            if (N % i == 0) {
                N /= i;
                bw.write(i + "\n");
                i = 2;
            } else
                i++;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}