package app;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            list.add(i + 1);
        }
        bw.write("<");
        int cnt = 0;
        while (!list.isEmpty()) {
            if (cnt != K - 1) {
                list.add(list.pop());
                cnt++;
            } else {
                if (list.size() != 1)
                    bw.write(list.pop() + ", ");
                else
                    bw.write(list.pop() + ">");
                cnt = 0;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}