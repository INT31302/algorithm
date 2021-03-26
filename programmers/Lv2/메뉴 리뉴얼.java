import java.util.*;

public class Solution {
    static Map<String, Integer> map;

    public static void combination(char[] order, boolean[] isVisited, int start, int n, int r) {
        if (r == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < isVisited.length; i++) {
                if (isVisited[i]) sb.append(order[i]);
            }
            String str = sb.toString();
            map.put(str, map.getOrDefault(str, 0) + 1);
            return;
        }
        for (int i = start; i < order.length; i++) {
            isVisited[i] = true;
            combination(order, isVisited, i + 1, n, r - 1);
            isVisited[i] = false;
        }
    }

    public static String[] solution(String[] orders, int[] course) {
        ArrayList<String> list = new ArrayList<>();
        for (int i : course) {
            map = new HashMap<>();
            for (String order : orders) {
                char[] temp = order.toCharArray();
                Arrays.sort(temp);
                boolean[] isVisited = new boolean[temp.length];
                combination(temp, isVisited, 0, i, i);
            }
            if (map.isEmpty()) continue;

            int max = Collections.max(map.values());
            Set<String> keys = map.keySet();
            for (String key : keys) {
                if (max >= 2 && map.get(key) == max) list.add(key);
            }
        }
        String[] answer = new String[list.size()];
        list.toArray(answer);
        Arrays.sort(answer);
        return answer;
    }

    public static void main(String[] args) {
        String[][] orders = {
                {"ABCFG", "CA", "CDE", "ACDE", "BCFG", "ACDEH"},
                {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},
                {"XYZ", "XWY", "WXA"}};
        int[][] course = {
                {2, 3, 4},
                {2, 3, 5},
                {2, 3, 4}
        };
        for (int i = 0; i < orders.length; i++) {
            for (String s : solution(orders[i], course[i])) {
                System.out.println("s = " + s);
            }
        }
    }
}
