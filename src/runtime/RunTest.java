package runtime;

import password.generation.GeneratorTest;
import password.storage.CryptoTest;


public class RunTest {
	public static void main(String args[]) {
		GeneratorTest.run(32, true);
		CryptoTest.run();
		//GeneratorTest.run(16, true);
	}

}
