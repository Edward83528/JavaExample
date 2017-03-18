package example36_Taiwan_Roc_Id;

public class Taiwan_Roc_Id {

	public static void main(String[] args) {
		TwId t = new TwId();
		System.out.println(t.getId());
	}
}

class TwId {
	// 宣告身份證字號變數
	private String Id;
	static String area1 = "ABCDEFGHJKLMNPQRSTUVXYWZIO";

	// 利用TwId帶參數字串的建構子存入Id
	public TwId(String id) {
		Id = id;
	}

	// 讀出Id用get
	public String getId() {
		return Id;
	}

	TwId() {
		this((int) (Math.random() * 26));
	}

	TwId(boolean gender) {
		this(gender, (int) (Math.random() * 26));
	}

	TwId(int area) {
		this((int) (Math.random() * 2) == 0 ? true : false, area);
	}

	TwId(boolean gender, int area) {
		String temp = area1.substring(area, area + 1);
		temp += gender ? "2" : "1";
		temp += (int) (Math.random() * 10);
		temp += (int) (Math.random() * 10);
		temp += (int) (Math.random() * 10);
		temp += (int) (Math.random() * 10);
		temp += (int) (Math.random() * 10);
		temp += (int) (Math.random() * 10);
		temp += (int) (Math.random() * 10);
		for (int i = 0; i < 10; i++) {
			if (ischeck(temp + i)) {
				Id = temp + i;
				break;
			}

		}
	}

	boolean ischeck(String s) {
		boolean result = false;
		if (s.matches("^[A-Z][12][0-9]{8}$")) {
			int first = area1.indexOf(s.charAt(0)) + 10;// A的轉換為11
			int sum = (first / 10) * 1 + (first % 10) * 9 + (Integer.parseInt(s.substring(1, 2))) * 8
					+ (Integer.parseInt(s.substring(2, 3))) * 7 + (Integer.parseInt(s.substring(3, 4))) * 6
					+ (Integer.parseInt(s.substring(4, 5))) * 5 + (Integer.parseInt(s.substring(5, 6))) * 4
					+ (Integer.parseInt(s.substring(6, 7))) * 3 + (Integer.parseInt(s.substring(7, 8))) * 2
					+ (Integer.parseInt(s.substring(8, 9))) * 1 + (Integer.parseInt(s.substring(9, 10))) * 1;
			if (sum % 10 == 0) {
				result = true;
			}
		}
		return result;
	}

}
