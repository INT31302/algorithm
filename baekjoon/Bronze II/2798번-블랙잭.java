package app;

import java.util.*;

public class Main {
    public static int calculate(int[] array, int N, int M) {
        int sum;
        int max = 0;
        for (int i = 0; i < N - 2; i++) { // 마지막 카드 - 2까지만 반복
            for (int j = i + 1; j < N - 1; j++) { // 마지막 카드 -1 까지만 반복
                for (int z = j + 1; z < N; z++) { // 마지막 카드까지 반복
                    sum = array[i] + array[j] + array[z];
                    if (sum == M)
                        return sum;
                    else if (sum < M) {
                        if (max < sum)
                            max = sum;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int N, M;
        int[] array;
        N = scanner.nextInt();
        M = scanner.nextInt();
        array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(calculate(array, N, M));
        scanner.close();
    }
}