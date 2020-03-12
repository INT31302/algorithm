package app;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int n;
        TreeMap<String, Integer> map = new TreeMap<>();
        StringTokenizer st;
        String categorie;
        int result = 1;
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            map.clear();
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                categorie = st.nextToken();
                if (map.containsKey(categorie))
                    map.put(categorie, map.get(categorie) + 1);
                else
                    map.put(categorie, 1);
            }
            result = 1;
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                result *= map.get(it.next()) + 1;
            }
            bw.write(result - 1 + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}