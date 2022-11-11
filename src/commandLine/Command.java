package commandLine;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public interface Command {
	void execute(String[] args) throws IOException, ParserConfigurationException, SAXException;
}
