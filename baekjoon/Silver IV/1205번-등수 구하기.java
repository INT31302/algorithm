package app;

import java.io.*;
import java.util.*;

public class Main {
    private static LinkedList<Integer> list;
    private static int rank = 0, cnt, N, SCORE, P;

    private static void rankedList() {
        int size = list.size();
        int temp = 0;
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                rank = 1;
                temp = list.get(i);
            } else {
                if (temp == list.get(i))
                    cnt++;
                else {
                    rank += cnt + 1;
                    cnt = 0;
                }
                temp = list.get(i);
            }

            if (list.get(i) == SCORE)
                return;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        SCORE = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        if (N == 0)
            bw.write(1 + "\n");
        else {
            st = new StringTokenizer(br.readLine());
            list = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            if (list.peekLast() >= SCORE) { // 꼴등과 같거나 작을 경우
                if (list.size() != P) { // 랭킹 진입이 가능한 경우
                    list.add(SCORE);
                    rankedList();
                    bw.write(rank + "\n");
                } else
                    bw.write(-1 + "\n");
            } else {
                list.add(SCORE);
                Collections.sort(list, Collections.reverseOrder());
                rankedList();
                bw.write(rank + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();

    }
}