package ua.lviv.iot.christmasfair.manager;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import ua.lviv.iot.christmasfair.model.AbstractDecor;

public class DecorWriter {

	Writer textWriter;

	public void setTextWriter(Writer textWriter) {
		this.textWriter = textWriter;
	}

	public void writeToFile(List<AbstractDecor> decorations) throws IOException {
		for (AbstractDecor currentDecor : decorations) {
			String lineToWrite = currentDecor.getHeaders() + ", " + currentDecor.toCSV();
			writeLine(textWriter, lineToWrite);
		}
		textWriter.flush();
	}

	private void writeLine(Writer writer, String text) throws IOException {
		writer.write(text + "\r\n");
	}

	@Override
	public String toString() {
		return textWriter.toString();
	}
	
	
}
