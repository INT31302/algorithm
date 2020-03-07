package app;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            StringTokenizer input = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(input.nextToken());
            int M = Integer.parseInt(input.nextToken());
            int[] TREE_LIST = new int[N];
            input = new StringTokenizer(br.readLine());
            int maximum_tree_height = 0;
            for (int i = 0; i < N; i++) {
                TREE_LIST[i] = Integer.parseInt(input.nextToken());
                maximum_tree_height = Math.max(TREE_LIST[i], maximum_tree_height);
            }
            int left = 1, right = maximum_tree_height, mid;
            long total_height = 0;
            int maximum_cutline = 0;
            while (left <= right) {
                total_height = 0;
                mid = (right + left) / 2;
                for (int i = 0; i < N; i++) {
                    if (TREE_LIST[i] - mid > 0) {
                        total_height += TREE_LIST[i] - mid;
                    }
                }
                if (total_height >= M) { // // 필요한 나무 높이보다 높거나 같을 경우
                    maximum_cutline = Math.max(maximum_cutline, mid);
                    left = mid + 1;
                } else { // 필요한 나무 높이보다 적을 경우
                    right = mid - 1;
                }
            }
            bw.write(maximum_cutline + "\n");
            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}