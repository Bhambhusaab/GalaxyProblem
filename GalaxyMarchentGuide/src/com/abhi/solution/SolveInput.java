package com.abhi.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class SolveInput implements RomanNumber {

	public static Map<String, String> mapValues = new HashMap<>();

	public int convertRomanToInt(String str) {
		int num = 0;
		if (checkValidRomanNumber(str)) {
			char[] arr = str.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				int n1 = romanNo(arr[i]);
				if (n1 == 0) {
					return 0;
				}
				if (i + 1 < arr.length) {
					int n2 = romanNo(arr[i + 1]);
					if (n2 == 0) {
						return 0;
					}
					if (n1 >= n2) {
						num += n1;
					} else {
						char c1 = arr[i];
						char c2 = arr[i + 1];
						if (c1 == 'I') {
							if (c2 == 'V' || c2 == 'X') {
								num = num - n1;
							} else {
								return 0;
							}
						} else if (c1 == 'X') {
							if (c2 == 'C' || c2 == 'L') {
								num = num - n1;
							} else {
								return 0;
							}
						} else if (c1 == 'C') {
							if (c2 == 'D' || c2 == 'M') {
								num = num - n1;
							} else {
								return 0;
							}
						} else {
							if (c1 == 'L' || c1 == 'V' || c1 == 'D') {
								return 0;
							}
						}
					}
				} else {
					num += n1;
				}
			}
		}
		return num;
	}

	public double solveInputArray(String[] arr) {
		String str1 = "";
		double num = 0;
		for (String str : arr) {
			if (Pattern.matches("[CDILMVX]+", mapValues.get(str))) {
				str1 += mapValues.get(str);
			} else {
				num += Double.parseDouble(mapValues.get(str));
			}
		}
		if (checkValidRomanNumber(str1) && num > 0)
			return num * convertRomanToInt(str1);
		else if (checkValidRomanNumber(str1))
			return convertRomanToInt(str1);
		else
			return 0;
	}

	public void handleInput(String stringNew) {
		double num = 0;
		if (stringNew.contains("?")) {
			String string = stringNew.replace('?', ' ');
			if (string.toLowerCase().startsWith("does") || string.toLowerCase().startsWith("is")) {
				if (string.toLowerCase().contains("does")) {
					String newString = string.substring(5);
					if (string.toLowerCase().contains("has more credits than")) {
						String[] strArr = newString.split(" has more credits than ");
						double num1 = solveInputArray(strArr[0].split(" "));
						double num2 = solveInputArray(strArr[1].split(" "));
						if (num1 > num2) {
							System.out.println(strArr[0] + " has more credits than " + strArr[1]);
						} else if (num1 < num2) {
							System.out.println(strArr[0] + " has less credits than " + strArr[1]);
						} else {
							System.out.println(strArr[0] + " has equals credits to " + strArr[1]);
						}

					} else if (newString.toLowerCase().contains("has less credits than")) {
						String[] strArr = newString.split(" has less credits than ");
						double num1 = solveInputArray(strArr[0].split(" "));
						double num2 = solveInputArray(strArr[1].split(" "));
						if (num1 > num2) {
							System.out.println(strArr[0] + " has more credits than " + strArr[1]);
						} else if (num1 < num2) {
							System.out.println(strArr[0] + " has less credits than " + strArr[1]);
						} else {
							System.out.println(strArr[0] + " has equals credits to " + strArr[1]);
						}
					} else if (newString.toLowerCase().contains("larger than")) {
						String[] strArr = newString.split(" larger than ");
						double num1 = solveInputArray(strArr[0].split(" "));
						double num2 = solveInputArray(strArr[1].split(" "));
						if (num1 > num2) {
							System.out.println(strArr[0] + " larger than " + strArr[1]);
						} else if (num1 < num2) {
							System.out.println(strArr[0] + " smaller than " + strArr[1]);
						} else {
							System.out.println(strArr[0] + " are equals to " + strArr[1]);
						}

					} else if (newString.toLowerCase().contains("smaller than")) {
						String[] strArr = newString.split(" smaller than ");
						double num1 = solveInputArray(strArr[0].split(" "));
						double num2 = solveInputArray(strArr[1].split(" "));
						if (num1 > num2) {
							System.out.println(strArr[0] + " larger than " + strArr[1]);
						} else if (num1 < num2) {
							System.out.println(strArr[0] + " smaller than " + strArr[1]);
						} else {
							System.out.println(strArr[0] + " are equals to " + strArr[1]);
						}
					}
				} else if (string.toLowerCase().contains("is")) {
					String newString = string.substring(3);
					if (newString.toLowerCase().contains("has more credits than")) {
						String[] strArr = newString.split(" has more credits than ");
						double num1 = solveInputArray(strArr[0].split(" "));
						double num2 = solveInputArray(strArr[1].split(" "));
						if (num1 > num2) {
							System.out.println(strArr[0] + " has more credits than " + strArr[1]);
						} else if (num1 < num2) {
							System.out.println(strArr[0] + " has less credits than " + strArr[1]);
						} else {
							System.out.println(strArr[0] + " has equals credits to " + strArr[1]);
						}

					} else if (newString.toLowerCase().contains("has less credits than")) {
						String[] strArr = newString.split(" has less credits than ");
						double num1 = solveInputArray(strArr[0].split(" "));
						double num2 = solveInputArray(strArr[1].split(" "));
						if (num1 > num2) {
							System.out.println(strArr[0] + " has more credits than " + strArr[1]);
						} else if (num1 < num2) {
							System.out.println(strArr[0] + " has less credits than " + strArr[1]);
						} else {
							System.out.println(strArr[0] + " has equals credits to " + strArr[1]);
						}
					} else if (newString.toLowerCase().contains("larger than")) {
						String[] strArr = newString.split(" larger than ");
						double num1 = solveInputArray(strArr[0].split(" "));
						double num2 = solveInputArray(strArr[1].split(" "));
						if (num1 > num2) {
							System.out.println(strArr[0] + " larger than " + strArr[1]);
						} else if (num1 < num2) {
							System.out.println(strArr[0] + " smaller than " + strArr[1]);
						} else {
							System.out.println(strArr[0] + " are equals to " + strArr[1]);
						}
					} else if (newString.toLowerCase().contains("smaller than")) {
						String[] strArr = newString.split(" smaller than ");
						double num1 = solveInputArray(strArr[0].split(" "));
						double num2 = solveInputArray(strArr[1].split(" "));
						if (num1 > num2) {
							System.out.println(strArr[0] + " larger than " + strArr[1]);
						} else if (num1 < num2) {
							System.out.println(strArr[0] + " smaller than " + strArr[1]);
						} else {
							System.out.println(strArr[0] + " are equals to " + strArr[1]);
						}
					}
				}
			} else if (!string.toLowerCase().contains("does") && !string.toLowerCase().contains("is")) {
				System.out.println("I have no idea what you are talking about.");
			} else {
				String[] strArr = string.split(" is ");
				String[] newArr = strArr[1].split(" ");
				num = solveInputArray(newArr);
				if (num > 0)
					System.out.println(strArr[1] + " is " + num);
				else
					System.out.println("Requested Number is in invalid format");
			}
		} else {
			String str = "";
			String[] strArr = stringNew.split(" is ");
			if (strArr[0].contains(" ")) {
				String[] arr = strArr[0].split(" ");
				for (String s : arr) {
					if (mapValues.containsKey(s)) {
						if (Pattern.matches("[CDILMVX]+", mapValues.get(s))) {
							str += mapValues.get(s);
						} else {
							num += Double.parseDouble(mapValues.get(s));
						}
					} else {
						if (checkValidRomanNumber(str)) {
							double newnum = Double.parseDouble(strArr[1].split(" ")[0]) / convertRomanToInt(str);
							mapValues.put(s, newnum + "");
						} else {
							System.out.println("Input number is invalid");
						}
					}
				}
			} else {
				if (Pattern.matches("[CDILMVX]+", strArr[1].split(" ")[0])) {
					mapValues.put(strArr[0], strArr[1].split(" ")[0]);
				} else {
					num += Integer.parseInt(strArr[1].split(" ")[0]);
					mapValues.put(strArr[0], num + "");
				}
			}
		}
	}
}
