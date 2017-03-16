package example2_guessNumber;

import java.util.Scanner;

public class GuessNumber {

	public static void main(String[] args) {

		int number1 = (int) (Math.random() * 5) + 1;
		System.out.print("電腦產生的數:");
		System.out.println(number1); // 測試bug用
		do {

		} while (number1 != guess());
		System.out.println("猜對了 好棒棒 ");
	}

	static int guess() {
		System.out.println("輸入你要猜的數:");
		Scanner number = new Scanner(System.in);
		int numberguess = number.nextInt();
		return numberguess;
	}

}
