package app;

import java.io.*;
import java.util.*;

public class Main {
    static int N, r, c, cnt = 0;
    static boolean isFind = false;

    private static void find(int startX, int startY, int endX, int endY) {
        if ((endY - startY + 1) / 2 >= 2) {

            int x1, x2, y1, y2;
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 1) {
                    x1 = (endX + startX) / 2 + 1;
                    x2 = endX;
                } else {
                    x1 = startX;
                    x2 = (endX + startX) / 2;
                }
                if (i > 1) {
                    y1 = (endY + startY) / 2 + 1;
                    y2 = endY;
                } else {
                    y1 = startY;
                    y2 = (endY + startY) / 2;
                }
                if (y2 < r || x2 < c) {
                    cnt += (x2 - x1 + 1) * (y2 - y1 + 1);
                } else
                    find(x1, y1, x2, y2);
                if (isFind)
                    return;
            }
        } else {
            for (int i = startY; i < endY + 1; i++) {
                for (int j = startX; j < endX + 1; j++) {
                    if (i == r && j == c) {
                        isFind = true;
                        return;
                    } else
                        cnt++;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int maxSize = (int) Math.pow(2, N) - 1;
        find(0, 0, maxSize, maxSize);
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
