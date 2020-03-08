package app;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            String[] input = br.readLine().split(" ");
            int K = Integer.parseInt(input[0]);
            int N = Integer.parseInt(input[1]);
            int haveMax = 0;
            long maxHeight = 0;
            int[] lan_List = new int[K];
            for (int i = 0; i < K; i++) {
                lan_List[i] = Integer.parseInt(br.readLine());
                haveMax = Math.max(lan_List[i], haveMax);
            }
            long mid, left = 1, right = haveMax;
            long cnt = 0;
            while (right >= left) {
                mid = (right + left) / 2;
                for (int j = 0; j < K; j++) {
                    cnt += lan_List[j] / mid;
                }
                if (cnt >= N) { // 필요한 수량보다 같거나 더 많을 경우
                    maxHeight = Math.max(mid, maxHeight);
                    left = mid + 1;
                } else { // 필요한 수량보다 더 적을 경우
                    right = mid - 1;
                }
                cnt = 0;
            }
            bw.write(maxHeight + "\n");
            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}