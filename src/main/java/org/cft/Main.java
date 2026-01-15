package org.cft;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static boolean shortStats = false;   // -s
    static boolean appendMode = false;   // -a
    static String outputPath = ".";      // -o
    static String prefix = "";           // -p
    static List<String> inputFiles = new ArrayList<>();

    public static void main(String[] args) {
        String[] s = ("-s -a -p sample- in1.txt in2.txt").split(" ");
        readArguments(s);
        System.out.println(shortStats);
        System.out.println(appendMode);
        System.out.println(outputPath);
        System.out.println(prefix);
        System.out.println(inputFiles.toString());
    }

    private static void readArguments(String[] s) {
        for(int i = 0; i< s.length; i++){
            switch (s[i]){
                case "-s":
                    shortStats = true;
                    break;
                case "-a":
                    appendMode=true;
                    break;
                case "-o":
                    if(i+1< s.length){
                        i++;
                        outputPath = s[i];
                    }else{
                        System.out.println("Ошибка: после -o должен быть путь!!");
                    }
                    break;
                case "-p":
                    if(i+1< s.length){
                        i++;
                        prefix = s[i];
                    }else{
                        System.out.println("Ошибка: после -p должен быть путь!!");
                    }
                    break;
                default:
                    inputFiles.add(s[i]);
            }
        }
    }
}