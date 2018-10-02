package password.storage;

import java.io.*;

public class FileWriteSecure {

	private FileWriter writer = null;
	private Crypto cipher = null;

	FileWriteSecure(String loc, String encryptionKey) {
		try {
			writer = new FileWriter(loc);
			cipher = new Crypto(encryptionKey);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean writeRecord(String URL, String userName, String password) {
		String record = "URL: " + URL + '\n' + "Username: " + userName + '\n' + "Password: " + password + '\n';
		record = cipher.encrypt(record);
		if (writer != null) {
			try {
				writer.write(record);
				writer.close();
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		} else {
			return false;
		}
	}
}
