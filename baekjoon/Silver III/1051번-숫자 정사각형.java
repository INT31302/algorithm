package app;

import java.io.*;

public class Main {
    static int[][] array;
    static int max = 0, N, M, length = 0;

    private static void find(int n, int x, int y) {
        // 가로 찾기
        for (int i = y + 1; i < M; i++) {
            length++;
            if (array[x][i] == n) {// 찾았을 경우
                if (x + length < N) {
                    if (array[x + length][y] == n) { // 세로 꼭짓점도 같을 경우
                        if (array[x + length][i] == n) { // 대각선 꼭짓점과 같은 경우
                            int width = (int) Math.pow(length + 1, 2);
                            max = max < width ? width : max;
                        }
                    }
                }
            }
        }
        length = 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sp = br.readLine().split(" ");
        N = Integer.parseInt(sp[0]);
        M = Integer.parseInt(sp[1]);
        array = new int[N][M];
        for (int i = 0; i < N; i++) {
            sp = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(sp[j]);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                find(array[i][j], i, j);
            }
        }
        if (max == 0)
            bw.write(1 + "\n");
        else
            bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}