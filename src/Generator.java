import arff.Xor;

import java.io.FileNotFoundException;

public class Generator {

	private static final String path = "/home/mirco/Desktop/";

	public static void main(String[] args) throws FileNotFoundException {
		Xor xor = new Xor("TestXor");
		xor.printToFile(path,"TestXor");
	}
}
