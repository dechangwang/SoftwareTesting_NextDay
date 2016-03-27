package cn.edu.wang;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// 输入年 月 日
		InputData inputData = new InputData();
		// numArr 记录输入的年，月，日
		int[] numArr = inputData.getInput();

		Date date = new Date(numArr[1], numArr[2], numArr[3]);
		NextDay nextDay = new NextDay(date);
		Date res = nextDay.getNextDay();
		if (nextDay != null) {
			System.out.println("next day:" + res);
		}
	}

}
