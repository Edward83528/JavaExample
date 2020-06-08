package example15_queue1;

import java.util.*;

public class Queue1 {
	// Queue為先進先出集合
	// 新增/移除元素用 offer() /poll()
	// peek()從柱列的最頭開始,取得該元素內容但不移除,若註列為空回傳null
	public static void main(String[] args) {
		Queue q = new LinkedList();
		q.offer("a"); // 增加元素
		q.offer("b");
		q.offer("c");
		q.offer("d");
		q.poll(); // "移除"最早放進來的元素a並取得a的內容
		System.out.println(q.toString());// 輸出[ b, c, d]
		System.out.println(q.peek());// 複製最頭開始元素的值輸出b,但"不移除","跟poll"很像別搞混
		System.out.println(q.toString());// 輸出[ b, c, d]
		Object o;
		while ((o = q.poll()) != null) { // poll取得最頭元素內容並移除
			String s = (String) o;
			System.out.println(s);// 依序輸出b c d
		}
		System.out.println(q.toString());// 因為前面一除了元素所以柱列中沒值了

	}

}
