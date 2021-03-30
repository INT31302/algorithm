import java.io.*;

public class Solution {
    static boolean[][] isVisited;
    static int[][] array;
    static int N;

    static void dfs(int x, int y, char direction, int value) {
        if (value >= N * N) return;
        if (x == N || y == N || x == -1 || y == -1) {
            changeDirection(x, y, direction, value);
        } else if (!isVisited[x][y]) {
            isVisited[x][y] = true;
            array[x][y] = ++value;
            if (direction == 'r') dfs(x, y + 1, 'r', value);
            if (direction == 'd') dfs(x + 1, y, 'd', value);
            if (direction == 'l') dfs(x, y - 1, 'l', value);
            if (direction == 'u') dfs(x - 1, y, 'u', value);
        } else {
            changeDirection(x, y, direction, value);
        }

    }

    private static void changeDirection(int x, int y, char direction, int value) {
        if (direction == 'r') dfs(x + 1, y - 1, 'd', value);
        if (direction == 'd') dfs(x - 1, y - 1, 'l', value);
        if (direction == 'l') dfs(x - 1, y + 1, 'u', value);
        if (direction == 'u') dfs(x + 1, y + 1, 'r', value);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            isVisited = new boolean[N][N];
            array = new int[N][N];
            dfs(0, 0, 'r', 0);
            bw.write("#" + (i+1) + "\n");
            for (int[] ints : array) {
                for (int anInt : ints) {
                    bw.write(anInt + " ");
                }
                bw.write("\n");
            }
        }

        bw.close();
        br.close();
    }
}

