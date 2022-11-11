package Commands;

import java.util.ArrayList;

import CFG.CFG;
import CFG.Grammars;
import CFG.CFGHelper;

import commandLine.Command;

public class AddRule implements Command {

	@Override
	public void execute(String[] args) {
		if(!(Grammars.getGrammarInstance() == null)) {
		if(args.length == 2) {
		CFGHelper.addRule(Grammars.getInstance().getList(), args);
		}
		else {
			 System.out.println("Its addrule <id> <rule>");
		}
		}
		else {
			System.out.println("Open file first!");
		}
		
	}
}
