package app;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        TreeMap<Integer, Integer> X = new TreeMap<>();
        TreeMap<Integer, Integer> Y = new TreeMap<>();
        StringTokenizer st;
        int x, y;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            if (!X.isEmpty()) {
                if (X.containsKey(x)) {
                    X.put(x, X.get(x) + 1);
                } else
                    X.put(x, 1);
            } else
                X.put(x, 1);

            if (!Y.isEmpty()) {
                if (Y.containsKey(y)) {
                    Y.put(y, Y.get(y) + 1);
                } else
                    Y.put(y, 1);
            } else
                Y.put(y, 1);
        }
        Iterator<Integer> itx = X.keySet().iterator();
        int num;
        while (itx.hasNext()) {
            num = itx.next();
            if (X.get(num) == 1)
                bw.write(num + " ");
        }
        Iterator<Integer> ity = Y.keySet().iterator();
        while (ity.hasNext()) {
            num = ity.next();
            if (Y.get(num) == 1)
                bw.write(num + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}