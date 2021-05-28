import java.util.*;

public class Solution {
    public static int[] solution(String[] operations) {
        int[] answer;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int val;
        int key;
        for (String oper : operations) {
            if (oper.charAt(0) == 'I') {
                val = Integer.parseInt(oper.split(" ")[1]);
                map.put(val, map.getOrDefault(val, 0) + 1);
            } else if (oper.charAt(0) == 'D') {
                val = Integer.parseInt(oper.split(" ")[1]);
                if (!map.isEmpty()) {
                    if (val == 1) key = map.lastKey();
                    else key = map.firstKey();
                    map.put(key, map.get(key) - 1);
                    if (map.get(key) == 0) map.remove(key);
                }
            }
        }
        answer = new int[2];
        if (map.isEmpty()) {
            Arrays.fill(answer, 0);
        } else {
            answer[0] = map.lastKey();
            answer[1] = map.firstKey();
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] operations = {"I 7", "I 5", "I -5", "D -1"};
        System.out.println(Arrays.toString(solution(operations)));
    }
}
