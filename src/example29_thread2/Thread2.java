package example29_thread2;

public class Thread2 {
	/*
	 * 在一個冬天裡,爸爸準備洗熱水澡,但發現瓦斯桶沒瓦斯了,只好打電話叫瓦斯,等到瓦斯工人送來瓦斯後才開始洗澡
	 */
	public static void main(String[] args) {
		// Runnable介面必須搭配Thread類別才能建立執行緒物件
		Thread father = new Thread(new fatherThread());
		father.start();

	}

}

// 除了繼承Thread實現執行緒也可實作Runnable達到執行緒功能,但用Runnable必須搭配Thread類別才能建立執行緒物件
class fatherThread implements Runnable {
	public void run() {
		System.out.printf("爸爸下班回家\n爸爸準備洗澡\n爸爸發現沒瓦斯\n爸爸打電話叫瓦斯公司送瓦斯\n");
		Thread work = new Thread(new workerThread());
		System.out.printf("爸爸等待瓦斯工人\n");
		work.start();
		// 1.Thread.yield();不適用,worker的執行緒時間會大於father執行緒時間
		// 2.Thread.sleep(6000);不適用,爸爸怎麼知道要等多久
		try {
			// 3.把worker執行緒join進來,所以father執行緒會暫停一直等到worker執行完畢可執行
			work.join();
		} catch (InterruptedException e) {
			System.out.println("爸爸今天不洗熱水澡了");
		}
		System.out.printf("爸爸開始洗澡\n");
		System.out.printf("爸爸洗完澡了\n");

	}
}

class workerThread implements Runnable {
	public void run() {
		System.out.printf("瓦斯工人送瓦斯中\n");
		// 模擬瓦斯工人送瓦斯時間
		for (int i = 1; i <= 5; i++) {
			try {
				// 自身執行緒暫停1分鐘
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				System.out.printf("瓦斯工人送瓦斯中發生意外\n");
			}
			System.out.printf("%d分鐘\t", i);

		}
		System.out.println();
		System.out.printf("瓦斯工人將瓦斯送到家了\n瓦斯工人將瓦斯安裝完畢\n");

	}
}
