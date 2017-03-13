package example4_findNumber;

import java.util.Scanner;

public class FindNumber {
	public static void main(String[] args) {
		int number[] = { 1, 10, 31, 33, 37, 48, 60, 70, 80 };

		int input = findf();

		for (int i = 0; i < number.length; i++) {
			if (number[i] == input) {
				System.out.println(number[i]);
				break;
			} else {
				System.out.println("-1");
			}

		}
	}

	static int findf() {
		Scanner a = new Scanner(System.in);
		System.out.println("輸入你要找的數:");
		int find = a.nextInt();
		return find;
	}
}