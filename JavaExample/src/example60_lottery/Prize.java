package example60_lottery;

public class Prize {
	private int id;// 獎品id
	private String prize_name;// 獎品名稱
	private int prize_amount;// 獎品（剩餘）數量
	private int prize_weight;// 獎品權重

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrize_name() {
		return prize_name;
	}

	public void setPrize_name(String prize_name) {
		this.prize_name = prize_name;
	}

	public int getPrize_amount() {
		return prize_amount;
	}

	public void setPrize_amount(int prize_amount) {
		this.prize_amount = prize_amount;
	}

	public int getPrize_weight() {
		return prize_weight;
	}

	public void setPrize_weight(int prize_weight) {
		this.prize_weight = prize_weight;
	}

}
