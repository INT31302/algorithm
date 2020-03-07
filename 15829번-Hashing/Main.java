package app;

import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int M = 1234567891;
        final int r = 31;
        int L = Integer.parseInt(br.readLine());
        BigInteger result = new BigInteger("0");
        String word = br.readLine();
        BigInteger iTemp;
        BigInteger squared;
        for (int i = 0; i < L; i++) {
            iTemp = BigInteger.valueOf(word.charAt(i) - 'a' + 1);
            squared = BigInteger.valueOf(r).pow(i);
            iTemp = iTemp.multiply(squared);
            result = result.add(iTemp);
        }
        result = result.mod(BigInteger.valueOf(M));
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();

    }
}