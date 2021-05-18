import java.util.Arrays;

class Solution {
    public static int[] solution(int[] lottos, int[] win_nums) {
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        int result[] = {6, 6, 5, 4, 3, 2, 1};
        int zero_cnt = 0;
        int cnt = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) zero_cnt++;
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    cnt++;
                    break;
                }
            }
        }
        int[] answer = {result[zero_cnt+cnt], result[cnt]};
        return answer;
    }

    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25},
                win_nums = {31, 10, 45, 1, 6, 19};
        System.out.println(Arrays.toString(solution(lottos, win_nums)));
    }
}