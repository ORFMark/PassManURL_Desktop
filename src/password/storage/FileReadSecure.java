package password.storage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.CharBuffer;
import java.util.Hashtable;

public class FileReadSecure {
	private BufferedReader read = null;
	private Crypto cipher = null;
	private final String DIRECTORY = System.getProperty("user.home") + File.separator + "PassManURL" + File.separator;
	private Hashtable<String, String> records;
	private String loc;

	FileReadSecure(String fileName, String encryptionKey) {
		try {
			loc = DIRECTORY + fileName;
			read = new BufferedReader(new FileReader(loc));
			cipher = new Crypto(encryptionKey);
			records = new Hashtable<String, String>();
			readFileToHashTable();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	private void readFileToHashTable() {
		String line = null;
		String key = null; 
		String record = null;
		boolean start = false;
		try {
			line = read.readLine();
			key = null;
			record = null;
			start = false;
			line = read.readLine();
		} catch (IOException e) {
			System.out.println("ERROR IN INIT");
			e.printStackTrace();
		}
		while(line != null) {
			line = line.trim();
			for(int i = 0; i < line.length(); i++) {
				if (start == false) {
					if (line.charAt(i) == ':' && line.charAt(i+1) == ':') {
						start = true;
						i++;
					}
					else {
						if(key == null) {
							key = Character.toString(line.charAt(i));
						}
						else {
							key += line.charAt(i);
						}
					}
				}
				else {
					if (record == null) {
						record = Character.toString(line.charAt(i));
					} else {
						record += line.charAt(i);
					}
				}
			}
			//System.out.println("Key: " + key + " Record: " + record);
			records.put(key, record);
			key = null;
			record = null;
			start = false;
			try {
				line = read.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


	}
	public String fileReadSecure(String key) {
		return  cipher.decrypt(findRecord(key));
	}

	private String findRecord(String key) {
		String line = records.get(key);
		return line;
	}

}
