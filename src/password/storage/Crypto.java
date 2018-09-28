package password.storage;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Crypto {
	private SecretKeySpec secKey;
	private byte[] hiddenKey;
	private void setKey(String key) {
		MessageDigest md = null;
		try {
			hiddenKey = key.getBytes("UTF-8");
			md = MessageDigest.getInstance("SHA-256");
			hiddenKey = md.digest(hiddenKey);
			secKey = new SecretKeySpec(hiddenKey, "AES");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	Crypto(String key) {
		setKey(key);
	}
	public String encrypt(String clearText) throws InvalidKeyException {
		Cipher crypt;
		try {
			crypt = Cipher.getInstance("AES/CBC/PKCS5Padding");
			crypt.init(Cipher.ENCRYPT_MODE, secKey);
			return Base64.getEncoder().encodeToString(crypt.doFinal(clearText.getBytes("UTF-8")));
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String decrypt(String cipherText) {
		Cipher crypt;
		try {
			crypt = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			crypt.init(Cipher.DECRYPT_MODE, secKey);
			return new String(crypt.doFinal(Base64.getDecoder().decode(cipherText)));
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}
}

