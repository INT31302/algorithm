import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static ArrayList<ArrayList<Integer>> arrayList;

    static boolean bfs(int x) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (Integer integer : arrayList.get(x)) {
            if(integer == 99) return true;
            queue.offer(integer);
        }
        while(!queue.isEmpty()){
            int p = queue.poll();
            for (Integer integer : arrayList.get(p)) {
                if(integer == 99) return true;
                queue.offer(integer);
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            bw.write("#" + T + " ");
            arrayList = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                arrayList.add(new ArrayList<>());
            }
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                arrayList.get(n1).add(n2);
            }
            if(bfs(0)) bw.write(1+"\n");
            else bw.write(0+"\n");
        }
        bw.close();
        br.close();
    }
}
