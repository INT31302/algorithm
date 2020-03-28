package app;

import java.io.*;
import java.util.*;

public class Main {
    static String[] names;
    static int[][] array;
    static int[] result, array2;
    static int N;

    static void check(int index) {
        int size = names[index].length();
        for (int i = 0; i < size; i++) {
            switch (names[index].charAt(i)) {
                case 'L':
                    array[index][0]++;
                    break;
                case 'O':
                    array[index][1]++;
                    break;
                case 'V':
                    array[index][2]++;
                    break;
                case 'E':
                    array[index][3]++;
                    break;
            }
        }
        for (int i = 0; i < 4; i++)
            array[index][i] += array2[i];
    }

    static void calculate(int index) {
        int L = array[index][0];
        int O = array[index][1];
        int V = array[index][2];
        int E = array[index][3];
        result[index] = (L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E) % 100;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String name = br.readLine();
        int size = name.length();
        array2 = new int[4];
        for (int i = 0; i < size; i++) {
            switch (name.charAt(i)) {
                case 'L':
                    array2[0]++;
                    break;
                case 'O':
                    array2[1]++;
                    break;
                case 'V':
                    array2[2]++;
                    break;
                case 'E':
                    array2[3]++;
                    break;
            }
        }
        N = Integer.parseInt(br.readLine());
        array = new int[N][4];
        result = new int[N];
        names = new String[N];
        int maxValue = 0;
        int maxIndex = 0;
        int cnt = 1;
        for (int i = 0; i < N; i++) {
            names[i] = br.readLine();
            check(i);
            calculate(i);
            if (i == 0) {
                maxValue = result[i];
                maxIndex = i;
            } else {
                if (maxValue < result[i]) {
                    maxValue = result[i];
                    maxIndex = i;
                    cnt = 1;
                } else if (maxValue == result[i])
                    cnt++;
            }
        }
        if (cnt != 1) {
            LinkedList<String> resultName = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                if (result[i] == maxValue)
                    resultName.add(names[i]);
            }
            Collections.sort(resultName);
            bw.write(resultName.get(0) + "\n");
        } else
            bw.write(names[maxIndex] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}