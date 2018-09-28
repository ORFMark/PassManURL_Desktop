package password.storage;

import java.security.InvalidKeyException;

public class CryptoTest {
	public static void run() {
		Crypto c = new Crypto("Test");
		System.out.println("Hello World");
		try {
			String encrypted = c.encrypt("Hello World");
			System.out.println(encrypted);
			String decrypted = c.decrypt(encrypted);
			System.out.println(decrypted);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
