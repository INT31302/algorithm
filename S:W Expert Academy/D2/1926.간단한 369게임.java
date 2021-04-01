import java.io.*;

public class Solution {
    static int check(int i){
        int cnt = 0;
        while(i!=0){
            int num = i%10;
            switch (num){
                case 3:
                case 6:
                case 9:
                    cnt++;
                default:
                    i /= 10;
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int result = check(i+1);
            if(result != 0){
                for (int j = 0; j < result; j++) {
                    bw.write('-');
                }
            }else bw.write(i+1+"");
            bw.write(" ");
        }
        bw.close();
        br.close();
    }
}
