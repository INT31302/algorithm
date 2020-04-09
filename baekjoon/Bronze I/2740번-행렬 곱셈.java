package app;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] array1, array2;

    private static int[][] init(int N, int M) throws Exception {
        StringTokenizer st;
        int[][] array = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return array;
    }

    private static int calc(int x, int y) {
        int sum = 0;
        int size1 = array1[0].length;
        for (int i = 0; i < size1; i++)
            sum += array1[x][i] * array2[i][y];
        return sum;
    }

    public static void main(String[] args) throws Exception {
        StringTokenizer st;
        int N, M;

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (i == 0)
                array1 = init(N, M);
            else
                array2 = init(N, M);
        }
        int[][] array3 = new int[array1.length][array2[0].length];
        N = array3.length;
        M = array3[0].length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                array3[i][j] = calc(i, j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bw.write(array3[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}