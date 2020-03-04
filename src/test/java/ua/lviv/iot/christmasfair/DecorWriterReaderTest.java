package ua.lviv.iot.christmasfair;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.christmasfair.manager.DecorWriter;
import ua.lviv.iot.christmasfair.model.AbstractDecor;

class DecorWriterReaderTest extends BaseChristmasFairTest {

  private static final String OUTPUT_FILE_PATH = "objects.csv";
  DecorWriter decorWriter;

  @BeforeEach
  void setUp() {
    createDecorations();
    decorWriter = new DecorWriter();
  }

  @Test
  void testDecorFileWriter() {
    try (Writer fileWriter = new FileWriter(OUTPUT_FILE_PATH);) {
      decorWriter.setTextWriter(fileWriter);
      decorWriter.writeToFile(decorations);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  void testDecorStringWriter() {
    try (Writer stringWriter = new StringWriter();) {
      decorWriter.setTextWriter(stringWriter);
      decorWriter.writeToFile(decorations);
    } catch (IOException e) {
      e.printStackTrace();
    }

    String expectedString = "";
    for (AbstractDecor currentDecor : decorations) {
      expectedString += currentDecor.getHeaders() + ", " + currentDecor.toCSV() + "\r\n";
    }

    assertEquals(expectedString, decorWriter.toString());
  }
}
