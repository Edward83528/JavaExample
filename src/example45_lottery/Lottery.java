package example45_lottery;

public class Lottery {

	public static void main(String[] args) {
		int lotter[] = new int[7];
		int temp;
		boolean k;

		for (int i = 0; i < lotter.length; i++) {
			do {
				k = false;
				temp = (int) (Math.random() * 49) + 1;
				for (int j = 0; j < i; j++) {
					if (temp == lotter[j]) {
						k = true;
						break;
					}

				}

			} while (k);
			lotter[i] = temp;
			System.out.printf("第" + (i + 1) + "個數" + lotter[i] + "\t");
		}
	}

}
