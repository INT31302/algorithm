
public class Solution {
    public static String trimComma(String str) {
        int startIdx = 0, endIdx = str.length();
        if (str.length() == 0) return "";
        if (str.indexOf(".") == 0)
            startIdx++;
        if (str.lastIndexOf(".") == str.length() - 1)
            endIdx--;
        return str.substring(startIdx, endIdx);
    }

    public static String solution(String new_id) {
        StringBuilder answer = new StringBuilder();
        StringBuilder tempSb = new StringBuilder();
        new_id = new_id.toLowerCase();
        boolean isComma = false;
        int cntComma = 0;
        for (char c : new_id.toCharArray()) {

            if (Character.isLowerCase(c) || Character.isDigit(c) || c == '-' || c == '_' || c == '.') {
                if (c == '.') {
                    isComma = true;
                    cntComma++;
                    continue;
                } else isComma = false;

                if (!isComma) {
                    if (cntComma > 0) {
                        tempSb.append(".");
                        cntComma = 0;
                    }
                    tempSb.append(c);
                }
            }
        }
        String temp = trimComma(tempSb.toString());

        if (temp.length() == 0) temp = "a";

        if (temp.length() >= 16) {
            temp = temp.substring(0, 15);
            answer.append(trimComma(temp));
        } else if (temp.length() <= 2) {
            answer.append(temp);
            while (answer.length() < 3) {
                answer.append(answer.charAt(answer.length() - 1));
            }
        } else answer.append(temp);

        return answer.toString();
    }

    public static void main(String[] args) {
        String[] new_id = {"...!@BaT#*..y.abcdefghijklm", "z-+.^.", "=.=", "123_.def", "abcdefghijklmn.p"};
        for (String s : new_id) {
            System.out.println(solution(s));
        }
//        System.out.println(solution(new_id));
    }
}
