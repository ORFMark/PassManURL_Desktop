package password.storage;

import java.io.IOException;

public class CryptoTest {
	public static void run() {
		String testPass = "password";
		String salt = "salty";
		
		try {
			FileWriteSecure write = new FileWriteSecure("data.dat", testPass);
			FileReadSecure read = new FileReadSecure("data.dat", testPass);
			System.out.println(Hash.hash(testPass, salt));
			write.writeRecord("Google.com", "IAmATest", testPass);
			write.writeRecord("ernie.org", "smithj", "randomInput");
			write.close();
			System.out.println(read.fileReadSecure("ernie.org"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
