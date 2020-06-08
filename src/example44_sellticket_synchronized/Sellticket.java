
package example44_sellticket_synchronized;

import java.io.IOException;

/*
  當多執行緒存取一共享變數時，會有race condition問題，
亦即變數產生不一致性的同步問題，
JAVA提供synchronized的方法，利用lock來鎖定物件，
使得在同一時間內最多只能予許一個執行緒存取共享變數
 */

public class Sellticket {

	public static void main(String[] args) {
		Sellticket_thread Sellticket = new Sellticket_thread();
		Thread thread1 = new Thread(Sellticket);
		Thread thread2 = new Thread(Sellticket);
		Thread thread3 = new Thread(Sellticket);
		thread1.start();
		thread2.start();
		thread3.start();

	}

}

// 一個多執行緒的程式如果是透過Runnable介面實現的，則表示類別中的屬性將被多個執行緒共用。
class Sellticket_thread implements Runnable {
	private int ticket = 5;

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			// 同步synchronized就是指多個操作在同一個時間段內只能有一個執行緒執行，其他執行緒要等待此執行緒完成之後才可以繼續執行。
			synchronized (this) {

				if (ticket >= 0) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.out.println("賣票失敗");
					}
					System.out.println("票還有" + ticket-- + "張");
				}
			}
		}

	}

}
