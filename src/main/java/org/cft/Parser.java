package org.cft;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    List<String> integers = new ArrayList<>();
    Stats<Long> integersStats = new Stats<Long>(0,0L,0L);//в случае, если попадется число выходящее за диапазон int
    List<String> floats = new ArrayList<>();
    Stats<Double> floatsStats = new Stats<Double>(0,0.0,0.0);//в случае, если попадется число выходящее за диапазон float
    List<String> strings = new ArrayList<>();
    Stats<Integer> stringsStats = new Stats<Integer>(0,0,0);

    public Parser(List<String> input) {
        String intRegex = "^[+-]?\\d+$";
        String floatRegex = "^[+-]?(\\d+(\\.\\d+)?|\\.\\d+)([eE][+-]?\\d+)?$";
        for(String line : input){
            if(line==null||line.isBlank()){
                continue;
            }
            String value = line.trim();
            if(value.matches(intRegex)){
                integers.add(value);
                integersStats.increaseCount();
                long temp = Long.parseLong(value);//в случае, если попадется число выходящее за диапазон int
                if(temp> integersStats.getMax()){
                    integersStats.setMax(temp);
                }
                if(temp< integersStats.getMin()||integersStats.getCount()==1){
                    integersStats.setMin(temp);
                }
            }else if(value.matches(floatRegex)){
                floats.add(value);
                floatsStats.increaseCount();
                double temp = Double.parseDouble(value);//в случае, если попадется число выходящее за диапазон float
                if(temp> floatsStats.getMax()){
                    floatsStats.setMax(temp);
                }
                if(temp< floatsStats.getMin()||floatsStats.getCount()==1){
                    floatsStats.setMin(temp);
                }
            }else{
                strings.add(value);
                stringsStats.increaseCount();
                int temp = value.length();
                if(temp> stringsStats.getMax()){
                    stringsStats.setMax(temp);
                }
                if(temp< stringsStats.getMin()||stringsStats.getCount()==1){
                    stringsStats.setMin(temp);
                }
            }
        }
    }
}
