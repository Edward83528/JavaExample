package example22_multi_dimensional_arrays;

public class Multi_dimensional_arrays {
	// 以樹狀圖來看
	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3 }, { 4, 5 }, { 6 }, { 7, 8, 9, 1 }, { 2, 3 } };
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.printf("%d\t", a[i][j]);
			}
			System.out.println("");
		}
		System.out.println("---------------------------------------");
		for (int[] v : a) {
			for (int c : v) {
				System.out.printf("%d\t", c);
			}
			System.out.println("");

		}
	}

}
