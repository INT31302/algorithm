package app;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int[] array = new int[5];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(st.nextToken());
                sum += array[i] * array[i];
            }
            bw.write(sum % 10 + "\n");
            bw.close();
            br.close();
        } catch (IOException e) {
        }
    }
}