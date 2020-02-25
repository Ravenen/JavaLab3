package ua.lviv.iot.christmasfair;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.christmasfair.manager.DecorReader;
import ua.lviv.iot.christmasfair.manager.DecorWriter;
import ua.lviv.iot.christmasfair.model.AbstractDecor;

class DecorWriterReaderTest extends BaseChristmasFairTest {

	private static final String OUTPUT_FILE_PATH = "objects.csv";

	@BeforeEach
	void setUp() {
		createDecorations();
	}

	@Test
	void decorWriterReaderTest() {
		DecorWriter.writeToFile(decorations, OUTPUT_FILE_PATH);
		List<String> lines = DecorReader.readLinesFromFile(OUTPUT_FILE_PATH);
		
		assertEquals(7, lines.size());
		
		for (int currentIndex = 0; currentIndex < lines.size(); currentIndex++) {
			AbstractDecor currentDecor = decorations.get(currentIndex);
			String currentLine = lines.get(currentIndex);
			assertEquals(currentDecor.getHeaders() + ", " + currentDecor.toCSV(), currentLine);
		}
	}
}
