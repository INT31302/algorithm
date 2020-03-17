package app;

import java.io.*;
import java.util.*;

public class Main {
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken()) * 2;
        int temp;
        int result;
        for (int i = 0; i < N - 1; i++) {
            temp = Integer.parseInt(st.nextToken()) * 2;
            result = gcd(first, temp);
            bw.write(first / result + "/" + temp / result + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}