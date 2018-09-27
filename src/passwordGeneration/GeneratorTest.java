package passwordGeneration;

public class GeneratorTest {

	public static void main(String[] args) {
		Generator gen = new Generator();
		long seed;
		gen.setDesiredLength(32);
		gen.setMinLetters(4);
		gen.setMinSpecial(2);
		gen.setMinNum(4);
		gen.setRepeat(true);
		seed = gen.generateSeed("Bleh", "Blop", 43);
		gen.setSeed(seed);
		System.out.println(gen.generatePassword());
		GeneratorStrong strong = new GeneratorStrong();
		strong.setDesiredLength(32);
		strong.setMinLetters(4);
		strong.setMinNum(4);
		strong.setMinSpecial(2);
		System.out.println(strong.generatePassword());
	}

}
