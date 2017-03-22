package example49_thread7;

/*
 如果設計者沒有提供保護機制的話,Thread取得和失去CPU控制權的時機是由作業系統來決定。
 也就是說Thread可能在執行任何一個機器指令時,被作業系統取走CPU控制權,並交給另一個Thread。
 由於某些真實世界的動作是不可分割的,例如跨行轉帳X圓由A帳戶到B帳戶,轉帳前後這兩個帳戶的總金額必須相同,但以程式來實作時,卻無法用一個指令就完成
 因此在撰寫多執行緒的程式時,必須特別考慮這種狀況(又稱為race condition)。
 Java的解決辦法是,JVM會在每個物件上擺一把鎖(lock),然後程式設計者可以宣告執行某一段程式(通常是用來存取共同資料結構的程式碼, 又稱為Critical Section)時,
 必須拿到某物件的鎖才行,這個鎖同時間最多只有一個執行緒可以擁有它。
 */
public class Thread7 extends Thread {
	public static int A = 1000;
	public static int B = 0;
	private int amount;

	public Thread7(int x) {
		amount = x;
	}

	public void run() {
		synchronized (this) { // 用synchronized 取得lock,如果別的threadA已取得,則目前這個thread會等到thread A釋放該lock
			if (A >= amount) {
				A = A - amount;
				B = B + amount;
			}
		} // 離開synchronized區塊後,此thread會自動釋放lock
	}

	public static void main(String[] argv) {
		Thread t1 = new Thread7(100);
		Thread t2 = new Thread7(200);
		t1.start();
		t2.start();
		System.out.println("t1有" + A + "元");
		System.out.println("t2有" + B + "元");

	}
}