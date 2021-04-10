import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        map.put("ZRO", 0);
        map.put("ONE", 1);
        map.put("TWO", 2);
        map.put("THR", 3);
        map.put("FOR", 4);
        map.put("FIV", 5);
        map.put("SIX", 6);
        map.put("SVN", 7);
        map.put("EGT", 8);
        map.put("NIN", 9);
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            bw.write(st.nextToken()+"\n");
            int len = Integer.parseInt(st.nextToken());
            PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return map.get(o1) - map.get(o2);
                }
            });
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                pq.offer(st.nextToken());
            }
            while(!pq.isEmpty()){
                bw.write(pq.poll()+" ");
            }
            bw.write("\n");
        }
        bw.close();
        br.close();
    }
}
