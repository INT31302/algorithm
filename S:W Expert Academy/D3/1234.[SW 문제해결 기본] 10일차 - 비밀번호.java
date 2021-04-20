import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            bw.write("#"+(i+1)+" ");
            int N = Integer.parseInt(st.nextToken());
            String temp = st.nextToken();
            TreeMap<Integer, Character> map = new TreeMap<>();
            for (int j = 0; j < N; j++) {
                map.put(j, temp.charAt(j));
            }
            boolean isFind;
            do {
                isFind = false;
                int c1 = -1;
                int c2 = -1;
                for (Integer integer : map.keySet()) {
                    if (c1 == -1)
                        c1 = integer;
                    else if (c1 != -1 && c2 == -1)
                        c2 = integer;
                    if (c1 != -1 && c2 != -1)
                        if (map.get(c1) == map.get(c2)) {
                            map.remove(c1);
                            map.remove(c2);
                            isFind = true;
                            break;
                        } else {
                            c1 = c2;
                            c2 = -1;
                        }
                }
            } while (isFind);
            for (Integer integer : map.keySet()) {
                bw.write(map.get(integer));
            }
            bw.write("\n");
        }
        bw.close();
        br.close();
    }
}
