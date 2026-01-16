package org.cft;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public static List<String> readFile(String path){
        List<String> input = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new java.io.FileReader(path))){
            String line;
            while((line = reader.readLine())!=null){
                input.add(line);
            }
            return input;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
