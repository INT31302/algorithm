package app;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        TreeMap<String, Integer> pokemon_List = new TreeMap<>();
        String[] pokemon_List2 = new String[N];
        int index = 0;
        String input;
        for (int i = 0; i < N; i++) {
            input = br.readLine();
            pokemon_List.put(input, i + 1);
            pokemon_List2[i] = input;
        }
        for (int i = 0; i < M; i++) {
            input = br.readLine();
            try { // 숫자인 경우
                index = Integer.parseInt(input);
                bw.write(pokemon_List2[index - 1] + "\n");

            } catch (NumberFormatException e) { // 문자인 경우
                bw.write(pokemon_List.get(input) + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}