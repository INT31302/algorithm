package app;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        Loop1: for (int i = 1; i <= B; i++) {
            for (int j = 0; j < i; j++) {
                list.add(i);
                if (list.size() == B)
                    break Loop1;
            }
        }
        int sum = 0;
        for (int i = A - 1; i < B; i++)
            sum += list.get(i);
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}