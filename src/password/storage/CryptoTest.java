package password.storage;

import java.security.InvalidKeyException;

public class CryptoTest {
	public static void run() {
		String testPass = "password";
		String salt = "salty";
		FileWriteSecure write = new FileWriteSecure("data.dat", testPass);
		FileReadSecure read = new FileReadSecure("data.dat", testPass);
		System.out.println(Hash.hash(testPass, salt));
		write.writeRecord("Google.com", "IAmATest", testPass);
		int line = read.FindRecord("Goolge.com");
		System.out.println(read.fileReadSecure(line));
		
		
	}
}
