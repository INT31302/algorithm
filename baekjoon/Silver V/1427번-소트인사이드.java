package app;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList<>();
        String[] str = br.readLine().split("");
        int size = str.length;
        for (int i = 0; i < size; i++) {
            list.add(Integer.parseInt(str[i]));
        }
        Collections.sort(list, Comparator.reverseOrder());
        for (int i = 0; i < size; i++) {
            bw.write(list.get(i) + "");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }
}