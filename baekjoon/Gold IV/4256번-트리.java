import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Queue<Integer> preOrder;
    static int[] inOrder;
    static int n;

    static class Node {
        int data;
        Node left, right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static void solve(Node node, int start, int end) {
        if (preOrder.isEmpty()) return;
        int data = preOrder.poll();
        if (start == end) {
            node.data = data;
            return;
        }
        for (int i = start; i <= end; i++) {
            if (inOrder[i] == data) {
                node.data = data;
                if (i - 1 >= start) {
                    node.left = new Node(0, null, null);
                    solve(node.left, start, i - 1);
                }
                if (i + 1 <= end) {
                    node.right = new Node(0, null, null);
                    solve(node.right, i + 1, end);
                }
            }
        }
    }

    static void printPostOrder(Node node) throws IOException {
        if(node.left != null) printPostOrder(node.left);
        if(node.right != null) printPostOrder(node.right);
        bw.write(node.data+" ");
    }
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            preOrder = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                preOrder.offer(Integer.parseInt(st.nextToken()));
            }
            inOrder = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
            Node center = new Node(0, null, null);

            solve(center, 0, n - 1);
            printPostOrder(center);
            bw.write("\n");
        }
        bw.close();
        br.close();
    }
}
