package org.cft;

import java.util.ArrayList;
import java.util.List;

public class LineParser {
    List<String> input = new ArrayList<>();
    List<String> integers = new ArrayList<>();
    List<String> floats = new ArrayList<>();
    List<String> strings = new ArrayList<>();

    public LineParser(List<String> input) {
        this.input = input;
        String intRegex = "^[+-]?\\d+$";
        String floatRegex = "^[+-]?(\\d+(\\.\\d+)?|\\.\\d+)([eE][+-]?\\d+)?$";
        for(String line : input){
            if(line==null||line.isBlank()){
                continue;
            }
            String value = line.trim();
            if(value.matches(intRegex)){
                integers.add(value);
            }else if(value.matches(floatRegex)){
                floats.add(value);
            }else{
                strings.add(value);
            }
        }
    }
}
