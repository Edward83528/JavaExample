package example18_primenumber;

public class Primenumber {

	public static void main(String[] args) {
		print();
	}

	static void print() {
		for (int i = 1; i <= 100; i++) {
			// 如果10的倍數就輸出換行
			if (i % 10 == 0) {
				System.out.println(i);
			} else {
				if (isprime(i) && i != 1) {
					System.out.printf("*%d\t", i);
				} else {
					System.out.printf("%d\t", i);
				}
			}

		}
	}

	static boolean isprime(int a) {
		boolean b = true;
		// i<a才不會被自己整數
		for (int i = 2; i < a; i++) {
			if (a % i == 0) {
				b = false;
				break;
			}
		}

		return b;
	}
}
