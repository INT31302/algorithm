import java.util.*;

public class Solution {
    static HashMap<String, Node> map = new HashMap<>();

    static class Node {
        Node parentsNode;
        ArrayList<Node> childNode = new ArrayList<>();
        String name;
        int value;

        public Node(Node parentsNode, String name, int value) {
            this.parentsNode = parentsNode;
            this.name = name;
            this.value = value;
        }
    }

    static void calculate_dfs(Node node, int amount) {
        if (node.parentsNode == null) {
            node.value += amount;
        } else {
            int value = (int) (amount * 0.1);
            node.value += amount - value;
            calculate_dfs(node.parentsNode, value);
        }

    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Node centerNode = new Node(null, "center", 0);
        for (int i = 0; i < referral.length; i++) {
            Node parentsNode;
            Node childNode;
            if (referral[i].equals("-"))
                parentsNode = centerNode;
            else
                parentsNode = map.get(referral[i]);

            childNode = new Node(parentsNode, enroll[i], 0);
            parentsNode.childNode.add(childNode);
            map.put(enroll[i], childNode);
        }

        for (int i = 0; i < seller.length; i++) {
            Node findNode = map.get(seller[i]);
            calculate_dfs(findNode, amount[i] * 100);
        }
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = map.get(enroll[i]).value;
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                seller = {"sam", "emily", "jaimie", "edward"};
        int[] amount = {2, 3, 5, 4};

        System.out.println(Arrays.toString(solution(enroll, referral, seller, amount)));
    }
}
