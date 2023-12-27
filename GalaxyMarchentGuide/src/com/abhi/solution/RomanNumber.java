package com.abhi.solution;

import java.util.HashMap;
import java.util.Map;

public interface RomanNumber {

	static Map<String, String> mapValues = new HashMap<>();

	default boolean checkValidRomanNumber(String str) {
		int cont = 0;
		for (int i = 0; i < str.length(); i++) {
			cont = 0;
			for (int j = i + 1; j < i + 4 && j < str.length(); j++) {
				char c = str.charAt(i);
				if (c == 'I' || c == 'X' || c == 'C' || c == 'M') {
					if (c == str.charAt(j)) {
						cont++;
						if (cont == 3) {
							return false;
						}
					} else {
						break;
					}
				} else {
					if (c == str.charAt(j)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	default int romanNo(char c) {
		if (c == 'I')
			return 1;
		if (c == 'V')
			return 5;
		if (c == 'X')
			return 10;
		if (c == 'L')
			return 50;
		if (c == 'C')
			return 100;
		if (c == 'D')
			return 500;
		if (c == 'M')
			return 100;
		return 0;
	}

	public int convertRomanToInt(String str);

	public double solveInputArray(String[] arr);

	public void handleInput(String stringNew);

}
