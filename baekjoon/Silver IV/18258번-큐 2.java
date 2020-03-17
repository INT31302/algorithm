package app;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> queue = new LinkedList<>();
        String[] input;
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            if (input.length == 1) {
                switch (input[0]) {
                    case "pop":
                        if (queue.isEmpty())
                            bw.write("-1\n");
                        else
                            bw.write(queue.poll() + "\n");
                        break;
                    case "size":
                        bw.write(queue.size() + "\n");
                        break;
                    case "empty":
                        if (queue.isEmpty())
                            bw.write("1\n");
                        else
                            bw.write("0\n");
                        break;
                    case "front":
                        if (queue.isEmpty())
                            bw.write("-1\n");
                        else
                            bw.write(queue.getFirst() + "\n");
                        break;
                    case "back":
                        if (queue.isEmpty())
                            bw.write("-1\n");
                        else
                            bw.write(queue.getLast() + "\n");
                }
            } else {
                if (input[0].equals("push"))
                    queue.add(Integer.parseInt(input[1]));
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}