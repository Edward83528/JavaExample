package example16_map1;

import java.util.*;

public class Map1 {
	// 為無順序性且無排序性
	// Map並沒有繼承集合介面,被歸類為集合的一部分,是因Hashtable與HashMap這兩個集合類別實作Map介面
	// Map利用指定的鍵值(key)來決定元素擺放位置,鍵值不可以重覆,但不同的鍵值可以存放重覆的元素內容
	// Map的優點就是可以個別操作key值與元素內容,增加程式實作的彈性
	// 利用put方法放入Map中,利用get("key")取得該元素內容
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("A", "青蛙");
		map.put("1", "狗");
		map.put("4", "tony");
		map.put("100", 200);
		map.put(null, null);// HashMap可以允許null
		System.out.println(map.toString());// 輸出{null=null, A=青蛙, 1=狗,//
											// 100=200,// 4=tony}
		System.out.println(map.get("A"));// 青蛙
		System.out.println(map.get("100"));// 200
		System.out.println(map.get("null"));// null
		System.out.println(map.get("S"));// 沒有該元素輸出null
		map.remove("1");// 移除key=1的元素內容
		System.out.println(map.toString());// 輸出{null=null, A=青蛙, 100=200,//
											// 4=tony}
	}

}
