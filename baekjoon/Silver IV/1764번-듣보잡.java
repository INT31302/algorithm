package app;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer input = new StringTokenizer(br.readLine());
        List<String> list = new ArrayList<>();
        List<String> result = new ArrayList<>();
        int N = Integer.parseInt(input.nextToken());
        int M = Integer.parseInt(input.nextToken());
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }
        if (list.size() > 0) {
            Collections.sort(list);
            String temp;
            for (int i = 0; i < M; i++) {
                temp = br.readLine();
                if (Collections.binarySearch(list, temp) >= 0) {
                    result.add(temp);
                }
            }
            if (result.size() > 0) {
                Collections.sort(result);
                int size = result.size();
                bw.write(size + "\n");
                for (int i = 0; i < size; i++) {
                    bw.write(result.get(i) + "\n");
                }
            } else {
                bw.write("0\n");
            }
        } else {
            bw.write("0\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}