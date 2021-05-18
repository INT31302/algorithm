public class Solution {
    static int[][] arr;
    static int min = Integer.MAX_VALUE;
    static void dfs(int x, int y, int[] query, int value, char Direction) {
        if (x == query[0] - 1 && y == query[1] - 1 && Direction == 'u')
            return;
        min = Math.min(min,value);
        if (Direction == 'r') {
            if (y >= query[3]-1) {
                int temp = arr[x + 1][y];
                arr[x + 1][y] = value;
                dfs(x + 1, y, query, temp, 'd');
            } else {
                int temp = arr[x][y + 1];
                arr[x][y + 1] = value;
                dfs(x, y + 1, query, temp, 'r');
            }
        } else if (Direction == 'd') {
            if (x >= query[2]-1) {
                int temp = arr[x][y - 1];
                arr[x][y - 1] = value;
                dfs(x, y - 1, query, temp, 'l');
            } else {
                int temp = arr[x + 1][y];
                arr[x + 1][y] = value;
                dfs(x + 1, y, query, temp, 'd');
            }
        } else if (Direction == 'l') {
            if (y <= query[1]-1) {
                int temp = arr[x - 1][y];
                arr[x - 1][y] = value;
                dfs(x - 1, y, query, temp, 'u');
            } else {
                int temp = arr[x][y - 1];
                arr[x][y - 1] = value;
                dfs(x, y - 1, query, temp, 'l');
            }
        } else if (Direction == 'u') {
            if (x<= query[0]-1) return;
            int temp = arr[x - 1][y];
            arr[x - 1][y] = value;
            dfs(x - 1, y, query, temp, 'u');
        }
    }

    //[[2,2,5,4],[3,3,6,6],[5,1,6,3]]
    public static int[] solution(int rows, int columns, int[][] queries) {
        arr = new int[rows][columns];
        int[] answer = new int[queries.length];
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = num++;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            dfs(queries[i][0] - 1, queries[i][1] - 1, queries[i], arr[queries[i][0] - 1][queries[i][1] - 1], 'r');
            answer[i] = min;
            min = Integer.MAX_VALUE;
        }
        return answer;
    }

    public static void main(String[] args) {
        int rows = 6, columns = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        solution(rows, columns, queries);
    }
}
