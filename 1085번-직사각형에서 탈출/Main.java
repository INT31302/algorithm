package app;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int[] array = new int[4];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }
            int[] result = new int[4];
            int min = array[0];
            for (int i = 0; i < array.length; i++) {
                if (i < 2)
                    result[i] = array[i];
                else {
                    result[i] = array[i] - array[i - 2];
                }
                if (min > result[i])
                    min = result[i];
            }
            bw.write(min + "\n");
            bw.close();
            br.close();
        } catch (IOException e) {
        }
    }
}