package example32_petShop;

public class PetShop {

	public static void main(String[] args) {
		Shop shop = new Shop(5);
		shop.addPet(new cat("大熊", "棕色", 4));
		shop.addPet(new dog("小白兔", "白色", 1));
		shop.addPet(new cat("老鼠", "灰色", 3));
		shop.addPet(new cat("拉不拉多", "黃色", 3));
		shop.addPet(new cat("狼犬", "灰色", 1));
		shop.printPet();
		System.out.println("以下為搜尋結果");
		System.out.println("=============================================================");
		printSearch(shop.search("灰"));
	}

	static void printSearch(Pet[] p) {
		for (Pet pp : p) {
			System.out.printf("名字:%s\t顏色:%s\t年齡:%d歲\n", pp.getName(), pp.getColor(), pp.getAge());
		}
	}

}

/*
 * 設計一個寵物的介面 1.介面也是類別的一種 2.介面類別在設定完成後就不允許更改,不然就喪失了定義使用界面類別的意義
 * 3.介面有很重要的特徵就是利用它收集多個類別(多重繼承)4.[存取權限]interface 介面名稱+[extends ......]
 * 5.介面的方法不可加{}實作區塊和介面的屬性一定要給初始值 6.實作介面的類別一定要實作介面的所有方法,如果沒全部實作就要在類別前加上abstract
 * 7.介面可實現多重繼承 (介面 extends 介面類別1,介面類別2)
 */
interface Pet {
	int number = 99;// 系統預設會在前面加 public static final int number = 99

	String getName();// 系統預設會在方法前面加public abstract String getName();

	String getColor();

	int getAge();
}

class cat implements Pet {

	private String Name;
	private String Color;
	private int Age;

	// 利用cat帶有參數的建構子來達到set功能
	cat(String Name, String Color, int Age) {
		this.setName(Name);
		this.setColor(Color);
		this.setAge(Age);
	}

	// 以下為封裝set get
	public void setName(String name) {
		Name = name;
	}

	public String getName() {
		return Name;
	}

	public void setColor(String color) {
		Color = color;
	}

	public String getColor() {
		return Color;
	}

	public void setAge(int age) {
		Age = age;
	}

	public int getAge() {
		return Age;
	}
}

class dog implements Pet {
	private String Name;
	private String Color;
	private int Age;

	//// 利用dog帶有參數的建構子來達到set功能
	dog(String Name, String Color, int Age) {
		this.setName(Name);
		this.setColor(Color);
		this.setAge(Age);
	}

	// 以下為封裝set get
	public void setName(String name) {
		Name = name;
	}

	public String getName() {
		return Name;
	}

	public void setColor(String color) {
		Color = color;
	}

	public String getColor() {
		return Color;
	}

	public void setAge(int age) {
		Age = age;
	}

	public int getAge() {
		return Age;
	}
}

class Shop {
	// 宣告一個Pet型別的陣列保存寵物
	private Pet[] pets;

	private int foot;

	// 用shop帶有參數建構子來決定Pet陣列大小
	Shop(int s) {
		if (s > 0) {
			this.pets = new Pet[s];// 開闢陣列空間
		} else {
			this.pets = new Pet[1];// 至少開闢一個空間
		}
	}

	// 增加寵物
	boolean addPet(Pet pets) {
		if (foot < this.pets.length) {
			this.pets[this.foot] = pets;
			this.foot++;
			return true;
		} else {
			return false;
		}
	}

	// 印出寵物店的寵物
	void printPet() {
		for (Pet p : pets) {
			System.out.printf("名字:%s\t顏色:%s\t年齡:%d歲\n", p.getName(), p.getColor(), p.getAge());
		}
	}

	Pet[] search(String s) {
		// 再宣告一個寵物陣列存放搜尋的寵物
		Pet[] pet = null;
		int count = 0;// 計算搜尋的寵物陣列要多少空間
		for (int i = 0; i < this.pets.length; i++) {
			if (this.pets[i] != null) {
				if (this.pets[i].getName().indexOf(s) != -1 || this.pets[i].getColor().indexOf(s) != -1) {
					count++;
				}

			}
		}
		pet = new Pet[count];// 已確定陣列大小new出來
		int f = 0;
		for (int j = 0; j < this.pets.length; j++) {
			if (this.pets[j] != null) {
				if (this.pets[j].getName().indexOf(s) != -1 || this.pets[j].getColor().indexOf(s) != -1) {
					pet[f] = this.pets[j];
					f++;
				}

			}
		}
		return pet;
	}

}
