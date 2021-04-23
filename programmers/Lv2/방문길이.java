import java.util.*;
class Solution {
    private class Point{
        int x, y;
        public Point(){
            this(5,5);
        }
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        public boolean equals(Point obj){
            return this.x == obj.x && this.y == obj.y;
        }
    }
    public int solution(String dirs) {
        int answer = 0;
        char[] temp = dirs.toCharArray();
        HashSet<Point[]> set = new HashSet<>();
        Point robot = new Point();
        for(int i =0; i<temp.length; i++){
            Point prev = new Point(robot.x, robot.y);
            if(temp[i] == 'U'){
                if(robot.x+1 >10) continue;
                else robot.x +=1;
            }else if(temp[i] == 'D'){
                if(robot.x-1<0) continue;
                else robot.x -=1;
            }else if(temp[i] == 'L'){
                if(robot.y-1<0) continue;
                else robot.y -=1;
 
            }else if(temp[i] == 'R'){
                if(robot.y+1>10) continue;
                else robot.y+=1;
            }
            Point next = new Point(robot.x, robot.y);
            Point[] route = {prev, next};
            boolean isExist = false;
            for(Point[] r : set){
                if(r[0].equals(prev) && r[1].equals(next)){
                    isExist = true;
                    break;
                }
                if(r[0].equals(next) && r[1].equals(prev)){
                    isExist = true;
                    break;
                }
            }
            if(!isExist) answer++;
        
            set.add(route);
        }
         return answer; 
    }
        
}
