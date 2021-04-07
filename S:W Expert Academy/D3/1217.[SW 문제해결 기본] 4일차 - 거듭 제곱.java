import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static int getSum(int N, int M, int result) {
        result *= N;
        if (M == 0) return result;
        return getSum(N, M - 1, result);
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            int T = Integer.parseInt(br.readLine());
            bw.write("#" + T + " ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int result = getSum(N, M - 1, 1);
            bw.write(result + "\n");
        }
        bw.close();
        br.close();
    }
}
