import java.util.*;
class Solution {
    int[] nums;
    int cnt = 0;
    int targetNumber;
    private class Result{
        int value, cnt;
        
        public Result(int value, int cnt){
            this.value = value;
            this.cnt = cnt;
        }
    }
    private void bfs(){
        Queue<Result> queue = new ArrayDeque<>();
        queue.offer(new Result(nums[0], 1));
        queue.offer(new Result(-nums[0],1));
        while(!queue.isEmpty()){
            Result r = queue.poll();
            if(r.cnt == nums.length){
                if(r.value == targetNumber) cnt++;
                continue;
            }
            queue.offer(new Result(r.value+nums[r.cnt], r.cnt+1));
            queue.offer(new Result(r.value-nums[r.cnt], r.cnt+1));
        }
    }
    public int solution(int[] numbers, int target) {
        int answer = 0;
        targetNumber = target;
        nums = numbers;
        bfs();
        answer = cnt;
        return answer;
    }
}
