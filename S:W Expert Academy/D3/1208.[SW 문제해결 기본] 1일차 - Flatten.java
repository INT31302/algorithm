import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            bw.write("#" + (i + 1) + " ");
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for (int j = 0; j < N; j++) {
                int max = map.lastKey();
                int min = map.firstKey();
                map.put(min + 1, map.getOrDefault(min + 1, 0) + 1);
                map.put(max - 1, map.getOrDefault(max - 1, 0) + 1);
                map.put(max, map.get(max) - 1);
                map.put(min, map.get(min) - 1);
                if (map.get(max) == 0) map.remove(max);
                if (map.get(min) == 0) map.remove(min);
            }
            bw.write(map.lastKey() - map.firstKey() + "\n");
        }
        bw.close();
        br.close();
    }
}
