package app;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        Queue<Character> list = new LinkedList<>();
        Queue<Integer> minus = new LinkedList<>();
        Queue<Integer> plus = new LinkedList<>();
        int size = input.length();
        for (int i = 0; i < size; i++) {
            list.add(input.charAt(i));
        }
        char temp;
        int num = 0;
        boolean isMinus = false;
        for (int i = 0; i < size; i++) {
            temp = list.poll();
            if (temp >= '0' && temp <= '9') {
                num = num * 10 + (temp - '0');
            } else if (temp == '-' || temp == '+') { // '-' or '+' 일 경우
                if (isMinus) { // '-' 연산이 이루어 지고 있었을 경우
                    minus.add(num);
                } else {
                    plus.add(num);
                    if (temp == '-')
                        isMinus = !isMinus;
                }
                num = 0;
            }
        }
        if (isMinus)
            minus.add(num);
        else
            plus.add(num);
        int sum = 0;
        while (!plus.isEmpty()) {
            sum += plus.poll();
        }
        while (!minus.isEmpty()) {
            sum -= minus.poll();
        }
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}