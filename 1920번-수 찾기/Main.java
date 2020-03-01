package app;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int N = Integer.parseInt(br.readLine());
            Set<Integer> A = new HashSet<>();
            StringTokenizer temp = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A.add(Integer.parseInt(temp.nextToken()));
            }
            int M = Integer.parseInt(br.readLine());
            temp = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                if (A.contains(Integer.parseInt(temp.nextToken())))
                    bw.write("1\n");
                else
                    bw.write("0\n");
            }
            bw.close();
            br.close();
        } catch (IOException e) {

        }
    }
}