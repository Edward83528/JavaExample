package example46_thread4;

/*
Program:一群程式碼的集合,用以解決特定的問題。以物件導向的觀念來類比,相當於Class。
Process:由Program所產生的執行個體,一個Program可以同時執行多次,產生多個Process。以物件導向的觀念來類比,相當於Object。每一個Process又由以下兩個東西組成
1.一個Memory Space。相當於Object的variable,不同Process的Memory Space也不同,彼此看不到對方的Memory Space。
2.一個以上的Thread。Thread代表從某個起始點開始(例如main),到目前為止所有函數的呼叫路徑,以及這些呼叫路徑上所用到的區域變數。
當然程式的執行狀態,除了紀錄在主記憶體外,CPU內部的暫存器(如Program Counter, Stack Pointer, Program Status Word等)也需要一起紀錄。所以Thread又由下面兩項組成
1.Stack:紀錄函數呼叫路徑,以及這些函數所用到的區域變數
2.目前CPU的狀態
一:一個Process可以有多個Thread。
二:同一個Process內的Thread使用相同的Memory Space,但這些Thread各自擁有其Stack。
換句話說,Thread能透過reference存取到相同的Object,但是local variable卻是各自獨立的。
作業系統會根據Thread的優先權以及已經用掉的CPU時間,在不同的Thread作切換,以讓各個Thread都有機會執行。
 */
public class thread4 extends Thread {

	public void run() {
		System.out.println("Here is the starting point of Thread.");
		for (;;) { // infinite loop to print message
			System.out.println("使用者創造的執行緒");
			yield();// 先讓給別的Thread執行,所以這個程式的執行結果都是主執行緒的無窮迴圈
		}
	}

	public static void main(String[] args) {
		thread4 t = new thread4();
		t.start();
		for (;;) {
			System.out.println("主執行緒");

		}

	}

}
