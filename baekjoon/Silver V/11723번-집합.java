package app;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());
        boolean[] list = new boolean[20];
        String[] input;
        String command;
        int number = 0;
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            command = input[0];
            if (input.length > 1)
                number = Integer.parseInt(input[1]);
            switch (command) {
                case "add":
                    list[number - 1] = true;
                    break;
                case "remove":
                    list[number - 1] = false;
                    break;
                case "check":
                    if (list[number - 1])
                        bw.write(1 + "\n");
                    else
                        bw.write(0 + "\n");
                    break;
                case "toggle":
                    list[number - 1] = !list[number - 1];
                    break;
                case "all":
                    for (int j = 0; j < 20; j++) {
                        list[j] = true;
                    }
                    break;
                case "empty":
                    for (int j = 0; j < 20; j++) {
                        list[j] = false;
                    }
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}