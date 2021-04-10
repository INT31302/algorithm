import java.io.*;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            Stack<Character> stack = new Stack<>();
            int N = Integer.parseInt(br.readLine());
            bw.write("#" + (i + 1) + " ");
            boolean isCheck = true;
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = s.charAt(j);
                if (c == '{' || c == '[' || c == '(' || c == '<') stack.push(c);
                else if (c == '}') {
                    if (stack.isEmpty() || stack.peek() != '{') {
                        isCheck = false;
                        break;
                    } else stack.pop();

                } else if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        isCheck = false;
                        break;
                    } else stack.pop();
                } else if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        isCheck = false;
                        break;
                    } else stack.pop();
                } else if (c == '>') {
                    if (stack.isEmpty() || stack.peek() != '<') {
                        isCheck = false;
                        break;
                    } else stack.pop();
                }
            }
            if (isCheck) bw.write(1 + "\n");
            else bw.write(0 + "\n");
        }
        bw.close();
        br.close();
    }
}
