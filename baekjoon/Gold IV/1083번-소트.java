package app;

import java.io.*;
import java.util.*;

public class Main {
    static int N, S;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        LinkedList<Integer> arr = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr.add(Integer.parseInt(st.nextToken()));
        S = Integer.parseInt(br.readLine());
        int next = 0;
        int S_Index, S_Max;
        while (S != 0 && next != N) {
            S_Index = next;
            S_Max = arr.get(S_Index);
            for (int i = next; i < N; ++i) {
                if (arr.get(i) > S_Max && i - next <= S) {
                    S_Index = i;
                    S_Max = arr.get(i);
                }
            }
            if (S_Index != next) {
                arr.remove(S_Index);
                arr.add(next, S_Max);
            }
            S -= S_Index - next;
            ++next;
        }

        for (int i = 0; i < N; i++) {
            bw.write(arr.get(i) + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
