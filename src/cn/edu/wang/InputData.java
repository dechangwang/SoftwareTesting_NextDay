package cn.edu.wang;

import java.util.Scanner;

public class InputData {
	private int[] data;

	public InputData() {
		data = new int[4];
	}

	public int[] getInput() {
		int year, month, day, i = 0;
		Scanner sc;

		//默认只允许输错次数不大于5
		for (i = 0; i < 5; i++) {
			System.out.println("Please enter year:");
			try {
				sc = new Scanner(System.in);
				year = sc.nextInt();
				data[1] = year;
				break;

			} catch (Exception e) {
				System.out.println("Please enter a positive integer");
			}
		}
		if (i == 5) {
			System.out.println("you entered wrong too munch");
			return data;
		}

		for (i = 0; i < 5; i++) {
			System.out.println("Please enter month:");
			try {
				sc = new Scanner(System.in);
				month = sc.nextInt();
				data[2] = month;
				break;
			} catch (Exception e) {
				System.out.println("Please enter a positive integer");

			}
		}
		if (i == 5) {
			System.out.println("you entered wrong too munch");
			return data;
		}
		for (i = 0; i < 5; i++) {
			System.out.println("Please enter day:");
			try {
				sc = new Scanner(System.in);
				day = sc.nextInt();
				data[3] = day;
				break;
			} catch (Exception e) {
				System.out.println("Please enter a positive integer");
			}
		}
		if (i == 5) {
			System.out.println("you entered wrong too munch");
			return data;
		}
		return data;
	}
}
