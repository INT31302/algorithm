package app;

import java.io.*;
import java.util.*;

class Person {
    private int id;
    private String name;
    private int age;

    Person(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}

class PersonCompare implements Comparator<Person> {
    public PersonCompare() {
        super();
    }

    public int compare(Person o1, Person o2) {
        int i1 = o1.getId();
        int i2 = o2.getId();
        int a1 = o1.getAge();
        int a2 = o2.getAge();

        if (a1 > a2)
            return 1;
        else if (a1 < a2)
            return -1;
        else if (i1 > i2)
            return 1;
        else if (i1 < i2)
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
            List<Person> array = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());
            StringTokenizer temp;
            for (int i = 0; i < N; i++) {
                temp = new StringTokenizer(br.readLine());
                array.add(new Person(i, Integer.parseInt(temp.nextToken()), temp.nextToken()));
            }
            Collections.sort(array, new PersonCompare());
            for (int i = 0; i < N; i++) {
                bw.write(array.get(i).getAge() + " " + array.get(i).getName() + "\n");
            }
            bw.close();
            br.close();
        } catch (IOException e) {

        }
    }
}