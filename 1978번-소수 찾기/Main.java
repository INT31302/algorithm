package app;

import java.io.*;
import java.util.*;

public class Main {
    public static int find_decimal(int num) {
        int result = 0;
        if (num <= 1)
            return 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return result;
        }
        result = 1;
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer temp = new StringTokenizer(br.readLine());
            int result = 0;
            int num;
            for (int i = 0; i < N; i++) {
                num = Integer.parseInt(temp.nextToken());
                result += find_decimal(num);
            }
            bw.write(result + "\n");
            bw.close();
            br.close();
        } catch (IOException e) {
        }
    }
}