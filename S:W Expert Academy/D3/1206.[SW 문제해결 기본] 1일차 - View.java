import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int idx = 1;
        while ((input = br.readLine())!=null) {
            if (input.equals("")) break;
            bw.write("#" + (idx++) + " ");
            int N = Integer.parseInt(input);
            int[] buildings = new int[N];
            int sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                buildings[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 2; i < buildings.length - 2; i++) {
                if (buildings[i] != 0) {
                    int max = 0;
                    for (int j = 1; j < 3; j++) {
                        max = Math.max(buildings[i - j], max);
                        max = Math.max(buildings[i + j], max);
                    }
                    int sub = buildings[i] - max;
                    if (sub > 0) sum += sub;
                }
            }
            bw.write(sum+"\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
