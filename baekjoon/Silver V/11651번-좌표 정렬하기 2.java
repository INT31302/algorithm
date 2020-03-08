package app;

import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class PointCompare implements Comparator<Point> {
    public PointCompare() {
        super();
    }

    public int compare(Point o1, Point o2) {
        int x1 = o1.getX();
        int x2 = o2.getX();
        int y1 = o1.getY();
        int y2 = o2.getY();
        if (y1 > y2)
            return 1;
        else if (y1 < y2)
            return -1;
        else if (x1 > x2)
            return 1;
        else if (x1 < x2)
            return -1;
        else
            return 0;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            List<Point> array = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());
            StringTokenizer temp;
            for (int i = 0; i < N; i++) {
                temp = new StringTokenizer(br.readLine());
                array.add(new Point(Integer.parseInt(temp.nextToken()), Integer.parseInt(temp.nextToken())));
            }
            Collections.sort(array, new PointCompare());
            for (int i = 0; i < N; i++) {
                bw.write(array.get(i).getX() + " " + array.get(i).getY() + "\n");
            }
            bw.close();
            br.close();
        } catch (IOException e) {

        }
    }
}