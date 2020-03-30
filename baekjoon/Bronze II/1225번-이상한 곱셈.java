package app;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();
        int sizeA = A.length();
        int sizeB = B.length();
        int intA, intB;
        long result = 0;
        for (int i = 0; i < sizeA; i++) {
            intA = A.charAt(i) - '0';
            for (int j = 0; j < sizeB; j++) {
                intB = B.charAt(j) - '0';
                result += intA * intB;
            }
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}