package example18_primenumber;

public class Primenumber {

	public static void main(String[] args) {
		boolean p = true;

		for (int i = 11; i <= 100; i++) {

			for (int j = 2; j < 100; j++) {
				if (i % j == 0)
					p = false;
				break;
			}

			if (i % 10 == 0) {

				System.out.println(i);

			} else {

				if (p) {
					System.out.printf("$%d\t", i);
				} else {
					System.out.printf("%d\t", i);
				}

			}

		}
	}

}
