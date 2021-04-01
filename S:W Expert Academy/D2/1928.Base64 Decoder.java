import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    static int changeValue(byte c) {
        if (Character.isUpperCase(c)) {
            return c - 'A';
        } else if (Character.isLowerCase(c)) {
            return c - 'a' + 26;
        } else if (Character.isDigit(c)) {
            return c - '0' + 52;
        } else if (c == '+') {
            return 62;
        } else if (c == '/')
            return 63;
        else return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            bw.write("#" + (i + 1) + " ");
            Queue<Integer> bytes = new ArrayDeque<>();
            for (byte c : s.getBytes()) {
                bytes.offer(changeValue(c));
            }
            StringBuilder sb = new StringBuilder();
            while (!bytes.isEmpty()) {
                sb.append(String.format("%06d", Integer.parseInt(Integer.toBinaryString(bytes.poll()))));
            }
            while (sb.length() != 0) {
                String substring = sb.substring(0, 8);
                sb = sb.replace(0, 8, "");
                bw.write((char) Integer.parseInt(substring, 2));
            }
            bw.write("\n");
        }
        bw.close();
        br.close();
    }
}
