package app;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 0;
        for (int i = N * 2 - 1; i > 0; i -= 2) {
            for (int z = 0; z < cnt; z++) {
                bw.write(" ");
            }
            for (int j = i; j > 0; j--) {
                bw.write("*");
            }
            cnt++;
            bw.write("\n");
        }
        cnt -= 2;
        for (int i = 3; i < N * 2; i += 2) {
            for (int z = cnt; z > 0; z--) {
                bw.write(" ");
            }
            for (int j = 0; j < i; j++) {
                bw.write("*");
            }
            cnt--;
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        sc.close();
    }
}