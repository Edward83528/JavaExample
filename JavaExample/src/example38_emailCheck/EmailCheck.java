package example38_emailCheck;

import java.util.Scanner;

public class EmailCheck {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("請輸入你想確認的電子信箱:");
		String mail = input.nextLine();
		if (mail.matches("^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$")) {
			System.out.println("格式正確");
		} else {
			System.out.println("格式錯誤");
		}
	}

}
