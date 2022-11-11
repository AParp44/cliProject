package Commands;

import java.util.ArrayList;

import CFG.CFG;
import commandLine.Command;
import CFG.CFGHelper;
import CFG.Grammars;

public class Chomskify implements Command {
	

	@Override
	public void execute(String[] args) {
		
		if(!(Grammars.getGrammarInstance() == null)) {
			if(args.length == 1) {
		CFGHelper.chomskify(Grammars.getInstance().getList(), args);
			}
			else {
				System.out.println("Its chomskify <id>");
			}
		}
		else {
			System.out.println("Open file first!");
		}
	}
}
