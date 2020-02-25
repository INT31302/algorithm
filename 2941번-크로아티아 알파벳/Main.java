package app;

import java.util.Scanner;

class Main {

    public static int find_Word(String input, String array[]) {
        int cnt = 0;
        for (int i = 0; i < array.length; i++) {
            if (input.contains(array[i])) {
                input = input.replaceFirst(array[i], " ");
                cnt++;
                if (input.contains(array[i]))
                    i--;
            }
        }
        input = input.replaceAll(" ", "");
        cnt += input.length();
        return cnt;
    }

    public static void main(String[] args) {
        String temp;
        String croatia_String[] = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
        Scanner scanner = new Scanner(System.in);
        temp = scanner.nextLine();
        scanner.close();
        System.out.println(find_Word(temp, croatia_String));
    }
}