package app;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            StringTokenizer input = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(input.nextToken());
            int M = Integer.parseInt(input.nextToken());
            int B = Integer.parseInt(input.nextToken());
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            boolean isSameArray = true;
            int[][] array = new int[N][M];
            for (int i = 0; i < N; i++) {
                input = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    array[i][j] = Integer.parseInt(input.nextToken());
                    min = Math.min(min, array[i][j]);
                    max = Math.max(max, array[i][j]);
                    if (j > 0 && isSameArray) { // 동일 배열일 때만 검사
                        if (array[i][j - 1] != array[i][j]) // column 검사
                            isSameArray = false;
                    }
                }
                if (i > 0 && isSameArray) { // 동일 배열일 때만 검사
                    if (array[i - 1][0] != array[i][0]) // column 검사
                        isSameArray = false;
                }
            }
            int minTime = Integer.MAX_VALUE;
            int maxHeight = 0;
            if (isSameArray) {
                minTime = 0;
                maxHeight = array[0][0];
            } else {
                int needBlock = 0;
                int needTime = 0;
                for (int i = min; i <= max; i++) {
                    needTime = 0;
                    needBlock = 0;
                    for (int j = 0; j < N; j++) {
                        for (int z = 0; z < M; z++) {
                            if (i > array[j][z]) { // 기준 높이보다 낮은 경우(Block 쌓아야함)
                                needTime += (i - array[j][z]) * 1;
                                needBlock += i - array[j][z];
                            } else if (i < array[j][z]) { // 기준 높이보다 높은 경우(Block 빼야함)
                                needTime += (array[j][z] - i) * 2;
                                needBlock -= array[j][z] - i;
                            }
                        }
                    }
                    if (B - needBlock >= 0) {
                        if (minTime >= needTime && needTime != 0) {
                            minTime = needTime;
                            maxHeight = Math.max(maxHeight, i);
                        }

                    }
                }
            }
            bw.write(minTime + " " + maxHeight + "\n");
            bw.flush();
            bw.close();
            br.close();
        } catch (

        Exception e) {
            System.out.println(e.getMessage());
        }
    }
}