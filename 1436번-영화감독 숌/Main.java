package app;

import java.util.*;

public class Main {
    public static int calculate(int N) {
        int cnt = 0;
        int sum = 666;
        int cnt2 = 0;
        String temp;
        while (cnt != N) {
            temp = Integer.toString(sum);
            cnt2 = 0;
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == '6') // 6이 연속되는지 확인
                    cnt2++;
                else // 연속 안될경우 초기화
                    cnt2 = 0;

                if (cnt2 == 3) {
                    cnt++;
                    break;
                }
            }

            if (cnt == N)
                break;
            sum++;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        System.out.println(calculate(N));
        s.close();
    }
}