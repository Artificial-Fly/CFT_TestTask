package org.cft;

import java.io.FileNotFoundException;
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
//        String[] s = ("-s -a -p sample- in1.txt in2.txt").split(" ");
        readArguments(args);
        List<String> input = new ArrayList<>();
        try {
            for (String path : inputFiles) {
                input.addAll(FileInteraction.readFile(path));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Parser parser = new Parser(input);
        showStatistic(parser);//Вывод статистики
        FileInteraction.saveFile(outputPath, prefix + "integers.txt", parser.integers, appendMode);
        FileInteraction.saveFile(outputPath, prefix + "floats.txt", parser.floats, appendMode);
        FileInteraction.saveFile(outputPath, prefix + "strings.txt", parser.strings, appendMode);

    }

    private static void readArguments(String[] s) {
        for (int i = 0; i < s.length; i++) {
            switch (s[i]) {
                case "-s":
                    shortStats = true;
                    break;
                case "-f":
                    break;
                case "-a":
                    appendMode = true;
                    break;
                case "-o":
                    if (i + 1 < s.length) {
                        i++;
                        outputPath = s[i];
                    } else {
                        System.out.println("Ошибка: после -o должен быть путь!!");
                    }
                    break;
                case "-p":
                    if (i + 1 < s.length) {
                        i++;
                        prefix = s[i];
                    } else {
                        System.out.println("Ошибка: после -p должен быть префикс!!");
                    }
                    break;
                default:
                    inputFiles.add(s[i]);
            }
        }
    }

    private static void showStatistic(Parser parser) {
        System.out.println("Stats:");
        if (shortStats) {
            System.out.println("Integers");
            System.out.println("count: " + parser.integersStats.getCount());
            System.out.println("Floats");
            System.out.println("count: " + parser.floatsStats.getCount());
            System.out.println("Strings");
            System.out.println("count: " + parser.stringsStats.getCount());
        } else {
            System.out.println("Integers");
            System.out.println("count: " + parser.integersStats.getCount());
            System.out.println("max: " + parser.integersStats.getMax());
            System.out.println("min: " + parser.integersStats.getMin());
            System.out.println("Floats");
            System.out.println("count: " + parser.floatsStats.getCount());
            System.out.println("max: " + parser.floatsStats.getMax());
            System.out.println("min: " + parser.floatsStats.getMin());
            System.out.println("Strings");
            System.out.println("count: " + parser.stringsStats.getCount());
            System.out.println("max: " + parser.stringsStats.getMax());
            System.out.println("min: " + parser.stringsStats.getMin());
        }
    }
}