package app;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int N = Integer.parseInt(br.readLine());
            Stack<Integer> stack = new Stack<>();
            LinkedList<Integer> list = new LinkedList<>();
            int num = 1;
            StringBuffer result = new StringBuffer();
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(br.readLine()));
            }
            while (list.size() != 0) {
                if (!stack.isEmpty()) { // 스택에 쌓인 게 있을 경우
                    if (list.getFirst().intValue() == stack.peek().intValue()) { // 필요한 값과 top이 같을 경우
                        stack.pop();
                        list.removeFirst();
                        result.append("-\n");
                    } else { // 필요한 값과 top이 다를 경우
                        if (list.getFirst().intValue() < stack.peek().intValue()) { // 필요한 값보다 top이 더 클 경우
                            result = new StringBuffer("NO");
                            break;
                        }
                        /* 필요한 값보다 top이 작을 경우 */
                        stack.push(num++);
                        result.append("+\n");
                    }
                } else { // 스택에 쌓인 게 없을 경우
                    stack.push(num++);
                    result.append("+\n");
                }
            }
            bw.write(result.toString());
            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
        }
    }
}