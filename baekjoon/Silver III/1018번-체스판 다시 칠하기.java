package app;

import java.util.*;

public class Main {
    public static int conut_fill(char[][] array) {
        int cnt[] = new int[2];
        char temp = 'B';
        for (int z = 0; z < 2; z++) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (array[i][j] != temp) // array와 temp가 다른 경우
                        cnt[z]++;
                    if (temp == 'B')
                        temp = 'W';
                    else
                        temp = 'B';
                }
                if (temp == 'B')
                    temp = 'W';
                else
                    temp = 'B';
            }
            temp = 'W';
        }
        return cnt[0] > cnt[1] ? cnt[1] : cnt[0];
    }

    public static int calculate(char[][] array, int N, int M) {
        int min = -1;
        int result = 0;
        int i_cnt = 0, j_cnt = 0;
        int start_row = 0;
        int start_col = 0;
        if (N == 8 && M == 8) {
            return conut_fill(array);
        }
        char[][] chess_board = new char[8][8];
        for (int z = 0; z < N - 7; z++) { // row 끝까지 이동
            for (int k = 0; k < M - 7; k++) { // column 끝까지 이동
                /* 보드를 8x8씩 자름 */
                for (int i = start_row; i < N; i++) {
                    if (i_cnt == 8) // row로 8칸 채웠을 경우
                        break;
                    for (int j = start_col; j < M; j++) {
                        if (j_cnt == 8) // column으로 8칸 채웠을 경우
                            break;
                        chess_board[i - start_row][j - start_col] = array[i][j];
                        j_cnt++;
                    }
                    j_cnt = 0;
                    i_cnt++;
                }
                result = conut_fill(chess_board);
                chess_board = new char[8][8];
                if (min == -1)
                    min = result;
                else if (min > result)
                    min = result;
                i_cnt = 0;
                start_col++;
            }
            start_col = 0;
            start_row++;
        }
        return min;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        char array[][];
        String temp;
        char C;
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        array = new char[N][M];
        for (int i = 0; i < N; i++) {
            temp = scanner.next();
            for (int j = 0; j < M; j++) {
                array[i][j] = temp.charAt(j);
            }
        }
        System.out.println(calculate(array, N, M));
        scanner.close();
    }
}