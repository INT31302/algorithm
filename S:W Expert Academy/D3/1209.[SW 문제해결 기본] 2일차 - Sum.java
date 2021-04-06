import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static int[][] arr;
    static boolean[][] visited;

    static int getSum(String direction, int x, int y) {
        int sum = 0;
        int xAdd = 0;
        int yAdd = 0;
        for (int i = 0; i < 100; i++) {
            sum += arr[x + xAdd][y + yAdd];
            if (direction.equals("r")) xAdd++;
            else if(direction.equals("d")) yAdd++;
            else if(direction.equals("dr")){
                xAdd++;
                yAdd++;
            }
            else if(direction.equals("dl")){
                xAdd--;
                yAdd--;
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            int N = Integer.parseInt(br.readLine());
            bw.write("#" + N + " ");
            int result = 0;
            arr = new int[100][100];
            visited = new boolean[100][100];
            for (int j = 0; j < 100; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 100; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            for (int j = 0; j < 100; j++) {
                if (j == 0) result = Math.max(result, getSum("dr", 0, 0));
                if (j == 99) result = Math.max(result, getSum("dl", 99, 99));
                result = Math.max(result, getSum("r", 0, j));
                result = Math.max(result, getSum("d", j, 0));
            }
            bw.write(result + "\n");
        }
        bw.close();
        br.close();
    }
}
