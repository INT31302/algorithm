package app;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int T = Integer.parseInt(br.readLine());
            String temp;
            String[] p, x;
            int n, D_cnt = 0;
            boolean R_switch = false;
            LinkedList<String> list = new LinkedList<>();
            Loop1: for (int i = 0; i < T; i++) {
                D_cnt = 0;
                p = br.readLine().split("");
                n = Integer.parseInt(br.readLine());
                temp = br.readLine();
                temp = temp.substring(1, temp.length() - 1);
                x = temp.split(",");
                for (int d = 0; d < p.length; d++) {
                    if (p[d].equals("D"))
                        D_cnt++;
                    if (D_cnt > n) {
                        bw.write("error\n");
                        continue Loop1;
                    }
                }
                for (int z = 0; z < n; z++) {
                    list.add(x[z]);
                }
                for (int j = 0; j < p.length; j++) {
                    if (p[j].equals("R"))
                        R_switch = !R_switch;
                    else if (p[j].equals("D")) {
                        if (R_switch)
                            list.removeLast();
                        else
                            list.removeFirst();
                    }
                }
                if (R_switch) {
                    Collections.reverse(list);
                    R_switch = false;
                }
                bw.write("[");
                while (list.size() != 0) {
                    bw.write(list.removeFirst() + "");
                    if (list.size() != 0)
                        bw.write(",");
                }
                bw.write("]\n");
            }
            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
        }
    }
}