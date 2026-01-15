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
        List<String> input = new ArrayList<>();
        {
            FileReader file1 = new FileReader(inputFiles.get(0));
            FileReader file2 = new FileReader(inputFiles.get(1));
            input.addAll(file1.input);
            input.addAll(file2.input);
        }
        LineParser lineParser = new LineParser(input);
        showStatistic(lineParser);//Вывод статистики


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
    private static void showStatistic(LineParser lineParser){
        System.out.println("Статистика");
        if (shortStats){
            System.out.println("Integers");
            System.out.println("кол-во: "+lineParser.integersStats.getCount());
            System.out.println("Floats");
            System.out.println("кол-во: "+lineParser.floatsStats.getCount());
            System.out.println("Strings");
            System.out.println("кол-во: "+lineParser.stringsStats.getCount());
        }else {
            System.out.println("Integers");
            System.out.println("кол-во: "+lineParser.integersStats.getCount());
            System.out.println("макс значение: "+lineParser.integersStats.getMax());
            System.out.println("мин значение: "+lineParser.integersStats.getMin());
            System.out.println("Floats");
            System.out.println("кол-во: "+lineParser.floatsStats.getCount());
            System.out.println("макс значение: "+lineParser.floatsStats.getMax());
            System.out.println("мин значение: "+lineParser.floatsStats.getMin());
            System.out.println("Strings");
            System.out.println("кол-во: "+lineParser.stringsStats.getCount());
            System.out.println("макс значение: "+lineParser.stringsStats.getMax());
            System.out.println("мин значение: "+lineParser.stringsStats.getMin());
        }
    }
}