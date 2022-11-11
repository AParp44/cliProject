package Commands;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import CFG.CFG;
import CFG.CFGHelper;
import CFG.Grammars;
import commandLine.Command;

public class RemoveRule implements Command {
	@Override
	public void execute(String[] args) throws IOException, ParserConfigurationException, SAXException {
		if(!(Grammars.getGrammarInstance() == null))	{
			if(args.length == 2) {
		    CFGHelper.removeRule(Grammars.getInstance().getList(), args);
		}
			else {
				System.out.println("Its removeRule <id> <index>");
			}
		}
		
		else {
			System.out.println("Open file first!");
			}
		}
}
