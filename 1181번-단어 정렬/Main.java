package app;

import java.io.*;
import java.util.*;

class Word {
    String word;
    int length;

    Word(String word, int length) {
        this.word = word;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public String getWord() {
        return word;
    }

    @Override
    public int hashCode() {
        return this.word.hashCode() + new Integer(this.length).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Word) {
            Word temp = (Word) obj;
            if (this.word.equals(temp.word) && this.length == temp.length)
                return true;
        }
        return false;
    }
}

class WordCompare implements Comparator<Word> {
    public WordCompare() {
        super();
    }

    public int compare(Word o1, Word o2) {
        int l1 = o1.getLength();
        int l2 = o2.getLength();
        if (l1 > l2)
            return 1;
        else if (l1 < l2)
            return -1;
        else
            return (o1.getWord().compareTo(o2.getWord()));
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int N = Integer.parseInt(br.readLine());
            List<Word> list = new ArrayList<>();
            String temp;
            for (int i = 0; i < N; i++) {
                temp = br.readLine();
                list.add(new Word(temp, temp.length()));
            }

            HashSet<Word> listSet = new HashSet<>(list);
            List<Word> resultList = new ArrayList<>(listSet);
            Collections.sort(resultList, new WordCompare());
            for (int i = 0; i < resultList.size(); i++) {
                bw.write(resultList.get(i).getWord() + "\n");
            }
            bw.close();
            br.close();
        } catch (IOException e) {

        }
    }
}