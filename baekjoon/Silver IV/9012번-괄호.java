package app;

import java.util.*;
import java.io.*;

public class Main {
    public static String calculate(String temp) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == '(')
                stack.push(')');
            else if (temp.charAt(i) == ')') {
                if (stack.size() == 0)
                    return "NO";
                stack.pop();
            }
        }
        if (stack.size() == 0)
            return "YES";
        else
            return "NO";
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int N = Integer.parseInt(br.readLine());
            String temp;
            for (int i = 0; i < N; i++) {
                temp = br.readLine();
                bw.write(calculate(temp) + "\n");
            }
            bw.close();
            br.close();
        } catch (IOException e) {

        }
    }
}