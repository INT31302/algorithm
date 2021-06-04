import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Node {
        int index;
        Node left, right;

        public Node(int index, Node left, Node right) {
            this.index = index;
            this.left = left;
            this.right = right;
        }
    }

    static Node insertNode(Node node, int value) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            if (n.index > value) {
                if (n.left == null) {
                    n.left = new Node(value, null, null);
                    return node;
                } else queue.offer(n.left);
            } else {
                if (n.right == null) {
                    n.right = new Node(value, null, null);
                    return node;
                } else queue.offer(n.right);
            }
        }
        return null;
    }

    static void printPostOrder(Node node) throws IOException {
        if (node != null) {
            if (node.left != null) printPostOrder(node.left);
            if (node.right != null) printPostOrder(node.right);
            bw.write(node.index + "\n");
        }
    }

    public static void main(String[] args) throws IOException {

        Node center = null;
        String input = null;
        while (true) {
            input = br.readLine();
            if (input == null || input.equals("")) break;
            if (center == null) center = new Node(Integer.parseInt(input), null, null);
            else insertNode(center, Integer.parseInt(input));
        }
        printPostOrder(center);
        bw.close();
        br.close();
    }
}
