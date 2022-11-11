package Commands;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import CFG.CFG;
import CFG.CFGHelper;
import CFG.Grammars;
import commandLine.Command;

public class Print implements Command{
	@Override
	public void execute(String[] args) throws IOException, ParserConfigurationException, SAXException {
		if(!(Grammars.getGrammarInstance() == null))	{
			if(args.length == 1) {
		    CFGHelper.print(Grammars.getInstance().getList(), args);
			}
			else {
				System.out.println("Its empty <id>");
			}
		}
		else {
			System.out.println("Open file first!");
			}
		}
}
