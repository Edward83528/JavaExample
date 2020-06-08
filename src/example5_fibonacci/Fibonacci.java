package example5_fibonacci;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		System.out.println("請輸入你要求到幾的費氏數列:");
		int number = a.nextInt();
		for (int i = 0; i < number; i++) {
			System.out.printf("%d \t", fib(i));
		}
	}

	static int fib(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fib(n - 1) + fib(n - 2);
		}

	}

}
