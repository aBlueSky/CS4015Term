public class PrintableChar {
	private char character;

	public void printSelf() {
		System.out.print(character);
	}

	public PrintableChar(char character) {
		this.character = character;
	}
}