package app;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(input.nextToken());
        int M = Integer.parseInt(input.nextToken());
        TreeMap<String, String> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            input = new StringTokenizer(br.readLine());
            map.put(input.nextToken(), input.nextToken());
        }
        for (int i = 0; i < M; i++) {
            bw.write(map.get(br.readLine()) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}