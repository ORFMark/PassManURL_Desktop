package password.storage;

import java.security.InvalidKeyException;

public class CryptoTest {
	public static void run() {
		String testPass = "password";
		String salt = "salty";
		FileWriteSecure write = new FileWriteSecure("C:\\Users\\Mark\\Documents\\PassManURL_Desktop\\src\\runtime\\test.txt", testPass);
		FileReadSecure read = new FileReadSecure("C:\\\\Users\\\\Mark\\\\Documents\\\\PassManURL_Desktop\\\\src\\\\runtime\\\\test.txt", testPass);
		String hashedThing = Hash.hash(testPass, salt);
		String testSaltedEquiv = Hash.hash(testPass, salt);
		String testUnsaltedEquiv = Hash.hash(testPass);
		System.out.println(Hash.checkHash(hashedThing, testSaltedEquiv));
		System.out.println(Hash.checkHash(hashedThing, testUnsaltedEquiv));
		System.out.println(Hash.hash(testPass, salt));
		Crypto c = new Crypto(testPass);
		String encrypted;
		encrypted = c.encrypt(hashedThing);
		System.out.println(((hashedThing.equals((c.decrypt(encrypted))))));
		System.out.println(c.decrypt(encrypted));
		write.writeRecord("Google.com", "test@gmail.com", "test");
		System.out.println(read.fileReadSecure());
	}
}
