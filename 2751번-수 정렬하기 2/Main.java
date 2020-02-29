package app;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scanner = new Scanner(System.in);
        try {
            int N = scanner.nextInt();
            ArrayList<Integer> array = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                array.add(scanner.nextInt());
            }
            Collections.sort(array);
            for (int i = 0; i < N; i++) {
                bw.write(array.get(i) + "\n");
                bw.flush();
            }
            bw.close();
        } catch (IOException e) {

        }
        scanner.close();
    }
}