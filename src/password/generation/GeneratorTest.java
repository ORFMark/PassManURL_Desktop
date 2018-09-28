package password.generation;

public class GeneratorTest {

	public static void run(int length, boolean s) {
		GeneratorWeak gen = new GeneratorWeak();
		long seed;
		if (s == false) {
			gen.setDesiredLength(32);
			gen.setMinLetters(4);
			gen.setMinSpecial(2);
			gen.setMinNum(4);
			gen.setRepeat(true);
			seed = gen.generateSeed("bleh", "blop", 43);
			gen.setSeed(seed);
			System.out.println(gen.generatePassword());
		}
		else {
			GeneratorStrong strong = new GeneratorStrong();
			strong.setDesiredLength(32);
			strong.setMinLetters(4);
			strong.setMinNum(4);
			strong.setMinSpecial(2);
			System.out.println(strong.generatePassword());
		}
	}
}
