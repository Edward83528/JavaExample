package example39_homephoneCheck;

import java.util.Scanner;

public class HomephoneCheck {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("請輸入你想確認的家用電話:");
		String number = input.nextLine();
		/*
		 * .(符合任意字元),x*(x出現0次或多次),x+(x出現一次或多次),x?(x出現一次或完全沒有),x{n}x出現n次,x{n,}
		 * x至少出現n次,x{n,m} x至少出現n次但不超過m次,x出現1次或完全沒有,可加|或閘(或是)
		 */
		if (number.matches("^0[2-8]-[0-9]{8}$")) {
			System.out.println("格式正確");
		} else {
			System.out.printf("格式錯誤\t");
			System.out.println("範例:04-26272127");
		}

	}

}