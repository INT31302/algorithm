import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            int N = Integer.parseInt(br.readLine());
            bw.write("#" + N + " ");
            Queue<Integer> queue = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                queue.offer(Integer.parseInt(st.nextToken()));
            }
            int value = 0;
            int temp;
            while (true) {
                ++value;
                if (value == 6) value = 1;
                temp = queue.poll() - value;
                if (temp <= 0) {
                    queue.offer(0);
                    break;
                } else queue.offer(temp);
            }
            while (!queue.isEmpty()) {
                bw.write(queue.poll() + " ");
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
    }
}
