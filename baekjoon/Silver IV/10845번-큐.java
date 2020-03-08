package app;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int N = Integer.parseInt(br.readLine());
            List<Integer> queue = new ArrayList<>();
            String temp;
            String[] command = new String[2];
            for (int i = 0; i < N; i++) {
                temp = br.readLine();
                command = temp.split(" ");
                if (command[0].equals("push"))
                    queue.add(Integer.parseInt(command[1]));
                else if (command[0].equals("pop")) {
                    if (queue.size() != 0) {
                        /* Queue의 poll()과 동일 */
                        bw.write(queue.get(0) + "\n");
                        queue.remove(0);
                    } else
                        bw.write("-1\n");
                } else if (command[0].equals("size"))
                    bw.write(queue.size() + "\n");
                else if (command[0].equals("empty")) {
                    if (queue.size() == 0) // Queue의 empty()와 동일
                        bw.write("1\n");
                    else
                        bw.write("0\n");
                } else if (command[0].equals("front")) {
                    if (queue.size() != 0)
                        bw.write(queue.get(0) + "\n");
                    else
                        bw.write("-1\n");
                } else if (command[0].equals("back")) {
                    if (queue.size() != 0)
                        /* Queue의 peek()과 동일 */
                        bw.write(queue.get(queue.size() - 1) + "\n");
                    else
                        bw.write("-1\n");
                }
            }
            bw.close();
            br.close();
        } catch (IOException e) {

        }
    }
}