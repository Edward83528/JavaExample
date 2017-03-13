package example20_money_ArabicNumerals_Change_Chinese;

import java.util.Scanner;
import java.util.Scanner;

public class Money_ArabicNumerals_Change_Chinese {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("輸入你要匯款的金額:");
		String w = input.nextLine();
		int b = w.length(); // 取字串的長度判斷是幾位數

		test(b, w);

	}

	static void test(int a, String v) {
		String S = v;
		String S1[] = new String[a];// 利用輸入的字串長度new出相對應的字串空間
		String S2[] = { "兆", " 仟", "佰", "拾", "億", "千", "佰", "拾", "萬", "仟", "佰", "拾", "元整" };
		for (int i = 0; i < a; i++) {
			switch (S.charAt(i)) { // 數字換國字
			case '0':
				S1[i] = "";
				break;
			case '1':
				S1[i] = "壹";
				break;
			case '2':
				S1[i] = "貳";

				break;
			case '3':
				S1[i] = "參";

				break;
			case '4':
				S1[i] = "肆";

				break;
			case '5':
				S1[i] = "伍";

				break;
			case '6':
				S1[i] = "陸";

				break;
			case '7':
				S1[i] = "柒";

				break;
			case '8':
				S1[i] = "捌";

				break;
			case '9':
				S1[i] = "玖";

				break;

			}
		}

		for (int x = 0; x < S1.length; x++) {

			if (a == 13) {

				System.out.print(S1[x] + S2[x]);

			} else if (a == 12) {

				System.out.print(S1[x] + S2[x + 1]);
			} else if (a == 11) {

				System.out.print(S1[x] + S2[x + 2]);
			} else if (a == 10) {

				System.out.print(S1[x] + S2[x + 3]);
			} else if (a == 9) {

				System.out.print(S1[x] + S2[x + 4]);
			} else if (a == 8) {

				System.out.print(S1[x] + S2[x + 5]);
			} else if (a == 7) {

				System.out.print(S1[x] + S2[x + 6]);
			} else if (a == 6) {

				System.out.print(S1[x] + S2[x + 7]);
			} else if (a == 5) {

				System.out.print(S1[x] + S2[x + 8]);
			} else if (a == 4) {

				System.out.print(S1[x] + S2[x + 9]);
			} else if (a == 3) {

				System.out.print(S1[x] + S2[x + 10]);
			} else if (a == 2) {
				System.out.print(S1[x] + S2[x + 11]);
			} else {
				System.out.print(S1[x] + S2[x + 12]);
			}

		}

	}
}