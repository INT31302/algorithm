package app;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int Hr = Integer.parseInt(st.nextToken());
        int Wr = Integer.parseInt(st.nextToken());
        double r = D / Math.sqrt(Math.pow(Hr, 2) + Math.pow(Wr, 2));
        double height = Hr * r;
        double width = Wr * r;
        bw.write((int) height + " " + (int) width + "\n");
        bw.flush();
        bw.close();
        br.close();

    }
}