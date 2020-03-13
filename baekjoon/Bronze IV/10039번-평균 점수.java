package app;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int sum = 0;
        int temp;
        for (int i = 0; i < 5; i++) {
            temp = Integer.parseInt(br.readLine());
            if (temp < 40)
                temp = 40;
            sum += temp;
        }
        bw.write(sum / 5 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}