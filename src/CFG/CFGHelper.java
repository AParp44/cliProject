package CFG;

import java.util.ArrayList;

import io.XmlWrite;

public  class CFGHelper {
	public static CFG addRule(ArrayList<CFG> list, String arr[]) {

		try {
			for (CFG cfg : list) {
				
					int selectedId = Integer.parseInt(arr[0]);
					if (cfg.getId() == selectedId) {
						int index = list.indexOf(cfg);
						cfg.addRule(cfg, arr, selectedId, index, list);
						System.out.println("Successfully added new rule!");
					}
				
				

			}
		} catch (NumberFormatException e) {
			 System.out.println("Its addrule <id> <rule>");
			
		}

		return null;

	}
	public static CFG removeRule(ArrayList<CFG> list, String arr[]) {
		try {
			int parsing = Integer.parseInt(arr[1]);
			for (CFG cfg : list) {
				int selectedId = Integer.parseInt(arr[0]);
				if (cfg.getId() == selectedId) {
					int index = list.indexOf(cfg);
					cfg.removeRule(index, list, cfg, parsing, selectedId);
					System.out.println("Successfully removed rule!");
				}

			}
		} catch (NumberFormatException e) {
			 System.out.println("Its removeRule <id> <index>");
		}

		return null;

	}
	public static CFG print(ArrayList<CFG> list, String arr[]) {
		
		try {
			for (CFG cfg : list) {
				int selectedId = Integer.parseInt(arr[0]);
				if (cfg.getId() == selectedId) {
					cfg.print(selectedId, cfg);
				}

			}
		} catch (NumberFormatException e) {
			 System.out.println("Its print <id>");
		}

		return null;

	}
public static CFG empty(ArrayList<CFG> list, String arr[]) {
		
		try {
			for (CFG cfg : list) {
				int selectedId = Integer.parseInt(arr[0]);
					cfg.empty(selectedId, cfg);
			}
		} catch (NumberFormatException e) {
			 System.out.println("Its empty <id>");
		}
		return null;

	}
public static CFG chomsky(ArrayList<CFG> list, String arr[]) {
	
	try {
		for (CFG cfg : list) {
			int selectedId = Integer.parseInt(arr[0]);
				cfg.chomsky(selectedId, cfg);
		}
	} catch (NumberFormatException e) {
		 System.out.println("Its chomsky <id>");
	}
	return null;

}
public static CFG union(ArrayList<CFG> list, String arr[]) {
	
	try {
		int selectedId = Integer.parseInt(arr[0]);
		int selectedId2 = Integer.parseInt(arr[1]);
		CFG gr1 = null;
		CFG gr2 = null;
		for (CFG cfg : list) {
			if (cfg.getId() == selectedId) {
				gr1 = cfg;
			}
			if (cfg.getId() == selectedId2) {
				gr2 = cfg;
			}
		}
		if (gr1 != null) {
			if (gr1.getGrammar().contains(gr2.getGrammar())) {
				System.out.println("Cannot have duplicate rules!");
			}else if(gr2.getGrammar().contains(gr1.getGrammar())) {
				System.out.println("Cannot have duplicate rules!");
			}
			else {
				list.add(gr1.union(selectedId, selectedId2, gr2, list.size(), list));
				System.out.println("Successfully united grammars "+selectedId+" and "+selectedId2+",new grammar ID:"+(list.size()-1));
			}

		} else {
			System.out.println("Grammar is not initialized");
		}
	} catch (NumberFormatException e) {
		 System.out.println("Its union <id1> <id2>");
	}
	return null;

}
public static CFG chomskify(ArrayList<CFG>list,String arr[]) {
try {
	int selectedId = Integer.parseInt(arr[0]);
	CFG gr1 = null;
	for (CFG cfg : list) {
		if (cfg.getId() == selectedId) {
			gr1 = cfg;
		}
	}
	if (gr1 != null) {
		gr1.chomskify(list, selectedId);
		if(!gr1.getGrammar().contains("R")) {
		System.out.println("Successfully chomskified grammar "+selectedId+",new grammar ID:"+(list.size()-1));
		}
	
	} else {
		System.out.println("Grammar is not initialized");
	}
} catch (NumberFormatException e) {
	 System.out.println("Its chomskify <id>");
}
return null;
}
public static CFG cyk(ArrayList<CFG>list,String arr[]) {
	try {
		CFG gr1 = null;
		String word = arr[1];
		int selectedId = Integer.parseInt(arr[0]);
		for (CFG cfg : list) {
			if (cfg.getId() == selectedId) {
				gr1 = cfg;
			}
		}
		if (gr1 != null) {
			gr1.cyk(word, list, selectedId);
			

		} else {
			System.out.println("Grammar is not initialized");
		}
	} catch (NumberFormatException e) {
		 System.out.println("Its cyk <id> <word>");
	}
return null;
}
public static CFG concat(ArrayList<CFG>list,String arr[]) {
	try {
		int id1 = Integer.parseInt(arr[0]);
		int id2 = Integer.parseInt(arr[1]);
		CFG gr1 = null;
		CFG gr2 = null;
		for (CFG cfg : list) {
			if (cfg.getId() == id1) {
				gr1 = cfg;
			}
			if (cfg.getId() == id2) {
				gr2 = cfg;
			}
		}
		if (gr1 != null) {
			list.add(gr1.concat(gr2, list.size()));
			System.out.println("Successfully concatenated grammars "+id1+" and "+id2+",new grammar ID:"+(list.size()-1));

		} else {
			System.out.println("Grammar is not initialized");
		}
	} catch (NumberFormatException e) {
		 System.out.println("Its concat <id1> <id2>");	}
return null;
}
public static CFG iter(ArrayList<CFG>list,String arr[]) {
	try {
		CFG gr1 = null;
		int number = 3;
		int selectedId = Integer.parseInt(arr[0]);
		for (CFG cfg : list) {
			if (cfg.getId() == selectedId) {
				gr1 = cfg;

			}
		}
		if (gr1 != null) {
			gr1.iter(number, list);
			System.out.println("Successfully iterated!");

		} else {
			System.out.println("Grammar is not initialized");
		}
	} catch (NumberFormatException e) {
		 System.out.println("Its iter <id>");
	}
return null;
}
public static CFG save(ArrayList<CFG>list,String arr[]) {
	try {
		for (CFG cfg : list) {
			int selectedId = Integer.parseInt(arr[0]);
			if (cfg.getId() == selectedId) {
				String fn = arr[1];
				XmlWrite xwrite = new XmlWrite();
				xwrite.writeXmlFile2(cfg, fn, list);
				System.out.println("Grammar successfuly saved in " + fn);
			}
		}
	} catch (NumberFormatException e) {
		 System.out.println("Its save <id> <file>");
	}
return null;
}

}
