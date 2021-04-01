import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            bw.write("#" + (i + 1) + " ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            double sum = 0;
            int cnt = 0;
            while (st.hasMoreTokens()) {
                sum += Integer.parseInt(st.nextToken());
                cnt++;
            }
            bw.write(Math.round(sum / cnt) + "\n");
        }
        bw.close();
        br.close();
    }
}
