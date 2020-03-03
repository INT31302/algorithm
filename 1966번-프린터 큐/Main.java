package app;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int N = Integer.parseInt(br.readLine());
            int M, index;
            String[] temp;
            Integer[] rank;
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                temp = br.readLine().split(" ");
                M = Integer.parseInt(temp[0]);
                index = Integer.parseInt(temp[1]);
                rank = new Integer[M];
                temp = br.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    queue.add(Integer.parseInt(temp[j]));
                    rank[j] = Integer.parseInt(temp[j]);
                }
                Arrays.sort(rank, Comparator.reverseOrder());
                if (M == 1)
                    bw.write("1\n");
                else {
                    int cnt = 0;
                    int iTemp;
                    while (true) {
                        iTemp = queue.poll();
                        if (iTemp == rank[cnt]) {
                            cnt++;
                            if (index == 0) {
                                bw.write(cnt + "\n");
                                break;
                            }
                            index--;
                        } else {
                            queue.add(iTemp);
                            if (index == 0) {
                                index = queue.size() - 1;
                            } else
                                index--;
                        }
                    }
                }
                queue.clear();
            }
            bw.close();
            br.close();
        } catch (IOException e) {
        }
    }
}