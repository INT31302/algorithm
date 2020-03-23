package app;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        ArrayList<BigInteger> dp = new ArrayList<>();
        dp.add(BigInteger.ZERO);
        dp.add(BigInteger.ONE);
        for (int i = 2; i <= N; i++) {
            dp.add(dp.get(i - 1).add(dp.get(i - 2)));
        }
        bw.write(dp.get(N) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}