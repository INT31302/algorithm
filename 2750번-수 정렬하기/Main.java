package app;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            al.add(scanner.nextInt());
        }
        Collections.sort(al);
        for (int i = 0; i < N; i++) {
            System.out.println(al.get(i));
        }
        scanner.close();
    }
}