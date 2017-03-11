package example12_interfacePractice1;

public class InterfacePractice1 {

	public static void main(String[] args) {
		Human human = new Human("Tony"); // 介面要new出來一定要把介面中所有方法實作才可new出來
		human.swim();
		String s = human.skll;
		System.out.printf(",而他會%s", s);
	}

	////////////////////////////////////////////////////////////////////////////////////
	public static class Human implements swimmer { // 介面的抽象方法已被我實作,所以類別不用加abstract,但要加static
		private String name;

		public Human(String name) { // 人類類別的建構子,利用建構子帶入人類名字的參數
			this.name = name;
		}

		public String getName() {
			return name;
		}

		// 1.public abstract void swim(); 沒實作就要抽象
		// 2.不然就實作
		public void swim() {
			System.out.printf("%s會游泳", name);
		} // 實作方法採覆寫機制而且最好為public,因為覆寫方法的權限不可小於原方法
	}

	////////////////////////////////////////////////////////////////////////////////////
	public interface swimmer { // 介面要在方法外
		public static final String skll = "freestyle";// 自動變成public static final
														// String
														// skll="freestyle";

		void swim();// 程式預設 public abstract void swim();
	}
}