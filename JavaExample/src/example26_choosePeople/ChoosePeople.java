package example26_choosePeople;

public class ChoosePeople {
	// 選人的程式,相當於洗撲克牌或樂透產生
	public static void main(String[] args) {
		// 宣告一個人的陣列位置都已經排好
		int[] people = { 0, 1, 2, 3, 4 };
		boolean s;
		int a;
		for (int i = 0; i < people.length; i++) {
			do {
				s = false;
				a = (int) (Math.random() * 5);// 產生0~4亂數用來選0~4位置的人
				for (int j = 0; j < i; j++) {
					if (a == people[j]) {// 假如選到相同位置就要重新選
						s = true;
						break;
					}
				}
			} while (s);
			people[i] = a;
			System.out.printf("位置%d:%d\t", i + 1, people[i]);
		}

	}
}