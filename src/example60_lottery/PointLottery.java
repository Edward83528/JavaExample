package example60_lottery;

import java.util.ArrayList;
import java.util.List;

public class PointLottery {

	public static void main(String[] agrs) {
		// 總點數
		int PointTotal = 20000;

		List<PointMatching> prizes = new ArrayList<PointMatching>();

		// 新增獎品
		PointMatching p1 = new PointMatching();
		p1.setId((long) 0);
		p1.setSingleAmount((long) 5);
		p1.setShare(1999);
		p1.setShare_given(0);
		p1.setShare_over(1999);
		prizes.add(p1);

		PointMatching p2 = new PointMatching();
		p2.setId((long) 1);
		p2.setSingleAmount((long) 10);
		p2.setShare(998);
		p2.setShare_given(0);
		p2.setShare_over(998);
		prizes.add(p2);

		// 補上如果新增點數總額不足總點數就都歸為1點或0點相當於"偽獎品"
		long pointTemp = 0;
		for (int j = 0; j < prizes.size(); j++) {
			PointMatching item = (PointMatching) prizes.get(j);
			pointTemp += (item.getSingleAmount() * item.getShare());
		}
		PointMatching p3 = new PointMatching();
		p3.setId((long) prizes.size());
		p3.setSingleAmount((long) 1);
		long share = ((PointTotal - pointTemp) / 1);
		p3.setShare((int) share);
		p3.setShare_given(0);
		p3.setShare_over((int) share);
		prizes.add(p3);

		PointLottery lottery = new PointLottery();
		int[] result = new int[prizes.size()];
		System.out.println("刮刮樂開始");
		for (int i = 0; i < 100000; i++)// 刮i次
		{
			int selected = lottery.getPrizeIndex(prizes);
			// 如果獎品都沒了,就跳出
			if (selected == 99999) {
				break;
			}
			System.out.println("第" + i + "次得：" + prizes.get(selected).getSingleAmount() + "點");
			// ----------------
			// 被抽走的份數
			int share_given = prizes.get(selected).getShare_given() + 1;
			// 剩餘份數
			int share_over = prizes.get(selected).getShare_over() - 1;
			// ----------------
			prizes.get(selected).setShare_given(share_given);
			prizes.get(selected).setShare_over(share_over);
			// System.out.println("被抽走的份數：" + share_given);
			// System.out.println("剩餘份數：" + share_over);
			result[selected]++;
			System.out.println("--------------------------------");
		}
		System.out.println("抽獎結束");
		System.out.println("每種獎品抽到的數量為：");
		System.out.println("5點：" + result[0]);
		System.out.println("10點：" + result[1]);
		System.out.println("1點：" + result[2]);
		System.out.println("1點份數：" + (int) share);
	}

	/**
	 * 根據Math.random()產生一個double型的隨機數，判斷每個獎品出現的概率
	 * 
	 * @param prizes
	 * @return random：獎品列表prizes中的序列（prizes中的第random個就是抽中的獎品）
	 */
	public int getPrizeIndex(List<PointMatching> prizes) {
		int random = -1;
		try {
			do {
				// 計算總份數
				double sumShare = 0;
				for (PointMatching p : prizes) {
					sumShare += p.getShare_over();// 累加剩餘份數
				}
				// 如果所有獎品都抽完了,直接跳出
				if (sumShare <= 0.0) {
					random = 99999;
					break;
				}
				// 產生隨機數
				double randomNumber;
				randomNumber = Math.random(); // 產生 0（包括）~ 1（不包括）

				// 為了便於計算和理解，設定每種獎品的權重分別為1，2，3，4，所以被抽到的概率分別為0.1，0.2，0.3，0.4（本次活動中獎概率為100%）。
				// 生成一個隨機數randomNumber，然後根據隨機數所處區域判斷獎品

				// 根據隨機數在所有獎品分佈的區域並確定所抽獎品
				double d1 = 0;
				double d2 = 0;
				for (int i = 0; i < prizes.size(); i++) {

					d2 += Double.parseDouble(String.valueOf(prizes.get(i).getShare_over())) / sumShare;
					if (i == 0) {
						d1 = 0;
					} else {
						d1 += Double.parseDouble(String.valueOf(prizes.get(i - 1).getShare_over())) / sumShare;
					}
					// d1~d2區間
					if (randomNumber >= d1 && randomNumber <= d2) {

						if (prizes.get(i).getShare_over() != 0) {
							// 如果此獎品的剩餘數量不為0，則即抽中該獎,反之為0重新抽取獎品，直到抽到其他獎品位置
							// 還有獎品
							random = i;
							break;
						}
					}
				}

			} while (random == -1);

		} catch (Exception e) {
			System.out.println("刮刮樂出錯，出錯原因：" + e.getMessage());
		}
		return random;
	}

}
