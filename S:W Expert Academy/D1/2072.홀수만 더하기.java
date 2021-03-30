import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            while (st.hasMoreTokens()) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp % 2 != 0) sum += temp;
            }
            bw.write("#" + (i + 1) + " " + sum + "\n");
        }
        bw.close();
        br.close();
    }
}
