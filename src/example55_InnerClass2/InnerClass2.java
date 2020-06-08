package example55_InnerClass2;

//匿名內部類別的範例2:宣告參考名稱bird，匿名類別也重新定義speak()，並且直接在匿名類別呼叫speak()，但這是有用到繼承的概念。
/*結語:匿名類別通常適用在程式不會重複執行，只會做一次，而它不用再做一個類別，可直接在主程式定義一個匿名類別和method，直接使用
              簡單說它和一般類別一樣，只是它沒名字。常見的如new Thread(new Runnable(){...}).start() ，寫Android 的 Button。*/

//先宣告一個抽象類別Animal,裡面有抽象方法speak
abstract class Animal {
	abstract Animal speak();
}

// 有一個貓類別繼承Animal,然後必須實作Animal的speak方法
class Cat extends Animal {
	public Animal speak() {
		System.out.println("喵喵!");
		return this;
	}
}

// 有一個狗類別繼承Animal,然後也必須實作Animal的speak方法
class Dog extends Animal {
	public Animal speak() {
		System.out.println("汪汪!");
		return this;
	}
}

public class InnerClass2 {
	// 宣告一個內部類別A,當中有showMe()方法
	static class A {
		int i = 0;

		public String showMe() {
			return "This is A";
		}
	}

	public static void main(String[] args) {
		Animal dog = new Dog().speak();// 汪汪!
		Animal cat = new Cat().speak();// 喵喵!
		// new出一個Animal實體然後覆寫speak()方法
		Animal bird = new Animal() { // 隱式繼承覆蓋
			@Override
			Animal speak() {
				System.out.println("吱吱!");
				return this;
			}
		}.speak();// 吱吱!
	}

}
