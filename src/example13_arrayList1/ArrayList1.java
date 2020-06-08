package example13_arrayList1;

import java.util.*; //List套件在java.util裡

public class ArrayList1 {
	// ArrayList是所有集合最像陣列的集合,其實也可說成伸縮自如的陣列
	// 有順序姓,有索引值(可以再加入元素時給定索引值)add(int index ,Object obj),可重覆
	// 利用add get()增加或取出元素,索引值看你要不要加
	// remove(index)移出指定索引值元素
	public static void main(String[] args) {
		List name = new ArrayList(); // 多刑宣告 因為ArrayList實作List
		collectNameTo(name);
		System.out.println("班級名單:");
		printUpperCase(name);

	}

	// 增加元素
	static void collectNameTo(List name) { // 要加Static
		Scanner a = new Scanner(System.in);
		while (true) {
			System.out.println("班級同學名字");
			String whitchname = a.nextLine(); // 輸入同學名字
			if (whitchname.equals("end")) { // 遇到end停止輸入
				break;
			} else {
				name.add(whitchname); // List 提供的add方法,可增加有順序的元素
			}
		}
	}

	// 取出元素
	static void printUpperCase(List name) { // 要加Static
		for (int i = 0; i < name.size(); i++) {
			String name1 = (String) name.get(i); // 用List提供的get方法把物件拿出來,get(int
													// index),因為要轉大寫,所以要先轉型成String類別才有toUpperCase方法
			System.out.printf("%d號:%s \t", i, name1.toUpperCase());
		}
	}

}
