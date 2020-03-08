package app;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int N = Integer.parseInt(br.readLine());
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            StringTokenizer temp = new StringTokenizer(br.readLine());
            int num_temp;
            for (int i = 0; i < N; i++) {
                num_temp = Integer.parseInt(temp.nextToken());
                if (hashMap.containsKey(num_temp)) {
                    hashMap.put(num_temp, hashMap.get(num_temp) + 1);
                } else {
                    hashMap.put(num_temp, 1);
                }
            }
            int M = Integer.parseInt(br.readLine());
            temp = new StringTokenizer(br.readLine());
            Integer cnt;
            for (int i = 0; i < M; i++) {
                if (i != 0)
                    bw.write(" ");
                num_temp = Integer.parseInt(temp.nextToken());
                cnt = hashMap.get(num_temp);
                if (cnt == null)
                    bw.write("0");
                else
                    bw.write(cnt + "");
            }
            bw.write("\n");
            bw.close();
            br.close();
        } catch (IOException e) {

        }
    }
}