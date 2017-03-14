package example27_calendar1;

import java.util.Scanner;

public class Calendar1 {
	// 適用於1582年之後
	public static void main(String[] args) {
		calendar();
	}

	// 判斷是否為閏年
	static boolean isleap_year(int year) {
		boolean learyear = false;
		if ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))) {
			learyear = true;
		}
		return learyear;

	}

	// 求出幾年幾月幾日為星期幾
	static void calendar() {
		// 2003年每個月的S值(s值為該月的第一天的前一天為星期S)
		/*
		  先查出某年某月的s值列表觀察規律
		      1 2 3 4 5 6 7 8 9 10 11 12 
		 2002 1 4 4 0 2 5 0 3 6  1  4  6
	     2003 2 5 5 1 3 6 1 4 0  2  5  0 
	     2004 3 6 0 3 5 1 3 6 2  4  0  2
		  會發現2003年的s值會比2003年+1(因為一年365天mod7會餘1)
		  但2004年的三月後卻是+2(因為2004年是閏年,2月會多一天)
		 */
		// 2003年每個月的S值(s值為該月的第一天的前一天為星期S)
		// int S[]={2, 5, 5, 1, 3, 6, 1, 4, 0, 2, 5, 0};
		int S[] = { 5, 1, 1, 4, 6, 2, 4, 0, 3, 5, 1, 3 };// 因為之後求出的答案會比真正的少3,所以把每月S都加3
		int s;
		Scanner input = new Scanner(System.in);
		System.out.println("請輸入你要查的年份:");
		int y = input.nextInt();
		System.out.println("請輸入你要查的月份:");
		int m = input.nextInt();
		System.out.println("請輸入你要查哪一天:");
		int d = input.nextInt();
		s = S[m - 1] + y + (y / 4) - (y / 100) + (y / 400);
		if (isleap_year(y) && m < 3) {
			s--;
		} else {
			s++;
		}
		System.out.printf("%d年%d月%d日為星期%d(0為日)", y, m, d, (s + d) % 7);
	}

}
