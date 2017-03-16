package example34_calendar2;

import javax.swing.JOptionPane;

public class Calendar2 {

	public static void main(String[] args) {

		int[] days_month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String[] days_week = { "日", "一", "二", "三", "四", "五", "六" };
		int totaldays = 0;
		int year = 0;
		int month = 0;
		try {
			year = Integer.parseInt(JOptionPane.showInputDialog("請輸入年"));
			month = Integer.parseInt(JOptionPane.showInputDialog("請輸入月"));

			boolean is_leap_year = false;

			// 1.從1582年開始算,算到你輸入的年分的總天數
			for (int i = 1582; i < year; i++) {
				is_leap_year = isleapyear(i);// 從1582年開始算,算到你輸入的年分的年的所有年是否為閏年

				days_month[1] = is_leap_year ? 29 : 28;// 算2月是28天(非閏年)還是29天(閏年)

				for (int d : days_month)// 從1582年開始算,算到你輸入的年分的年的總天數
				{
					totaldays = totaldays + d;
				}
			}

			// 算輸入的日期的2月有幾天
			is_leap_year = isleapyear(year);
			days_month[1] = is_leap_year ? 29 : 28;

			// 總天數再加上當年的總天數
			// 陣列偏移-1因為陣列days_month的起始位置是0開始
			// 當月天數不算再-1總共-2
			for (int j = 0; j <= (month - 2); j++) {

				totaldays = totaldays + days_month[j];
			}
			// 把星期幾印出來
			for (String s : days_week) {
				System.out.print(s + "\t");
			}
			// 星期都印出來後換行
			System.out.println();
			// 補空格diff
			int diff = (5 + totaldays) % 7;
			// 首先決定第一行要空幾格
			for (int i = 0; i < diff; i++) {
				System.out.print(" " + "\t");
			}
			for (int i = 1; i <= days_month[month - 1]; i++) {
				if ((diff + i) % 7 == 0) {
					System.out.println(i + "\t");
				} else {
					System.out.print(i + "\t");
				}
			}
		} catch (Exception e) {
			System.out.println("你輸入的不是數字或格式不對喔");
		}

	}

	// 判斷是否為閏年
	static boolean isleapyear(int year) {
		boolean learyear = false;
		if ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))) {
			learyear = true;
		}
		return learyear;
	}
}