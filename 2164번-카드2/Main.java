package app;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int N = Integer.parseInt(br.readLine());
            LinkedList<Integer> array = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                array.add(i + 1);
            }
            while (array.size() != 1) {
                array.remove(0);
                array.add(array.get(0));
                array.remove(0);
            }
            bw.write(array.get(0) + "\n");
            bw.close();
            br.close();
        } catch (IOException e) {

        }
    }
}