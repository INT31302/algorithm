class Solution {
    public int solution(String s) {
       int answer = 0;
        int max_cut = s.length() / 2;
        int min_length = s.length();
        StringBuilder src = new StringBuilder();
        StringBuilder dest = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= max_cut; i++) {
            int cnt = 1;
            src.replace(0, src.length(), "");
            dest.replace(0, dest.length(), "");
            for (int j = 1; j <= s.length() / i; j++) {
                if (j * i + i > s.length()) {
                    if (cnt > 1)
                        result.append(cnt);
                    result.append(src);
                    result.append(s.substring(j * i, s.length()));
                    break;
                }
                if (j == 1)
                    src.append(s.substring(0, 0 + i));
                dest.append(s.substring(j * i, j * i + i));
                if (src.toString().equals(dest.toString()))
                    cnt++;
                else {
                    if (cnt > 1) {
                        result.append(cnt);
                        cnt = 1;
                    }
                    result.append(src);
                    src.replace(0, src.length(), "");
                    src.append(dest);
                }
                dest.replace(0, dest.length(), "");
            }
            min_length = min_length > result.length() ? result.length() : min_length;
            result.replace(0, result.length(), "");
        }
        answer = min_length;
        return answer;
    }
}
