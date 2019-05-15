package com.feng;

import java.io.*;
import java.util.Scanner;
import java.util.TreeMap;

public class FileAnalysis {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.next();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        TreeMap<Character , Integer> treeMap = new TreeMap();
        int ch;
        while ((ch = bufferedReader.read()) != -1){
            char c = (char)ch;
            treeMap.put(c , !treeMap.containsKey(c) ? 1 : treeMap.get(c) + 1);
        }
        bufferedReader.close();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("time.txt"));
        for (Character character : treeMap.keySet()) {
            switch (character){
                case '\t':
                    bufferedWriter.write("\\t" + "=" + treeMap.get(character));
                    break;
                case '\n':
                    bufferedWriter.write("\\n" + "=" + treeMap.get(character));
                    break;
                case '\r':
                    bufferedWriter.write("\\r" + "=" + treeMap.get(character));
                    break;
                default:
                    bufferedWriter.write(character + "=" + treeMap.get(character)); //写出键和值
                    break;
            }
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
    //sadasd
}
