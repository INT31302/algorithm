import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            int T = Integer.parseInt(br.readLine());
            bw.write("#" + T + " ");
            String find = br.readLine();
            StringBuilder sentence = new StringBuilder(br.readLine());
            int cnt = 0;
            int idx = 0;
            while (true) {
                idx = sentence.indexOf(find);
                if (idx != -1) {
                    cnt++;
                    sentence.replace(idx, idx + find.length(), "");
                }else break;
            }
            bw.write(cnt + "\n");
        }
        bw.close();
        br.close();
    }
}
