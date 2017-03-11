package example11_inheritPractice2;

public class InheritPractice2 {

	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.setAge(10);
		dog.setName("來福");
		System.out.printf("有一隻狗叫%s,牠的年齡是%d歲", dog.getName(), dog.getAge());
		dog.sleep(); // 因為繼承動物父類別,所以擁有父類別的方法
		dog.skill();// 自己擁有的方法
		dog.eat();// 子類別和父類別名稱相同時,會採覆寫機制,子類別的方法會覆寫父類別的方法,而顯示子類別
		System.out.println("===========================================");
		Cat cat = new Cat();
		cat.setAge(8);
		cat.setName("喵喵");
		System.out.printf("有一隻貓叫%s,牠的年齡是%d歲,", cat.getName(), cat.getAge());
		cat.sleep();// 因為繼承動物父類別,所以擁有父類別的方法
		cat.playGame();//// 自己擁有的方法
		System.out.println("===========================================");
		Animal tiger1 = new Tiger();// 多型的宣告 Animal擁有的
									// tiger都有,但一旦子類別和父類別都有的方法,會由子類別覆寫方法
		tiger1.move();
		Cat tiger2 = new Tiger();// 多型的宣告 cat擁有的
									// tiger都有,但一旦子類別和父類別都有的方法,會由子類別覆寫方法
		tiger2.move();
	}

}

////////////////////////////////////////////////////////////////////////////////
class Animal {
	private String name; // 利用private封裝了name值,一定要利用SET GET方法去設定或取得值
	private int age; // 利用private封裝了age值,一定要利用SET GET方法去設定或取得值
	// 建構子的名字會和類別名稱一樣

	Animal() {
	}// 不帶有參數的建構式,可有可無,沒寫系統會預設寫入無參數的建構式,但一有寫,設計師就一定要再加有參數的建構子

	Animal(String name, int age) { // 帶有參數的建構式,利用這個建構式設定初始值
		this.name = name;
		this.age = age;
	}

	public void setName(String name) { // 利用set 方法 設定值
		this.name = name;
	}

	public String getName() { // 利用get方法 取得值
		return name;
	}

	public void setAge(int age) { // 利用set 方法 設定值
		this.age = age;
	}

	public int getAge() { // 利用get方法 取得值
		return age;
	}

	void sleep() {
		System.out.print("牠會睡覺");
	}

	void eat() {
		System.out.printf("只要是食物動物都吃");
	}

	void move() {
		System.out.printf("跑");
	}
}
////////////////////////////////////////////////////////////////////////////////

class Dog extends Animal {
	Dog() {
	} // 不帶有參數的建構式,可有可無,沒寫系統會預設寫入無參數的建構式,但一有寫,設計師就一定要再加有參數的建構子

	Dog(String name, int age) {// 帶有參數的建構式,利用這個建構式設定初始值
		super(name, age);
	}

	void skill() {
		System.out.printf("牠會看門");
	}

	void eat() {
		System.out.println("牠喜歡吃肉");// 會覆寫父類別的方法,因和父類別的方法同名
	}

}

////////////////////////////////////////////////////////////////////////////////
class Cat extends Animal {
	public Cat() {
	}// 不帶有參數的建構式,可有可無,沒寫系統會預設寫入無參數的建構式,但一有寫,設計師就一定要再加有參數的建構子

	public Cat(String name, int age, String color) {// 帶有參數的建構式,利用這個建構式設定初始值
		super(name, age);
	}

	public void playGame() {
		System.out.println("玩繡球");
	}

	void move() {
		System.out.printf("跳");
	}
}

////////////////////////////////////////////////////////////////////////////////
class Tiger extends Cat {
	void skill() {
		System.out.printf("牠會狩獵");
	}

}