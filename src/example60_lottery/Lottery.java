package example60_lottery;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Lottery {

	public static void main(String[] agrs) {
		int i = 0;
		Lottery a = new Lottery();
		int[] result = new int[4];
		List<Prize> prizes = new ArrayList<Prize>();

		Prize p1 = new Prize();
		p1.setPrize_name("20點");
		p1.setPrize_weight(1);// 獎品的權重設定成1
		prizes.add(p1);

		Prize p2 = new Prize();
		p2.setPrize_name("15點");
		p2.setPrize_weight(2);// 獎品的權重設定成2
		prizes.add(p2);

		Prize p3 = new Prize();
		p3.setPrize_name("10點");
		p3.setPrize_weight(3);// 獎品的權重設定成3
		prizes.add(p3);

		Prize p4 = new Prize();
		p4.setPrize_name("5點");
		p4.setPrize_weight(4);// 獎品的權重設定成4
		prizes.add(p4);

		System.out.println("抽獎開始");
		for (i = 0; i < 10000; i++)// 列印100個測試概率的準確性
		{
			int selected = a.getPrizeIndex(prizes);
			System.out.println("第" + i + "次抽中的獎品為：" + prizes.get(selected).getPrize_name());
			result[selected]++;
			System.out.println("--------------------------------");
		}
		System.out.println("抽獎結束");
		System.out.println("每種獎品抽到的數量為：");
		System.out.println("一等獎20點：" + result[0]);
		System.out.println("二等獎15點：" + result[1]);
		System.out.println("三等獎10點：" + result[2]);
		System.out.println("四等獎5點：" + result[3]);
	}

	/**
	 * 根據Math.random()產生一個double型的隨機數，判斷每個獎品出現的概率
	 * 
	 * @param prizes
	 * @return random：獎品列表prizes中的序列（prizes中的第random個就是抽中的獎品）
	 */
	public int getPrizeIndex(List<Prize> prizes) {
		DecimalFormat df = new DecimalFormat("######0.00");
		int random = -1;
		try {
			// 計算總權重
			double sumWeight = 0;
			for (Prize p : prizes) {
				sumWeight += p.getPrize_weight();
			}

			// 產生隨機數
			double randomNumber;
			randomNumber = Math.random();

			// 為了便於計算和理解，設定每種獎品的權重分別為1，2，3，4，所以被抽到的概率分別為0.1，0.2，0.3，0.4（本次活動中獎概率為100%）。
			// 生成一個隨機數randomNumber，然後根據隨機數所處區域判斷獎品

			// 根據隨機數在所有獎品分佈的區域並確定所抽獎品
			double d1 = 0;
			double d2 = 0;
			for (int i = 0; i < prizes.size(); i++) {
				d2 += Double.parseDouble(String.valueOf(prizes.get(i).getPrize_weight())) / sumWeight;
				if (i == 0) {
					d1 = 0;
				} else {
					d1 += Double.parseDouble(String.valueOf(prizes.get(i - 1).getPrize_weight())) / sumWeight;
				}
				if (randomNumber >= d1 && randomNumber <= d2) {
					random = i;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("生成抽獎隨機數出錯，出錯原因：" + e.getMessage());
		}
		return random;
	}

}
