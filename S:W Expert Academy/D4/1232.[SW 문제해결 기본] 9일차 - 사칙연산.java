import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static Node node;
    static int depth = 1;

    static class Node {
        int index;
        String value;
        boolean isOperator;
        Node left, right;

        public Node(int index) {
            this.index = index;
        }

        public Node(int index, String value) {
            this.index = index;
            this.value = value;
        }

        public Node(int index, String value, boolean isOperator, Node left, Node right) {
            this.index = index;
            this.value = value;
            this.isOperator = isOperator;
            this.left = left;
            this.right = right;
        }
    }

    static void inputValue(int idx, String value) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        while (true) {
            Node n = queue.poll();
            if (n.index == idx) {
                n.value = value;
                n.isOperator = false;
                return;
            }
            if (n.left != null)
                queue.offer(n.left);
            if (n.right != null)
                queue.offer(n.right);
        }
    }

    static void inputNode(int idx, String value, int left, int right) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        while (true) {
            Node n = queue.poll();
            if (n.index == idx) {
                n.value = value;
                n.isOperator = true;
                n.left = new Node(left);
                n.right = new Node(right);
                return;
            }
            if (n.left != null)
                queue.offer(n.left);
            if (n.right != null)
                queue.offer(n.right);
        }
    }

    static double calculate(String operator, Node left, Node right) {
        if (operator.equals("+")) return getResult(left) + getResult(right);
        else if (operator.equals("-")) return getResult(left) - getResult(right);
        else if (operator.equals("*")) return getResult(left) * getResult(right);
        else if (operator.equals("/")) return getResult(left) / getResult(right);
        return 0;
    }
    static double calculate(String operator, String value, Node n, char direction) {
        if (operator.equals("+")) return Double.parseDouble(value) + getResult(n);
        else if (operator.equals("-")){
            if(direction =='l') return getResult(n) - Double.parseDouble(value);
            else return Double.parseDouble(value) - getResult(n);
        }
        else if (operator.equals("*")) return Double.parseDouble(value) * getResult(n);
        else if (operator.equals("/")){
            if(direction =='l') return getResult(n) / Double.parseDouble(value);
            else return Double.parseDouble(value) / getResult(n);
        }
        return 0;
    }

    static double getResult(Node n) {

        if (!n.left.isOperator && !n.right.isOperator) {
            double lVal = Integer.parseInt(n.left.value);
            double rVal = Integer.parseInt(n.right.value);
            if (n.value.equals("+")) return lVal + rVal;
            if (n.value.equals("-")) return lVal - rVal;
            if (n.value.equals("*")) return lVal * rVal;
            if (n.value.equals("/")) return lVal / rVal;
        }else {
            if(n.left.isOperator && n.right.isOperator) return calculate(n.value, n.left, n.right);
            if (n.left.isOperator) return calculate(n.value, n.right.value, n.left, 'l');
            if (n.right.isOperator) return calculate(n.value, n.left.value, n.right, 'r');
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            int N = Integer.parseInt(br.readLine());
            node = null;
            bw.write("#" + (i + 1) + " ");
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                String value = st.nextToken();
                if (Character.isDigit(value.charAt(0))) {
                    if (node == null) {
                        node = new Node(idx, value);
                        continue;
                    }
                    inputValue(idx, value);
                } else {
                    int left = Integer.parseInt(st.nextToken());
                    int right = Integer.parseInt(st.nextToken());
                    depth++;
                    if (node == null) {
                        node = new Node(idx, value, true, new Node(left), new Node(right));
                        continue;
                    }
                    inputNode(idx, value, left, right);
                }
            }
            bw.write((int)getResult(node)+"\n");
        }
        bw.close();
        br.close();
    }
}
