package app;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {

            int[] num = new int[2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < num.length; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            int min_num = num[0] <= num[1] ? num[0] : num[1];
            int max = 0;
            int min = 1;
            for (int i = 1; i <= min_num; i++) {
                if (num[0] % i == 0 && num[1] % i == 0) {
                    if (max < i)
                        max = i;
                }
            }
            for (int i = 0; i < 2; i++) {
                min *= num[i] / max;
            }
            min *= max;

            bw.write(max + "\n" + min);
            bw.close();
            br.close();
        } catch (IOException e) {

        }
    }
}