package password.storage;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import password.generation.GeneratorStrong;

public class Hash {
	public static String hash(String message) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(message.getBytes("UTF-8"));
			byte[] digest = md.digest();
			String hex = String.format("%064x", new BigInteger(1, digest));
			return hex;
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String hash(String message, String salt) {
		try {
			message = salt+message;
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(message.getBytes("UTF-8"));
			byte[] digest = md.digest();
			String hex = String.format("%064x", new BigInteger(1, digest));
			return hex;
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static boolean checkHash(String knownHash, String ThingToCheck) {
		return knownHash.equals(ThingToCheck);
	}
	public static String generateSalt() {
		GeneratorStrong s =new GeneratorStrong();
		s.setRepeat(false);
		String salt = s.generatePassword();
		return salt;
	}
}
