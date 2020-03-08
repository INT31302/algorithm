package app;

import java.util.*;
import java.io.*;

public class Main {
    public static String calculate(String input) {
        Stack<Character> list = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                list.push(')');
            }
            if (input.charAt(i) == '[')
                list.push(']');
            if (input.charAt(i) == ')') {
                if (list.size() == 0)
                    return "no";
                if (list.pop() != ')')
                    return "no";
            }
            if (input.charAt(i) == ']') {

                if (list.size() == 0)
                    return "no";
                if (list.pop() != ']')
                    return "no";
            }
        }
        if (list.size() == 0)
            return "yes";
        else
            return "no";
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            String input = br.readLine();
            while (!input.equals(".")) {
                if (input.charAt(input.length() - 1) == '.') {
                    bw.write(calculate(input) + "\n");
                    input = br.readLine();
                } else {
                    input += br.readLine();
                }
            }
            bw.close();
            br.close();
        } catch (IOException e) {
        }
    }
}