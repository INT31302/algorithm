package app;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, R, S = 1, MIN;
    static int[][] array, dir;
    static LinkedList<Integer> Queue = new LinkedList<>();

    private static void arrayRotation() throws Exception {
        if (S > MIN) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++)
                    bw.write(array[i][j] + " ");
                bw.write("\n");
            }
            bw.flush();
            bw.close();
            return;
        }
        for (int i = 0; i < R; i++)
            moveArray();
        dir[0][0]++;
        dir[0][1]++;
        dir[1][0]--;
        dir[1][1]++;
        dir[2][0]--;
        dir[2][1]--;
        dir[3][0]++;
        dir[3][1]--;
        ++S;
        arrayRotation();
    }

    private static void moveArray() {
        Queue.clear();
        int x = dir[0][0];
        int y = dir[0][1];
        int sizeX = dir[1][0] - x + 1;
        int sizeY = dir[3][1] - y + 1;
        Queue.push(array[x][y]);
        for (int i = 0; i < 4; i++) {
            x = dir[i][0];
            y = dir[i][1];
            if (i == 0 || i == 2) {
                for (int j = 1; j < sizeX; j++) {
                    if (i == 0) {
                        Queue.push(array[x + j][y]);
                        array[x + j][y] = Queue.pollLast();
                    } else {
                        Queue.push(array[x - j][y]);
                        array[x - j][y] = Queue.pollLast();
                    }
                }
            } else {
                for (int j = 1; j < sizeY; j++) {
                    if (i == 1) {
                        Queue.push(array[x][y + j]);
                        array[x][y + j] = Queue.pollLast();
                    } else {
                        Queue.push(array[x][y - j]);
                        array[x][y - j] = Queue.pollLast();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        MIN = Math.min(M, N) / 2;
        array = new int[N][M];
        dir = new int[4][2];
        dir[1][0] = N - 1;
        dir[2][0] = N - 1;
        dir[2][1] = M - 1;
        dir[3][1] = M - 1;
        boolean isSame = true;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
                if (j != 0 && isSame) {
                    if (array[i][j] != array[i][j - 1])
                        isSame = false;
                }
            }
            if (i != 0 && isSame) {
                if (array[i][0] != array[i - 1][0])
                    isSame = false;
            }
        }
        br.close();
        if (isSame) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++)
                    bw.write(array[i][j] + " ");
                bw.write("\n");
            }
            bw.flush();
            bw.close();
        } else
            arrayRotation();
    }
}