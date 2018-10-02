package password.storage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadSecure {
	private FileReader read = null;
	private Crypto cipher = null;
	
	FileReadSecure(String loc, String encryptionKey) {
		try {
			read = new FileReader(loc);
			cipher = new Crypto(encryptionKey);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String fileReadSecure() {
		char[] array = null;
		String record = "";
		if (read != null) {
			try {
				array = new char[128];
				read.read(array);
				read.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
			for(int i = 0; array[i] != '\0'; i++) {
				record += array[i];
			}
			
			return cipher.decrypt(record);
			}
		else {
			return null;
		}
	}

}
