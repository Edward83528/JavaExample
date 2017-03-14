package example28_thread1;

public class Thread1 {
	/*
	 * 由執行結果可見,排程器讓T1 T2交互執行cpu時間,當一個執行緒執行時間屆滿,即使該實作程式還沒執行完畢 ,仍必須回到runnable
	 * pool中再與其他執行緒排程,等到下次被排程器選到,再執行上次未完成的地方 如此達到分時多工(cpu時間給予多少不一定,所以T1
	 * T2交接的位置都不一樣)
	 */
	public static void main(String[] args) {
		test T1 = new test();
		test T2 = new test();
		T1.setName("T1");// 沒設系統預設會Thread-0:
		T2.setName("T2");
		// System.out.printf("可用執行緒:%d條\n",Thread.activeCount());//可用執行緒:1條
		T1.start();// 將執行緒丟入runnable pool中等待被run方法呼叫執行
		T2.start();
		// Thread.activeCount()計算出系統中可用執行緒數量
		System.out.printf("可用執行緒:%d條\n", Thread.activeCount());// 可用執行緒:3條(main+T1+T2)
	}

}

// 將 test類別繼承執行緒
class test extends Thread {
	// 因為執行緒中也有run()方法,所以我們將覆寫父類別的方法
	public void run() {
		for (int i = 1; i <= 100; i++) {
			// java.lang.Thread.currentThread() 方法返回一個引用到當前正在執行的線程對象。
			// getName()取得名稱
			String name = Thread.currentThread().getName();
			System.out.printf("%s:%d\n", name, i);
		}
	}
}
