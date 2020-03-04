package ua.lviv.iot.christmasfair.manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

public class DecorReader {

  public static List<String> readLinesFromFile(String path) {
    File file = new File(path);
    return DecorReader.readLinesFromFile(file);
  }

  public static List<String> readLinesFromFile(File file) {
    List<String> lines = new LinkedList<String>();
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8));) {
      String currentLine = null;
      while ((currentLine = bufferedReader.readLine()) != null) {
        lines.add(currentLine);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return lines;
  }
}
