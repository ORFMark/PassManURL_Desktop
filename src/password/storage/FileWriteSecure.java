package password.storage;

import java.io.*;

public class FileWriteSecure {

	private FileWriter writer = null;
	private Crypto cipher = null;
	private final String DIRECTORY = System.getProperty("user.home") + File.separator + "PassManURL" + File.separator;
	private final String newLine = System.lineSeparator();
	FileWriteSecure(String fileName, String encryptionKey) {
		File f = new File(DIRECTORY + fileName);
		if (!f.exists() && !f.isDirectory()) {
			createFile(DIRECTORY + fileName);
		}
		try {
			writer = new FileWriter(DIRECTORY + fileName, true);
			cipher = new Crypto(encryptionKey);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean createFile(String fileName) {
		try {
			File f = new File(DIRECTORY);
			if (!f.exists()) {
				f.mkdirs();
			}
			writer = new FileWriter(fileName);
			writer.write("#URL::Record");
			writer.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean writeRecord(String URL, String userName, String password) {
		String record = newLine + URL.trim() + "::" + cipher.encrypt(userName + "::" + password);
		try {
			writer.write(record);
			writer.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
	}
}

