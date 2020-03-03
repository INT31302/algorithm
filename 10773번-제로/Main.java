package app;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int N = Integer.parseInt(br.readLine());
            Stack<Integer> stack = new Stack<>();
            String temp;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                temp = br.readLine();
                if (!temp.equals("0"))
                    stack.push(Integer.parseInt(temp));
                else
                    stack.pop();
            }
            while (!stack.isEmpty()) {
                sum += stack.pop();
            }
            bw.write(sum + "\n");
            bw.close();
            br.close();
        } catch (IOException e) {
        }
    }
}