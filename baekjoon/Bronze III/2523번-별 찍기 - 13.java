package app;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                bw.write("*");
            }
            bw.write("\n");
        }
        for (int i = N - 1; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        sc.close();
    }
}