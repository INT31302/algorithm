import java.util.ArrayList;

public class Solution {
    static ArrayList<String> oper_combination = new ArrayList<>();

    public static void combination(char[] operator, char[] output, boolean[] isVisited, int depth, int r) {
        if (r == depth) {
            StringBuilder sb = new StringBuilder();
            for (char c : output) {
                sb.append(c);
            }
            oper_combination.add(sb.toString());
            return;
        }
        for (int i = 0; i < operator.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                output[depth] = operator[i];
                combination(operator, output, isVisited, depth + 1, r);
                isVisited[i] = false;
            }
        }
    }

    private static long getSum(ArrayList<Character> copied_operators, ArrayList<Long> copied_numbers, String s) {
        for (char c : s.toCharArray()) {
            for (int i = 0; i < copied_operators.size(); i++) {
                long cal = 0;
                if (copied_operators.get(i) == c) {
                    if (c == '+')
                        cal = copied_numbers.get(i) + copied_numbers.get(i + 1);
                    else if (c == '-')
                        cal = copied_numbers.get(i) - copied_numbers.get(i + 1);

                    else if (c == '*')
                        cal = copied_numbers.get(i) * copied_numbers.get(i + 1);
                    copied_numbers.set(i, cal);
                    copied_numbers.remove(i + 1);
                    copied_operators.remove(i);
                    i--;
                }
            }
        }
        return copied_numbers.get(0);
    }

    public static long solution(String expression) {
        long answer = 0;
        int cnt = 0;
        StringBuilder sbExpression = new StringBuilder(expression);
        StringBuilder temp = new StringBuilder();

        if (expression.contains("-")) temp.append("-");
        if (expression.contains("+")) temp.append("+");
        if (expression.contains("*")) temp.append("*");

        ArrayList<Long> numbers = new ArrayList<>();
        ArrayList<Character> operators = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) sb.append(c);
            else {
                numbers.add(Long.parseLong(sb.toString()));
                sb.replace(0, sb.length(), "");
                operators.add(c);
            }
        }
        numbers.add(Long.parseLong(sb.toString()));
        int length = temp.length();
        combination(temp.toString().toCharArray(), new char[length], new boolean[length], 0, length);
        for (String s : oper_combination) {
            long sum = 0;
            ArrayList<Character> copied_operators = (ArrayList<Character>) operators.clone();
            ArrayList<Long> copied_numbers = (ArrayList<Long>) numbers.clone();
            sum = getSum(copied_operators, copied_numbers, s);
            answer = Math.max(answer, Math.abs(sum));
        }
        return answer;
    }

    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        System.out.println(solution(expression));
    }
}
