package passwordGeneration;

public class GeneratorTest {

	public static void main(String[] args) {
		Generator gen = new Generator();
		long seed;
		gen.setDesiredLength(32);
		gen.setMinLetters(4);
		gen.setMinSpecial(2);
		gen.setMinNum(4);
		seed = gen.generateSeed("markrb0609@gmail.com", "google.com", 1205);
		gen.setSeed(seed);
		System.out.println(gen.generatePassword());
	}

}
