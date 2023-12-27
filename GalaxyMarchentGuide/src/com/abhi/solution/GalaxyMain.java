package com.abhi.solution;

import java.util.Scanner;

public class GalaxyMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String string = sc.nextLine();
			RomanNumber problem = new SolveInput();
			problem.handleInput(string);
		}
		sc.close();
	}
}
