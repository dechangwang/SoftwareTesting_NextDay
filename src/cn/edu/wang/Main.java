package cn.edu.wang;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// ������ �� ��
		InputData inputData = new InputData();
		// numArr ��¼������꣬�£���
		int[] numArr = inputData.getInput();

		Date date = new Date(numArr[1], numArr[2], numArr[3]);
		NextDay nextDay = new NextDay(date);
		Date res = nextDay.getNextDay();
		if (nextDay != null) {
			System.out.println("next day:" + res);
		}
	}

}
