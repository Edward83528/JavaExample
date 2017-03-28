package example52_enum1;

/*
 * 使用列舉型態實現常數設定功能
 * 列舉型態本質上還是個類別
 * 列舉的成員其實就是您定義的列舉型態的一個實例，它們都被預設為 "final"，所以您無法改變常數名稱所設定的值,它們也是 "public" 且 "static" 的成員，所以您可以透過類別名稱直接使用它們
 */
public class Enum1 {

	public static void main(String[] args) {
		// values () 方法可以讓您取得所有的列舉成員實例
		for (Action action : Action.values()) {
			System.out.printf("%s:%s%n", action, action.getAction());
		}
	}

	enum Action {
		left, right, shoot;

		public String getAction() {
			// ordinal() 方法，依列舉順序得到位置索引，預設以 0 開始
			switch (this.ordinal()) {
			case 0:
				return "向左轉";
			case 1:
				return "向右轉";
			case 2:
				return "射擊";
			default:
				return null;
			}
		}

	}
}
