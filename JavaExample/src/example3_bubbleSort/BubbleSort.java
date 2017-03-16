package example3_bubbleSort;

public class BubbleSort {

	public static void main(String[] args) {
		int number[] = { 10, 40, 21, 30, 98, 65, 1, 22, 34, 4, 3 };
		for (int i = 0; i < number.length - 1; i++) {
			for (int j = 0; j < number.length - i - 1; j++) {
				if (number[j] > number[j + 1]) {
					int a = number[j + 1];
					number[j + 1] = number[j];
					number[j] = a;
				}
			}
		}
		for (int x = 0; x < number.length - 1; x++) {
			System.out.printf("%d\t", number[x]);
		}
		System.out.printf("\n");
		System.out.println("最大值:" + number[number.length - 1]);
		System.out.println("最小值:" + number[0]);
	}

}
