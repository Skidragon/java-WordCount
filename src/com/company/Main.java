package com.company;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    private static String readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }

    public static void main(String[] args) throws IOException {
        String text = readFile("C:\\Users\\Capt. Kirk\\IdeaProjects\\wordApp\\src\\rights.txt");
//        System.out.println(text);
        String[] words = text.split("\\s+");
        HashMap<String, Integer> uniqueMap = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            if(uniqueMap.get(word) == null) {
                uniqueMap.put(word, 1);
                continue;
            }
                uniqueMap.put(word, uniqueMap.get(word) + 1);
        }

        ArrayList<HashMap.Entry<String, Integer>> uniqueList = new ArrayList<>();

        uniqueList.addAll(uniqueMap.entrySet());

        Collections.sort(uniqueList, new Comparator<HashMap.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        int frequentWordLimit = 51;
        int count = 1;
        for (HashMap.Entry<String, Integer> wordEntry : uniqueList) {
            if(count == frequentWordLimit) {
                break;
            }
            System.out.println("\nWord: " + count +"\nKey: " + wordEntry.getKey() + "\nValue: " + wordEntry.getValue());
            count++;
        }
    }
}
