package app;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder input = new StringBuilder(br.readLine());
        StringBuilder word = new StringBuilder(br.readLine());
        Stack<Character> stack = new Stack<>();
        int SIZE = input.length();
        int WORD_SIZE = word.length();
        char LASTCHAR = word.charAt(WORD_SIZE - 1);
        int stack_size = 0;
        Loop1: for (int i = 0; i < SIZE; i++) {
            stack.push(input.charAt(i));
            stack_size = stack.size();
            if (stack.peek() == LASTCHAR && stack_size >= WORD_SIZE) {
                for (int j = 0; j < WORD_SIZE; j++) {
                    if (stack.get(stack_size - j - 1) != word.charAt(WORD_SIZE - j - 1))
                        continue Loop1;
                }
                for (int j = 0; j < WORD_SIZE; j++) {
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()) {
            stack_size = stack.size();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < stack_size; i++) {
                sb.append(stack.pop());
            }
            bw.write(sb.reverse().toString() + "\n");
        } else
            bw.write("FRULA");
        bw.flush();
        bw.close();
        br.close();
    }
}