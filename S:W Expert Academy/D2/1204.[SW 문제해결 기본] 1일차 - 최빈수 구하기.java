import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i =0; i<T; i++){
            HashMap<Integer, Integer> map = new HashMap<>();
            int idx = Integer.parseInt(br.readLine());
            bw.write("#"+idx+" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                int n = Integer.parseInt(st.nextToken());
                map.put(n, map.getOrDefault(n,0)+1);
            }
            Integer max = Collections.max(map.values());
            int result = 0;
            Set<Integer> keySet = map.keySet();
            for (Integer key : keySet) {
                if(map.get(key) == max) result = Math.max(result, key);
            }
            bw.write(result+"\n");
        }
        bw.close();
        br.close();
    }
}
