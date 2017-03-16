package example35_inheritPractice3_abstractclass;

public class InheritPractice3_abstractclass {

	public static void main(String[] args) {
		Bus bus = new Bus("國光", "藍色", 12, 12);
		System.out.println(bus.show());
		Bicycle bicycle = new Bicycle("捷安特", "黃色", 14, 1000);
		System.out.println(bicycle.show());

	}

}

/*
 * 1.抽象類別是為了讓方法的實作由子類別來決定使其使用更多變化
 * 2.若父類別為抽象類別則其所產的抽象方法都必須由子類別重新實作(採覆寫機制)(如果子類別沒實作父類別的所有抽象方法,那子類別必須加抽象)
 * 3.抽象類別:[存取權限] abstract class 類別名稱+[extends 某類別][implements......]
 * 4.抽象方法:[存取權限] abstract 傳回值 方法名稱(參數列);(以;結尾沒實作區塊)
 * 5.抽象類別不可以直接new出來(除非透過匿名類別的技巧) 6.抽象類別中不一定要有抽象方法
 */
abstract class car {
	String name;
	String color;
	int power;

	// 利用car帶有參數的建構式設定參數
	car(String name, String color, int power) {
		this.name = name;
		this.color = color;
		this.power = power;
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public int getPower() {
		return power;
	}

	abstract String show();
}

class Bus extends car {
	private int people;

	// 一定要有bus帶有參數的建構子
	Bus(String name, String color, int power, int people) {
		super(name, color, power);
		this.people = people;
	}

	public void setPeople(int people) {
		people = people;
	}

	@Override
	public java.lang.String getName() {
		return super.getName();
	}

	@Override
	public java.lang.String getColor() {
		return super.getColor();
	}

	@Override
	public int getPower() {
		return super.getPower();
	}

	public int getPeople() {
		return people;
	}

	String show() {
		return "名字:" + super.getName() + "\t" + "顏色:" + super.getColor() + "\t" + "馬力:" + super.getPower() + "匹" + "\t"
				+ "乘客數:" + this.people + "位";
	}
}

class Bicycle extends car {
	private int price;

	Bicycle(String name, String color, int power, int price) {
		super(name, color, power);
		this.price = price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return super.getColor();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public int getPower() {
		// TODO Auto-generated method stub
		return super.getPower();
	}

	String show() {
		return "名字:" + super.getName() + "\t" + "顏色:" + super.getColor() + "\t" + "馬力:" + super.getPower() + "匹" + "\t"
				+ "價錢:" + this.price + "元";
	}

}
