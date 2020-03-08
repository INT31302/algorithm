package app;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int N, K;
            LinkedList<Integer> list = new LinkedList<>();
            String[] temp = br.readLine().split(" ");
            N = Integer.parseInt(temp[0]);
            K = Integer.parseInt(temp[1]) - 1;
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                list.add(i + 1);
            }
            bw.write("<");
            while (true) {
                if (K == 0) {
                    if (list.size() != 1)
                        bw.write(list.removeFirst() + ", ");
                    else
                        bw.write(list.removeFirst() + "");
                    if (list.size() == 0)
                        break;
                } else {
                    if (cnt == K) {
                        if (list.size() != 1)
                            bw.write(list.removeFirst() + ", ");
                        else
                            bw.write(list.removeFirst() + "");
                        cnt = 0;
                    }
                    cnt++;
                    if (list.size() == 0)
                        break;
                    list.addLast(list.removeFirst());
                }
            }
            bw.write(">");
            bw.close();
            br.close();

        } catch (IOException e) {

        }
    }
}