package app;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = "";
        int str_Length = 0;
        Loop1: while (true) {
            input = br.readLine();
            if (input.equals("0"))
                break;
            str_Length = input.length();
            if (str_Length == 1) {
                bw.write("yes\n");
            } else {
                for (int i = 0; i < str_Length / 2; i++) {
                    if (input.charAt(i) != input.charAt(str_Length - i - 1)) {
                        bw.write("no\n");
                        continue Loop1;
                    }
                }
                bw.write("yes\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}