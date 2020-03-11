package app;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        int sum = list.get(0);
        int temp;
        for (int i = 1; i < N; i++) {
            temp = list.get(i - 1) + list.get(i);
            sum += temp;
            list.set(i, temp);
        }
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}