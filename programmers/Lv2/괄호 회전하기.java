import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);
        do{
            Stack<Character> stack = new Stack<>();
            boolean check = true;
            for(int i =0; i<sb.length(); i++){
                char c = sb.charAt(i);
                if(c=='(' || c =='{' || c=='[') stack.push(c);
                else if(c==')' || c=='}' || c==']'){
                    if(stack.isEmpty()){
                        check = false;
                        break;
                    }
                    else if(c==')' && stack.peek() == '(') stack.pop();
                    else if(c=='}' && stack.peek()=='{') stack.pop();
                    else if(c==']' && stack.peek()=='[') stack.pop();
                    else{
                        check = false;
                        break;
                    }
                }
            }
            if(stack.isEmpty() && check) answer++;
            char c = sb.charAt(0);
            sb = sb.replace(0, 1, "");
            sb = sb.append(c);
            
        }while(!s.equals(sb.toString()));
        return answer;
    }
}
