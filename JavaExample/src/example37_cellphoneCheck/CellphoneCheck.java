package example37_cellphoneCheck;

import java.util.Scanner;

public class CellphoneCheck {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("請輸入你想確認的手機號碼:");
		String number = input.nextLine();
		if (number.matches("^09[0-9]{8}$")) {
			System.out.println("格式正確");
		} else {
			System.out.println("格式錯誤");
		}
	}

}
