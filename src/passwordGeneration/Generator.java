package passwordGeneration;

import java.util.Random;

public class Generator {
	private Random gen;
	private int length;
	private int minSpec;
	private int minNum;
	private int minAlpha;
	boolean repeatAllowed;

	Generator() {
		gen = new Random();
		length = 16;
		minSpec = 0;
		minNum = 0;
		minAlpha = 0;
		repeatAllowed = true;
	};

	private boolean repeated(char[] array, int len, char c) {
		for (int i = 0; i < len; i++) {
			if (array[i] == c) {
				return true;
			}
		}
		return false;
	}

	protected boolean isSpecial(char c) {
		return ((int) c >= 33 && (int) c <= 47) || ((int) c >= 58 && (int) c <= 64) || ((int) c >= 91 && (int) c <= 96)
				|| ((int) c >= 123 && (int) c <= 126);
	}

	protected boolean isNum(char c) {
		return (int) c >= 48 && (int) c <= 57;
	}

	protected boolean isAlpha(char c) {
		return ((int) c >= 65 && (int) c <= 90) || ((int) c >= 97 && (int) c <= 122);
	}

	protected void setSeed(long seed) {
		gen.setSeed(seed);
	}

	public void setDesiredLength(int l) {
		length = l;
	}

	public void setMinSpecial(int s) {
		minSpec = s;
	}

	public void setMinNum(int n) {
		minNum = n;
	}

	public void setMinLetters(int l) {
		minAlpha = l;
	}

	public long generateSeed(String name, String URL, int PIN) {
		long seed = 0;
		int x = (int) URL.charAt((URL.length() - 1));
		int y = (int) name.charAt(name.length() / 2);
		int z = PIN << 2;
		seed = (long) (((x + y + z) ^ name.charAt(0)) | PIN);
		return seed;
	}

	public String generatePassword() {
		System.out.println(length);
		char password[] = new char[length];
		char toAdd;
		int special = 0, num = 0, alpha = 0;
		boolean validPassword = false;
		while (!validPassword) {
			for (int i = 0; i < length; i++) {
				toAdd = (char) (gen.nextInt(93) + 33);
				if ((repeatAllowed == false && repeated(password, i, toAdd)) || repeatAllowed == true) {
					password[i] = toAdd;
				} else {
					continue;
				}
				if (isSpecial(toAdd)) {
					special++;
				} else if (isNum(toAdd)) {
					num++;
				} else if (isAlpha(toAdd)) {
					alpha++;
				} else {
					continue;
				}
				System.out.print(toAdd);

			}
			if (special >= minSpec && num >= minNum && alpha >= minAlpha) {
				validPassword = true;
				System.out.println();
			}
		}
		System.out.println(password.toString().length());
		return password.toString();
	}
	
}