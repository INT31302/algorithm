package app;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int N = Integer.parseInt(br.readLine());
            int i = 1;
            int parent, child;
            while (true) {
                if (N - i <= 0)
                    break;
                else {
                    N -= i;
                }
                i++;
            }
            if (i % 2 == 0) {
                parent = i - N + 1;
                child = N;
            } else {
                parent = N;
                child = i - N + 1;
            }
            bw.write(child + "/" + parent);
            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {

        }
    }
}