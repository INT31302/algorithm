import java.util.Arrays;

public class Solution {
    static int[] answer;

    static class Point {
        int startX, startY, endX, endY;

        public Point(int startX, int startY, int endX, int endY) {
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }
    }

    static void dfs(int[][] arr, Point p) {
        int prevVal = arr[p.startX][p.startY];
        if (p.startX == p.endX && p.startY == p.endY) {
            answer[arr[p.startX][p.startY]]++;
            return;
        }
        for (int i = p.startX; i <= p.endX; i++) {
            for (int j = p.startY; j <= p.endY; j++) {
                if (prevVal != arr[i][j]) {
                    dfs(arr, new Point(p.startX, p.startY, (p.startX + p.endX) / 2, (p.startY + p.endY) / 2)); // 0,0,1,1
                    dfs(arr, new Point(p.startX, (p.startY + p.endY) / 2 + 1, (p.startX + p.endX) / 2, p.endY));//0,2,1,3
                    dfs(arr, new Point((p.startX + p.endX) / 2 + 1, p.startY, p.endX, (p.startY + p.endY) / 2)); // 2,0,3,1
                    dfs(arr, new Point((p.startX + p.endX) / 2 + 1, (p.startY + p.endY) / 2 + 1, p.endX, p.endY)); //2,2,3,3
                    return;
                }
            }
        }
        answer[arr[p.startX][p.startY]]++;
        return;
    }

    public static int[] solution(int[][] arr) {
        answer = new int[2];
        int n = arr.length - 1;
        dfs(arr, new Point(0, 0, n, n));
        return answer;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}};
        System.out.println(Arrays.toString(solution(arr)));
    }
}
