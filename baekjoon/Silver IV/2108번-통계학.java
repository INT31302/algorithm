package app;

import java.io.*;
import java.util.*;

public class Main {
    public static int[] calculate(ArrayList<Integer> array, int N) {
        int[] result = new int[4];
        int sum = 0;
        int num;
        if (N == 1) {
            for (int i = 0; i < 3; i++) {
                result[i] = array.get(0);
            }
        } else {
            for (int i = 0; i < N; i++) {
                sum += array.get(i);
            }
            if (sum == 0)
                result[0] = 0;
            else
                result[0] = (int) Math.round((double) sum / N);
            result[1] = array.get(N / 2);
            result[3] = array.get(array.size() - 1) - array.get(0);
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            int max = 1;
            int temp;
            for (int i = 0; i < array.size(); i++) {
                num = array.get(i);
                if (treeMap.size() != 0) {
                    if (treeMap.containsKey(num)) {
                        temp = treeMap.get(num) + 1;
                        treeMap.put(num, temp);
                        if (max < temp)
                            max = temp;
                    } else
                        treeMap.put(num, 1);
                } else
                    treeMap.put(num, 1);
            }
            Object[] keys = treeMap.keySet().toArray();
            if (max == 1) {
                result[2] = (Integer) keys[1];
            } else {
                int cnt = 0;
                for (int i = 0; i < treeMap.size(); i++) {
                    if (treeMap.get(keys[i]) == max) {
                        if (cnt == 1) {
                            result[2] = (Integer) keys[i];
                            break;
                        } else {
                            result[2] = (Integer) keys[i];
                            cnt++;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Integer> array = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                array.add(Integer.parseInt(br.readLine()));
            }
            Collections.sort(array);
            int[] result;
            result = calculate(array, N);
            for (int i = 0; i < 4; i++) {
                bw.write(result[i] + "\n");
            }
            bw.close();
            br.close();
        } catch (IOException e) {

        }
    }
}