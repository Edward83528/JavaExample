package example14_set1;

import java.util.*;

public class Set1 {
	// Set型態是無順序群集（Collection），管理的元素"不會重複"
	// 利用set提供的方法add增加元素,但取出元素要用Iterator走訪器取出或透過toArray()將集合內容轉換成Object[],並透過for迴圈取出
	public static void main(String[] args) {
		HashSet hs = new HashSet();
		hs.add("a");
		hs.add("s");
		hs.add("a");
		hs.add("d");
		hs.add("x");
		// 1. 該集合類別/介面需要有iterator方法(透過實作/繼承java.lang.Iterable而來)
		// 2. 呼叫iterator方法，取得Iterator型態的物件，該物件包含集合內所有的值
		// 3. 使用while迴圈，迴圈的條件式內使用Iterator型態的物件呼叫hasNext()，迴圈會走訪Iterator的所
		// 有元素。在while迴圈區塊內使用next()，每次執行回圈，就將走訪到的元素值取出。迴圈全部執行完畢 後，所有的值即取出完畢。
		// 4.因為List是有序結構並有索引特性，而Set則為無序不重複的特性，兩者所提供的公開存取方法也不相同，為了有一致的方式來逐一取
		// 得物件內部的資料，您可以讓一個Iterator於物件內部進行收集，之後傳回Iterator物件，透過該Iterator來逐一取得物件內部資料。
		Iterator it = hs.iterator();
		while (it.hasNext()) {
			String data = (String) it.next();
			System.out.printf("%s\t", data);
		}

		// =================================================================
		System.out.println("");
		Scanner input = new Scanner(System.in);
		System.out.println("請輸入英文:");
		Set words = toSplitSet(input.nextLine());
		System.out.printf("不重複的單字有%d個:%s %n", words.size(), words);
	}

	/////////////////////////////////////////////////////////////////////////
	static Set toSplitSet(String line) {
		String[] tosplit = line.split("");// 使用String中的split方法，將字串分割成數個token，得到一個回傳的String
											// array。
		return new HashSet(Arrays.asList(tosplit));// Arrays.asList為數組的集合和基於API之間的橋梁。
	}// Hashset 實作set介面
}
/////////////////////////////////////////////////////////////////////////