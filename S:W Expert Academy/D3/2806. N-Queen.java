import java.io.*;
import java.util.Arrays;

public class Solution {
    static int[] arr;
    static int N;
    static int count;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static boolean possibility(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[i] == arr[col])
                return false;
            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i]))
                return false;
        }
        return true;
    }

    static void nQueen(int depth) {
        if (depth == N) {
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (possibility(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            bw.write("#" + (i + 1) + " ");
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            nQueen(0);
            bw.write(count+"\n");
            count = 0;
        }
        bw.close();
        br.close();
    }
}
