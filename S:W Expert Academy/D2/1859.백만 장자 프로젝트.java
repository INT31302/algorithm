import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            long sum = 0;
            int buyCnt = 0;
            long buyCost = 0;
            bw.write("#" + (i + 1) + " ");
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            TreeMap<Integer, Integer> map = new TreeMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            }
            for (int i1 : arr) {
                int max = map.lastKey();
                if (max > i1) {
                    buyCnt++;
                    buyCost += i1;
                    if (map.get(i1) > 0) map.put(i1, map.get(i1) - 1);
                    if (map.get(i1) == 0) map.remove(i1);
                } else if (max == i1) {
                    if (map.get(i1) > 0) map.put(i1, map.get(i1) - 1);
                    if (map.get(i1) == 0) map.remove(i1);
                    if (buyCnt != 0) {
                        sum += (long) (i1) * buyCnt - buyCost;
                        buyCost = 0;
                        buyCnt = 0;
                    }
                }
            }
            bw.write(sum + "\n");
        }
        bw.close();
        br.close();
    }
}
