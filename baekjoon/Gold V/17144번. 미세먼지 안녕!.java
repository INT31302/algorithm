import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int R, C, T;
    static int[][] arr, temp;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static Point top, bottom;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void air(Point p, int x, int y, int value, char direction) {
        if (p.x == x && p.y == y) return;
        int val = temp[x][y];
        temp[x][y] = value;
        if (direction == 'r') {
            y += 1;
            if (y < C) air(p, x, y, val, 'r');
            else {
                y -= 1;
                if (p.equals(top)) {
                    x -= 1;
                    air(p, x, y, val, 't');
                } else {
                    x += 1;
                    air(p, x, y, val, 'b');
                }
            }
        } else if (direction == 't') {
            x -= 1;
            if (x >= 0) air(p, x, y, val, 't');
            else {
                x += 1;
                y -= 1;
                air(p, x, y, val, 'l');
            }
        } else if (direction == 'l') {
            y -= 1;
            if (y >= 0) air(p, x, y, val, 'l');
            else {
                y += 1;
                if (p.equals(top)) {
                    x += 1;
                    air(p, x, y, val, 'b');
                } else {
                    x -= 1;
                    air(p, x, y, val, 't');
                }
            }
        } else if (direction == 'b') {
            x += 1;
            if (x < R) air(p, x, y, val, 'b');
            else {
                x -= 1;
                y -= 1;
                air(p, x, y, val, 'l');
            }
        }
    }

    static void bfs() {
        temp = new int[R][C];
        temp[top.x][top.y] = -1;
        temp[bottom.x][bottom.y] = -1;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == -1 || arr[i][j] == 0) continue;
                int sum = arr[i][j] / 5;
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int px = i + dx[k];
                    int py = j + dy[k];
                    if (px < 0 || px >= R || py < 0 || py >= C || arr[px][py] == -1) continue;
                    temp[px][py] += arr[i][j] / 5;
                    cnt++;
                }
                temp[i][j] += arr[i][j] - sum * cnt;
            }
        }
        int value = temp[top.x][top.y + 1];
        temp[top.x][top.y + 1] = 0;
        air(top, top.x, top.y + 2, value, 'r');
        value = temp[bottom.x][bottom.y + 1];
        temp[bottom.x][bottom.y + 1] = 0;
        air(bottom, bottom.x, bottom.y + 2, value, 'r');
        arr = temp.clone();
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == -1) {
                    if (top == null) top = new Point(i, j);
                    else bottom = new Point(i, j);
                }
            }
        }
        for (int i = 0; i < T; i++) bfs();

        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sum += arr[i][j];
            }
        }
        bw.write((sum + 2) + "\n");
        bw.close();
        br.close();
    }
}
