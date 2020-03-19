package app;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Integer> list = new ArrayList<>();
        int a, b, modNum, index;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (a > 10)
                a %= 10;
            for (int j = 1; j <= b; j++) {
                modNum = (int) Math.pow(a, j) % 10;
                if (modNum == 0)
                    modNum = 10;
                if (!list.isEmpty()) {
                    if (list.get(0) == modNum)
                        break;
                    else
                        list.add(modNum);
                } else
                    list.add(modNum);
            }
            index = b % list.size() - 1;
            if (index < 0)
                index = list.size() - 1;
            bw.write(list.get(index) + "\n");
            list.clear();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}