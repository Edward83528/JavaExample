package example57_serialization1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//序列化過程簡單說就是為了保存在內存中的各種對象的狀態（也就是實例變量，不只是類別本身），並且可以把保存的對象狀態再讀出來
//什麽情況下需要序列化 :1.當你想把的內存中的對象狀態保存到一個文件中或者數據庫中時候2.當你想用套接字在網絡上傳送對象的時候3.當你想通過RMI傳輸對象的時候
//當一個父類實現序列化，子類自動實現序列化，不需要實作Serializable
//在Java這樣支援物件導向的程式中撰寫程式，很多資料都是以物件的方式存在，在程式運行過後，您會希望將這些資料加以儲存，以供下次執行程式時使用，這時您可以使用ObjectInputStream、ObjectOutputStream 來進行這項工作...
public class Serialization1 {

	public static void main(String[] args) {
		// 在沒有序列化前，每個保存在堆（Heap）中的對象都有相應的狀態（state），即實例變量（instance ariable）
		Employee e = new Employee();
		e.name = "harry";
		e.address = "Taiwan";
		e.phone = 25372480;
		e.number = 51;
		// 序列化之後，Employee中的實例變量的值都被保存到Employee.ser文件
		// 這樣以後又可以把它 從文件中讀出來，重新在堆中創建原來的對象(反序列化)
		try {
			FileOutputStream fileOut = new FileOutputStream("employee.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(e);
			out.close();
			fileOut.close();
			System.out.println("序列化成功");
		} catch (IOException i) {
			i.printStackTrace();
		}
		System.out.println("=========");
		try {
			FileInputStream fileIn = new FileInputStream("employee.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			e = (Employee) in.readObject();
			in.close();
			fileIn.close();
		} catch (Exception i) {
			System.out.print(i.toString());
		}
		System.out.println("反序列化");// 並不會出現Employee的建構子,因為序列化只保存該物件的狀態並不保存方法/建構子
		System.out.println("Name: " + e.name);// Name: harry
		System.out.println("Address: " + e.address);// Address: Taiwan
		System.out.println("phone: " + e.phone);// phone:0(因為phone加了transient不可序列化，這個值是不會被發送到輸出流。反序列化的Employee對象的phone為0)
		System.out.println("Number: " + e.number);// Number: 51

	}

}

// 一類被序列化成功，兩個條件必須滿足：
// 1.這個類必須實現java.io.Serializable
// 2.所有在類中的字段必須是可序列化的。如果一個字段不是可序列化的，必須注明transient
class boss {
	boss() {
		System.out.println("這是boss的建構子");
	}
}

class Employee extends boss implements Serializable {
	public String name;
	public String address;
	public transient int phone;
	public int number;

	Employee() {
		System.out.println("這是Employee的建構子");
	}
}
