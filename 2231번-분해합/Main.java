package app;

import java.util.*;

public class Main {
    public static int calculate(int N) {
        int sum = 0;
        String temp;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum = i; // 자기 자신 더함
            temp = Integer.toString(sum);
            for (int j = 0; j < temp.length(); j++) {
                sum += Integer.parseInt(temp.substring(j, j + 1)); // 각 자릿수 값 더함
            }
            if (sum == N) { // 값을 찾았을 경우
                sum = i;
                break;
            }
            if (i >= N) { // i값이 N 값을 초과하는 경우
                sum = 0;
                break;
            }
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(calculate(N));
        scanner.close();
    }
}