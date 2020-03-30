package app;

import java.io.*;
import java.util.*;

public class Main {
    static boolean[] sArray;
    static int N, M;

    private static void switchArray(int student, int num) {
        int size = sArray.length;
        if (student == 1) {
            int i = 1;
            int index = num * i++;
            while (index - 1 < size) {
                sArray[index - 1] = !sArray[index - 1];
                index = num * i++;
            }
        } else {
            int left = num - 2, right = num;
            sArray[num - 1] = !sArray[num - 1];
            while (left >= 0 && right < size) {
                if (sArray[left] == sArray[right]) {
                    sArray[left] = sArray[right] = !sArray[left];
                    --left;
                    ++right;
                } else
                    break;

            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        sArray = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (st.nextToken().equals("1"))
                sArray[i] = true;
        }
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            switchArray(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int temp;
        for (int i = 0; i < N; i++) {
            temp = sArray[i] ? 1 : 0;
            bw.write(temp + "");
            if ((i + 1) % 20 == 0)
                bw.write("\n");
            else
                bw.write(" ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }
}