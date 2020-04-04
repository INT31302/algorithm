package app;

import java.io.*;
import java.util.*;

public class Main {
    private static int X, cnt;
    private static LinkedList<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        X = Integer.parseInt(br.readLine());
        list = new LinkedList<>();
        list.add(64);
        int size, sum;
        while (list.get(0) != 0) {
            size = list.size();
            sum = 0;
            for (int i = 0; i < size; i++)
                sum += list.get(i);
            if (sum > X) {
                Collections.sort(list);
                list.add(0, list.getFirst() / 2);
                list.remove(1);
                if (sum - list.get(0) < X)
                    list.add(list.get(0));
            } else if (sum == X) {
                bw.write(list.size() + "\n");
                break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}