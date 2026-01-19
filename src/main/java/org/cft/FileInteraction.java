package org.cft;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileInteraction {

    public static List<String> readFile(String path) {
        List<String> input = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                input.add(line);
            }
            return input;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveFile(String path, String name, List<String> lines, boolean appendMode) {
        if (lines == null || lines.isEmpty()) {
            return;
        }
        try {
            Path dir = Path.of(path);
            Files.createDirectories(dir);
            Path file = dir.resolve(name);
            if (appendMode) {
                Files.write(file, lines, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } else {
                Files.write(file, lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Ошибка записи файла: " + path + "/" + name);
        }
    }
}
