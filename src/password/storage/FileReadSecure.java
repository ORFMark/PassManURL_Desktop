package password.storage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.CharBuffer;

public class FileReadSecure {
	private BufferedReader read = null;
	private Crypto cipher = null;
	private final String DIRECTORY = System.getProperty("user.home") + File.separator + "PassManURL" + File.separator;
	private String loc;

	FileReadSecure(String fileName, String encryptionKey) {
		try {
			loc = DIRECTORY + fileName;
			read = new BufferedReader(new FileReader(loc));
			cipher = new Crypto(encryptionKey);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String fileReadSecure(String key) {
		String record = findRecord(key);
		String encrypted = "";
		boolean start = false;
		int i = 0;
		if (record.equals(null)) {
			return null;
		} else {
			record = record.trim();
			for (i = 2; i < record.length(); i++) {
				if (record.charAt(i - 1) == ':' && record.charAt(i - 2) == ':') {
					start = true;
				}
				if (start) {
					encrypted += record.charAt(i);
				}
			}
			return cipher.decrypt(encrypted);
		}

	}

	public String fileReadSecure(String key, boolean includeURL) {
		if (includeURL) {
			return findRecord(key);
		} else {
			String record = findRecord(key);
			String encrypted = "";
			boolean start = false;
			int i = 0;
			if (record.equals(null)) {
				return null;
			} else {
				record = record.trim();
				for (i = 2; i < record.length(); i++) {
					if (record.charAt(i - 1) == ':' && record.charAt(i - 2) == ':') {
						start = true;
					}
					if (start) {
						encrypted += record.charAt(i);
					}
				}
				return cipher.decrypt(encrypted);
			}

		}
	}

	private String findRecord(String key) {
		String line = null;
		do {
			try {
				line = read.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (line != null && !line.contains(key));
		return line;
	}

}
