package app;

import java.io.*;
import java.util.*;

public class Main {
    private static int[][] zone;
    private static int[][] point;

    private static void commend(String s) {
        if (s.equals("R")) {
            if (point[0][1] == 7)
                return; // 킹이 오른쪽 끝에 있을 경우
            else {
                if (point[0][0] == point[1][0]) { // 같은 라인에 있을 경우
                    if (point[0][1] == 6 && point[1][1] == 7) { // 돌이 끝에 있고 킹이 바로 옆에 있을 경우
                        return;
                    } else { // 이동 가능한 경우
                        if (point[0][1] + 1 == point[1][1]) { // 킹 오른쪽에 돌이 있는 경우
                            move('S', point[1][0], point[1][1], point[1][0], point[1][1] + 1);
                        }
                        move('K', point[0][0], point[0][1], point[0][0], point[0][1] + 1);
                    }
                } else
                    move('K', point[0][0], point[0][1], point[0][0], point[0][1] + 1);
            }
        } else if (s.equals("L")) {
            if (point[0][1] == 0)
                return; // 킹이 왼쪽 끝에 있을 경우
            else {
                if (point[0][0] == point[1][0]) { // 같은 라인에 있을 경우
                    if (point[0][1] == 1 && point[1][1] == 0) {// 돌이 끝에 있고 킹이 바로 옆에 있을 경우
                        return;
                    } else { // 이동 가능한 경우
                        if (point[0][1] - 1 == point[1][1]) { // 킹 왼쪽에 돌이 있을 경우
                            move('S', point[1][0], point[1][1], point[1][0], point[1][1] - 1);
                        }
                        move('K', point[0][0], point[0][1], point[0][0], point[0][1] - 1);
                    }
                } else
                    move('K', point[0][0], point[0][1], point[0][0], point[0][1] - 1);
            }
        } else if (s.equals("B")) {
            if (point[0][0] == 7)
                return;// 킹이 맨 아래에 있을 경우
            else {
                if (point[0][1] == point[1][1]) { // 같은 라인에 있을 경우
                    if (point[0][0] == 6 && point[1][0] == 7) { // 돌이 맨 아래에 있고 킹이 바로 위에 있을 경우
                        return;
                    } else { // 이동 가능한 경우
                        if (point[0][0] + 1 == point[1][0]) { // 킹 아래에 돌이 있을 경우
                            move('S', point[1][0], point[1][1], point[1][0] + 1, point[1][1]);
                        }
                        move('K', point[0][0], point[0][1], point[0][0] + 1, point[0][1]);
                    }
                } else
                    move('K', point[0][0], point[0][1], point[0][0] + 1, point[0][1]);
            }
        } else if (s.equals("T")) {
            if (point[0][0] == 0)
                return; // 킹이 맨 위에 있을 경우
            else {
                if (point[0][1] == point[1][1]) { // 같은 라인에 있을 경우
                    if (point[0][0] == 1 && point[1][0] == 0) { // 돌이 맨 위에 있고 킹이 바로 아래에 있을 경우
                        return;
                    } else { // 이동 가능한 경우
                        if (point[0][0] - 1 == point[1][0]) { // 킹 위에 돌이 있는 경우
                            move('S', point[1][0], point[1][1], point[1][0] - 1, point[1][1]);
                        }
                        move('K', point[0][0], point[0][1], point[0][0] - 1, point[0][1]);
                    }
                } else
                    move('K', point[0][0], point[0][1], point[0][0] - 1, point[0][1]);
            }
        } else if (s.equals("RT")) {
            if (point[0][0] == 0 || point[0][1] == 7)
                return; // 킹이 윗줄에 있거나 우측 줄에 있을 경우
            else { // 킹 이동 가능할 경우
                if (point[0][0] - point[1][0] == 1 && point[0][1] - point[1][1] == -1) { // 킹 오른쪽 위에 돌이 있을 경우
                    if (point[1][0] - 1 >= 0 && point[1][1] + 1 <= 7) {// 돌 이동 시점이 유효할 경우
                        move('S', point[1][0], point[1][1], point[1][0] - 1, point[1][1] + 1);
                        move('K', point[0][0], point[0][1], point[0][0] - 1, point[0][1] + 1);
                    } else
                        return;
                } else // 돌이 없을 경우
                    move('K', point[0][0], point[0][1], point[0][0] - 1, point[0][1] + 1);

            }
        } else if (s.equals("LT")) {
            if (point[0][0] == 0 || point[0][1] == 0)
                return; // 킹이 윗줄에 있거나 좌측 줄에 있을 경우
            else { // 킹 이동 가능할 경우
                if (point[0][0] - point[1][0] == 1 && point[0][1] - point[1][1] == 1) { // 킹 왼쪽 위에 돌이 있을 경우
                    if (point[1][0] - 1 >= 0 && point[1][1] - 1 >= 0) { // 돌 이동 시점이 유효할 경우
                        move('S', point[1][0], point[1][1], point[1][0] - 1, point[1][1] - 1);
                        move('K', point[0][0], point[0][1], point[0][0] - 1, point[0][1] - 1);
                    } else
                        return;
                } else // 돌이 없을 경우
                    move('K', point[0][0], point[0][1], point[0][0] - 1, point[0][1] - 1);
            }
        } else if (s.equals("RB")) {
            if (point[0][0] == 7 || point[0][1] == 7)
                return; // 킹이 아랫줄에 있거나 우측 줄에 있을 경우
            else { // 킹 이동 가능할 경우
                if (point[0][0] - point[1][0] == -1 && point[0][1] - point[1][1] == -1) { // 킹 오른쪽 아래에 돌이 있을 경우
                    if (point[1][0] + 1 <= 7 && point[1][1] + 1 <= 7) {// 돌 이동 시점이 유효할 경우
                        move('S', point[1][0], point[1][1], point[1][0] + 1, point[1][1] + 1);
                        move('K', point[0][0], point[0][1], point[0][0] + 1, point[0][1] + 1);
                    } else
                        return;
                } else // 돌이 없을 경우
                    move('K', point[0][0], point[0][1], point[0][0] + 1, point[0][1] + 1);
            }
        } else if (s.equals("LB")) {
            if (point[0][0] == 7 || point[0][1] == 0)
                return; // 킹이 아랫줄에 있거나 좌측 줄에 있을 경우
            else { // 킹 이동 가능할 경우
                if (point[0][0] - point[1][0] == -1 && point[0][1] - point[1][1] == 1) { // 킹 왼쪽 아래에 돌이 있을 경우
                    if (point[1][0] + 1 <= 7 && point[1][1] - 1 >= 0) { // 돌 이동 시점이 유효할 경우
                        move('S', point[1][0], point[1][1], point[1][0] + 1, point[1][1] - 1);
                        move('K', point[0][0], point[0][1], point[0][0] + 1, point[0][1] - 1);
                    } else
                        return;
                } else // 돌이 없을 경우
                    move('K', point[0][0], point[0][1], point[0][0] + 1, point[0][1] - 1);
            }
        }
    }

    private static void move(char c, int x, int y, int moveX, int moveY) {
        zone[x][y] = 0;
        if (c == 'S') {
            zone[moveX][moveY] = 2;
            point[1][0] = moveX;
            point[1][1] = moveY;
        } else {
            zone[moveX][moveY] = 1;
            point[0][0] = moveX;
            point[0][1] = moveY;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        zone = new int[8][8];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        point = new int[2][2];
        for (int i = 0; i < 2; i++) {
            sb.setLength(0);
            sb.append(st.nextToken());
            point[i][1] = sb.charAt(0) - 'A';
            point[i][0] = 7 - (sb.charAt(1) - '1');
            zone[point[i][0]][point[i][1]] = i + 1;
        }
        int N = Integer.parseInt(st.nextToken());
        sb.setLength(0);
        for (int i = 0; i < N; i++) {
            sb.append(br.readLine());
            commend(sb.toString());
            sb.setLength(0);
        }
        for (int i = 0; i < 2; i++) {
            bw.write('A' + point[i][1]);
            bw.write(7 - point[i][0] + 1 + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}