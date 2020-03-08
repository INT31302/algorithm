package app;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] array = new int[41][2];
        int iTemp;
        array[0][0] = 1;
        array[1][1] = 1;
        for (int i = 2; i < 41; i++) {
            for (int j = 0; j < 2; j++) {
                array[i][j] = array[i - 2][j] + array[i - 1][j];
            }
        }

        for (int i = 0; i < N; i++) {
            iTemp = Integer.parseInt(br.readLine());
            bw.write(array[iTemp][0] + " " + array[iTemp][1] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}