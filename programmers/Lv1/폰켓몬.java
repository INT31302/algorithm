import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int solution(int[] nums) {
        int answer = 0;
        int size = nums.length / 2;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        if(size<=set.size()){
            answer = size;
        }else{
            answer =set.size();
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2,3};
        System.out.println(solution(nums));
    }
}
