package app;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int[] array = new int[10001];
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                array[Integer.parseInt(br.readLine())]++;
            }
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i]; j++) {
                    bw.write(i + "\n");
                }
            }
            bw.close();
            br.close();
        } catch (IOException e) {

        }
    }
}