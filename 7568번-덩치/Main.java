package app;

import java.io.*;
import java.util.*;

class Person {
    private int x;
    private int y;
    private int rank;

    Person(int x, int y) {
        this.x = x;
        this.y = y;
        this.rank = 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRank() {
        return rank;
    }

    public void addRank() {
        this.rank = this.rank + 1;
    }

}

public class Main {

    public static void calculate(Person[] person, int N) {
        int x, y, p, q;
        for (int i = 0; i < N; i++) {
            x = person[i].getX();
            y = person[i].getY();
            for (int j = 0; j < N; j++) {
                if (i == j)
                    continue;
                else {
                    p = person[j].getX();
                    q = person[j].getY();
                    if (x < p && y < q) {
                        person[i].addRank();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int N = Integer.parseInt(br.readLine());
            Person[] person = new Person[N];
            int x, y;
            for (int i = 0; i < N; i++) {
                String temp = br.readLine();
                StringTokenizer temp_st = new StringTokenizer(temp);
                x = Integer.parseInt(temp_st.nextToken());
                y = Integer.parseInt(temp_st.nextToken());
                person[i] = new Person(x, y);
            }
            calculate(person, N);
            for (int i = 0; i < N; i++) {
                bw.write(person[i].getRank() + "");
                if (i < N - 1)
                    bw.write(" ");
            }
            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
        }
    }
}
