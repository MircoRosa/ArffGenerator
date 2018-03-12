package arff;

/**
 * Sample class
 */
public class Xor extends DataSet {

	public Xor(String name) {
		super(name);
		initializeStructure();
		generateDataSet();
	}

	private void initializeStructure() {
		addAttribute("x-val","REAL");
		addAttribute("y-val","REAL");

		addAttribute("class","0","1");
	}


	private void generateDataSet() {
		addEntry(0,0,0);
		addEntry(1,0,1);
		addEntry(0,1,1);
		addEntry(1,1,0);
	}


}
