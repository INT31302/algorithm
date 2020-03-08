package app;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int min1 = 2000, min2 = 2000;
        int result;
        for (int i = 0; i < 5; i++) {
            if (i < 3)
                min1 = Math.min(min1, Integer.parseInt(br.readLine()));
            else
                min2 = Math.min(min2, Integer.parseInt(br.readLine()));
        }
        result = min1 + min2 - 50;
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}