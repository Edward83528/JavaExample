package example2_guessNumber;

import java.util.Scanner;

public class GuessNumber {

	public static void main(String[] args) {

		int number1 = (int) (Math.random() * 5) + 1;
		System.out.print("�q�����ͪ���:");
		System.out.println(number1); // ���զ��S��bug
		do {

		} while (number1 != guess());
		System.out.println("�q���P �n�δ�");
	}

	static int guess() {
		System.out.println("�п�J�A�n�q����:");
		Scanner number = new Scanner(System.in);
		int numberguess = number.nextInt();
		return numberguess;
	}

}
