public class FlyWeightFactory {

	private PrintableChar[] printableCharPool = new PrintableChar[256];

	public PrintableChar getFlyweight(char key) {
		if (printableCharPool[key] == null)
			printableCharPool[key] = new PrintableChar(key);
		return printableCharPool[key];
	}

	public FlyWeightFactory() {

	}
}