package app;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int sum = 2;
        while (N != 0) {
            switch (N % 10) {
                case 0:
                    sum += 4;
                    break;
                case 1:
                    sum += 2;
                    break;
                default:
                    sum += 3;
                    break;
            }
            if (N / 10 != 0) {
                sum++;
                N /= 10;
            } else {
                bw.write(sum + "\n");
                sum = 2;
                N = Integer.parseInt(br.readLine());
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}