package app;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        while (num1 != 0 || num2 != 0) {
            if (num1 / num2 > 0 && num1 % num2 == 0)
                bw.write("multiple\n");
            else if (num2 / num1 > 0 && num2 % num1 == 0)
                bw.write("factor\n");
            else
                bw.write("neither\n");
            st = new StringTokenizer(br.readLine());
            num1 = Integer.parseInt(st.nextToken());
            num2 = Integer.parseInt(st.nextToken());
        }
        bw.flush();
        bw.close();
        br.close();
    }
}