package app;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int N = Integer.parseInt(br.readLine());
            LinkedList<String> list = new LinkedList<>();
            String temp;
            String[] command = new String[2];
            for (int i = 0; i < N; i++) {
                temp = br.readLine();
                command = temp.split(" ");
                switch (command[0]) {
                    case "push_front":
                        list.addFirst(command[1]);
                        break;
                    case "push_back":
                        list.addLast(command[1]);
                        break;
                    case "pop_front":
                        if (list.size() != 0)
                            bw.write(list.removeFirst() + "\n");
                        else
                            bw.write("-1\n");
                        break;
                    case "pop_back":
                        if (list.size() != 0)
                            bw.write(list.removeLast() + "\n");
                        else
                            bw.write("-1\n");
                        break;
                    case "size":
                        bw.write(list.size() + "\n");
                        break;
                    case "empty":
                        if (list.size() == 0)
                            bw.write("1\n");
                        else
                            bw.write("0\n");
                        break;
                    case "front":
                        if (list.size() != 0)
                            bw.write(list.getFirst() + "\n");
                        else
                            bw.write("-1\n");
                        break;
                    case "back":
                        if (list.size() != 0)
                            bw.write(list.getLast() + "\n");
                        else
                            bw.write("-1\n");
                        break;
                }
            }
            bw.close();
            br.close();
        } catch (IOException e) {
        }
    }
}