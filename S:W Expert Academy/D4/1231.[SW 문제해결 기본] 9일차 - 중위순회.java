import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static Node node;
    static StringBuilder sb;

    static class Node {
        int idx;
        char value;
        Node left, right;
        boolean isVisited;

        public Node(int idx) {
            this.idx = idx;
        }

        public Node(int idx, char value, Node left, Node right, boolean isVisited) {
            this.idx = idx;
            this.value = value;
            this.left = left;
            this.right = right;
            this.isVisited = isVisited;
        }
    }

    static void inputNode(int idx, char value, Node left, Node right) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        while (true) {
            Node n = queue.poll();
            if (n.idx == idx) {
                n.value = value;
                n.left = left;
                n.right = right;
                return;
            }
            if (n.left != null) queue.offer(n.left);
            if (n.right != null) queue.offer(n.right);
        }
    }

    static void inorder(StringBuilder sb, Node n) {
        if (n.left == null || n.left.isVisited) {
            sb.append(n.value);
            n.isVisited = true;
            if (n.right != null) {
                if (!n.right.isVisited) inorder(sb, n.right);
            }
            return;
        }
        inorder(sb, n.left);
        if (n.left == null || n.left.isVisited) {
            sb.append(n.value);
            n.isVisited = true;
        }
        if (n.right != null) {
            if (!n.right.isVisited) inorder(sb, n.right);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            int N = Integer.parseInt(br.readLine());
            bw.write("#" + (i + 1) + " ");
            node = null;
            sb = new StringBuilder();
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                char value = st.nextToken().charAt(0);
                if (st.hasMoreTokens()) {
                    Node left = new Node(Integer.parseInt(st.nextToken()));
                    Node right = null;
                    if (st.hasMoreTokens()) right = new Node(Integer.parseInt(st.nextToken()));
                    if (node == null) node = new Node(idx, value, left, right, false);
                    else inputNode(idx, value, left, right);
                } else {
                    if (node == null) node = new Node(idx, value, null, null, false);
                    else inputNode(idx, value, null, null);
                }
            }
            inorder(sb, node);
            bw.write(sb + "\n");
        }
        bw.close();
        br.close();
    }
}
