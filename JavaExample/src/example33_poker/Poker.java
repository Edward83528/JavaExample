package example33_poker;

import java.util.Arrays;

public class Poker {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		// 1.洗牌
		int[] poker = new int[52];// 宣告一個大小為52的一維陣列
		int temp;
		boolean b;
		for (int i = 0; i < poker.length; i++) {
			do {
				temp = (int) (Math.random() * 52); // 產生0~52的亂數
				b = false;
				for (int j = 0; j < i; j++) {
					if (temp == poker[j]) { // 假如產生的數重複再產生一次
						b = true;
						break;
					}
				}

			} while (b);
			poker[i] = temp;
		}

		// 2.發牌(四家 每家有13張牌)
		/*
		 * i     0123456 
		 * 第?家     01230123 
		 * 第?張     00001111
		 * 
		 */
		int player[][] = new int[4][13];
		for (int s = 0; s < poker.length; s++) {
			player[s % 4][s / 4] = poker[s];
		}

		// 3.攤牌
		String suits[] = { "黑桃", "梅花", "方塊", "紅心" };
		String vaules[] = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		for (int[] cards : player) {
			// 4.理牌
			Arrays.sort(cards);
			for (int card : cards) {
				System.out.printf(suits[card / 13] + vaules[card % 13] + " ");
			}
			System.out.println();
		}
		System.out.println("耗時:" + (System.currentTimeMillis() - start));
	}

}