package app;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int factorial(int n, int result) {
        if (n > 1) {
            result *= n;
            n--;
        } else {
            return result;
        }
        return factorial(n, result);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int N, K;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            int child = factorial(N, 1);
            int parent = factorial(K, 1) * factorial((N - K), 1);
            bw.write(child / parent + "\n");
            bw.close();
            br.close();
        } catch (IOException e) {

        }
    }
}