package ua.lviv.iot.christmasfair.manager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import ua.lviv.iot.christmasfair.model.AbstractDecor;

public class DecorWriter {
	public static void writeToFile(List<AbstractDecor> decorations, String filePath) {
		File file = new File(filePath);
		DecorWriter.writeToFile(decorations, file);
	}

	public static void writeToFile(List<AbstractDecor> decorations, File file) {
		try (Writer textWriter = new FileWriter(file, StandardCharsets.UTF_8);) {
			for (AbstractDecor currentDecor : decorations) {
				String lineToWrite = currentDecor.getHeaders() + ", " + currentDecor.toCSV();
				DecorWriter.writeLine(textWriter, lineToWrite);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	private static void writeLine(Writer writer, String text) throws IOException {
		writer.write(text + "\r\n");
	}
}
