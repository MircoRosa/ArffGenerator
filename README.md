# Arff Generator
Arff Generator is a library that allows creation of `.arff` files quickly and easily. The `.arff` format is used by the popular suite of machine learning software [WEKA](https://www.cs.waikato.ac.nz/ml/weka/).

If you want to see a practical use case, check out the project "[The Ant Game](https://github.com/MircoRosa/ant-ai)", in which this library has been used extensively.

## Usage
Using the library is pretty straightforward: you only have to extend the `DataSet` abstract class, defining structure and data as you need.

To add an attribute, use
```java
addAttribute("some-attribute","REAL");
```
while for the entries it is sufficient to use the method
```java
addEntry(attr_value1,attr_value2,attr_value3);
```
That's it. With those two methods basically any use case logic needed can be implemented.

After the model has been created, it is possible to generate the output in two ways:

- Exporting the results to an `.arff` file, simply using
```java
dataset.printToFile("/your/full/path/","file_name");
```
- Generating a `String` containing the "arff-formatted" results with
```java
String output = dataset.printToString();
```
The second solution is particularly useful if you are using the Weka APIs directly in your code, as it allows to use the result without the need for a temporary file.

## Example
This sample class models the XOR truth table:
```java
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
```
And it can be used this way:
```java
public static void main(String[] args) throws FileNotFoundException {
	Xor xor = new Xor("TestXor");
	xor.printToFile("/your/full/path/","TestXor");
	System.out.println(xor.printToString());
}
```
#
_This library has been developed for the "Artificial Intelligence" Master's Degree course @University of Parma._