package Commands;

import java.util.ArrayList;

import CFG.CFG;
import CFG.Grammars;
import commandLine.Command;

public class List implements Command{

	@Override
	public void execute(String[] args) {
		if(!(Grammars.getGrammarInstance() == null))	{
			if(args.length==0) {
		for (int i =0 ;i<Grammars.getInstance().getList().size();i++) {
			System.out.println( Grammars.getInstance().getList().get(i));
	
		}
			}
			else {
				System.out.println("its just list");
			}
		}
		 else {
			System.out.println("Open file first!");
			}
		
	}

}
