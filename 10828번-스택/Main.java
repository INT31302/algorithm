package app;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int N = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();
            String temp;
            String[] command = new String[2];
            for (int i = 0; i < N; i++) {
                temp = br.readLine();
                command = temp.split(" ");
                if (command[0].equals("push"))
                    list.add(Integer.parseInt(command[1]));
                else if (command[0].equals("pop")) {
                    if (list.size() != 0) {
                        /* Stack의 pop()과 동일 */
                        bw.write(list.get(list.size() - 1) + "\n");
                        list.remove(list.size() - 1);
                    } else
                        bw.write("-1\n");
                } else if (command[0].equals("size"))
                    bw.write(list.size() + "\n");
                else if (command[0].equals("empty")) {

                    if (list.size() == 0) // Stack의 isEmpty()과 동일
                        bw.write("1\n");
                    else
                        bw.write("0\n");
                } else if (command[0].equals("top")) {
                    if (list.size() != 0) {
                        /* Stack의 peek()과 동일 */
                        bw.write(list.get(list.size() - 1) + "\n");
                    } else
                        bw.write("-1\n");
                }
            }
            bw.close();
            br.close();
        } catch (IOException e) {

        }
    }
}