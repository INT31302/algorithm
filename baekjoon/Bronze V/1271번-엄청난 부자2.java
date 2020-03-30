package app;

import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BigInteger n = new BigInteger(br.readLine());
        BigInteger m = new BigInteger(br.readLine());
        BigInteger result = n.divide(m);
        n = n.mod(m);
        bw.write(result + "\n" + n + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}