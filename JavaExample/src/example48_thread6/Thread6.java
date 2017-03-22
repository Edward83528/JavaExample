package example48_thread6;

//sleep(int time):休息time mini second(1/1000秒)
public class Thread6 extends Thread {
	String name;

	public Thread6(String name) {
		this.name = name;
	}

	// 覆寫 Thread的 run()
	public void run() { // 覆寫 Thread的 run()
		try {
			sleep(1000);
			for (int j = 1; j < 6; j++) {
				System.out.println(name + "睡覺" + j + "秒");
			}
		} catch (InterruptedException e) {
		}

	}

	public static void main(String[] argv) {
		Thread6 t1 = new Thread6("T1"); // 產生Thread物件
		Thread6 t2 = new Thread6("T2"); // 產生Thread物件
		t1.start(); // 開始執行t1.run()
		t2.start();
	}
}