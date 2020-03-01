package app;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int[] array = new int[3];
            int cnt = 0;
            int max;
            int sum;
            while (cnt != 3) {
                cnt = 0;
                sum = 0;
                max = 0;
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 0; i < array.length; i++) {
                    int temp = Integer.parseInt(st.nextToken());
                    if (temp == 0)
                        cnt++;
                    array[i] = temp * temp;
                    if (array[i] > max)
                        max = array[i];
                }
                for (int i = 0; i < array.length; i++) {
                    if (array[i] != max)
                        sum += array[i];
                }
                if (cnt != 3) {
                    if (sum == max)
                        bw.write("right" + "\n");
                    else
                        bw.write("wrong" + "\n");
                }

            }
            bw.close();
            br.close();
        } catch (IOException e) {

        }
    }
}