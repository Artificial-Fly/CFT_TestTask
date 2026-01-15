package org.cft;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    String path = "";
    List<String> input = new ArrayList<>();
    public FileReader(String path) {
        this.path = path;
        try(BufferedReader reader = new BufferedReader(new java.io.FileReader(path))){
            String line;
            while((line = reader.readLine())!=null){
                input.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
