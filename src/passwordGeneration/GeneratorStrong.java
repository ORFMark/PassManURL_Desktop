package passwordGeneration;

import java.security.SecureRandom;

public class GeneratorStrong extends Generator {
	private SecureRandom gen = new SecureRandom();

	GeneratorStrong() {
		super();
	}

	public String generatePassword() {
		char password[] = new char[length];
		char toAdd;
		int special, num, alpha, attemptedPass = 0;
		;
		boolean validPassword = false;
		String finalPassword = "";
		while (!validPassword) {
			attemptedPass++;
			special = 0;
			num = 0;
			alpha = 0;
			for (int i = 0; i < length; i++) {
				toAdd = (char) (gen.nextInt(93) + 33);
				if ((repeatAllowed == false && !repeated(password, i, toAdd)) || repeatAllowed == true) {
					password[i] = toAdd;
				} else {
					continue;
				} if(isSpecial(toAdd)) {
					special++;
				} else if (isNum(toAdd)) {
					num++;
				} else if (isAlpha(toAdd)) {
					alpha++;
				} else {
					continue;
				}

			}
			if (special >= minSpec && num >= minNum && alpha >= minAlpha) {
				validPassword = true;
			}
			if (attemptedPass >= 1000000) {
				break;
			}
		}if(attemptedPass<1000000)

	{
		for (int j = 0; j < length; j++) {
			finalPassword += password[j];
		}
	}else
	{
		System.out.println("Too strict of password Critera, reduce the critera or increase the length");
		return null;
	}return finalPassword;
}}
