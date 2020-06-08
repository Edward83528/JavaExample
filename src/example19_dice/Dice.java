package example19_dice;

public class Dice {
	// 有賠率的遊戲
	public static void main(String[] args) {
		
		int[] p = new int[6];
		for (int i = 0; i < 20000; i++) {
			int a = (int) (Math.random() * 9);
			switch (a) {
			case 0:
				p[0]++;
				break;
			case 1:
				p[1]++;
				break;
			case 2:
				p[2]++;
				break;
			case 3:
				p[3]++;
				break;
			case 4:
				p[4]++;
				break;
			case 5:
				p[5]++;
				break;
			case 6:// 將7 8 9點的機率加到3 4 5點的身上,將機率提高
			case 7:
			case 8:
			case 9:
				p[a - 4]++;
				break;

			}

		}
		for (int i = 0; i < p.length; i++) {
			System.out.println((i + 1) + "出現" + p[i] + "次");
		}
	}

}
