package example54_InnerClass1;

/*
 * 一.java類別有分兩種:1.一般類別2.內部類別
 * 二.內部類別又依所存在的位置分三種:
 * 1.成員式(在class中)
   class ExampleClass{
	class InnerClass(){
		//這就是成員式
	}
}
   2.區域式(在方法中)
   class ExampleClass{
	void method(){
		class InnerClass(){
		//這就是區域式
		}
	}
}
   3.匿名式(在宣告同時)
   class ExampleClass{
	void method(){
		addActionListener(new ActionListener(){
			//這就是匿名式
		});
	}
}
*三.內部類別的使用變數權限:
*1.成員式:所有field/method均可自由使用
*2.區域式:所有field/method均可自由使用,但區域變數必須標記為final才可以使用(1.如果Local和Field有同名變數時，預設會選用距離inner class最近的階層，也就是Local的變數2.如果想要使用Field變數，就需要使用到<className>.this.<fieldName>來選用該field)
*3.匿名式:和區域式用法一樣
*四為什區域式和匿名式的區域變數必須為final:
*1.區域式:內部類別所在的Method回傳後，Method中的變數將會被銷毀,因此在Method中，被Local inner class所用到的變數會被複製一份來使用，此時，如果該變數不是final，則複製的變數就可能因為更改而不同步，造成錯亂,所以要加final
*2.匿名式:在實體化時，會將使用到的區域變數直接複製並且生成為自己的private變數，同樣的，出現拷貝時，就會有同步的問題,所以要加final
 */
/*五:從外部使用內部類別的方法:
五_1使用成員式的方法:
1.一般Member Classes: new <ClassName>().new <InnerClassName>();(意思就是必須先取得<ClassName>的實體，再用其new來取得<InnerClassName>實體)
2.Static Classes: new <ClassName>.<StaticInnerClassName>();(由於Static類別隨時可以取得，因此直接指名取得實體即可)
五_2使用區域式的方法:無直接取用方法，僅可能透過所屬method回傳
*/
//匿名內部類別的範例1:參考名稱a來呼叫showMe() 
public class InnerClass1 {

	static class A {
		int i = 0;

		public String showMe() {
			return "This is X";
		}
	}

	public static void main(String[] args) {
		final String s = "hellow";//// 如果要在內部匿名類別中使用某個方法中的變數，它必須宣告為 final
		A a = new A() {
			public String showMe() { // 匿名類別override showMe方法
				return "tony" + i + s; // 可存取A類別的成員i
			}
		}; // 注意分號別漏掉
		System.out.println(a.showMe());

	}

}
