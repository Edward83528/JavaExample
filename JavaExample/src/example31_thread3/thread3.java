package example31_thread3;

public class thread3 {

	public static void main(String[] args) {
		Thread people = new Thread(new People());
		people.start();
		// 讓runnable的執行緒醒過來(running)
		people.interrupt();
	}

}

class People implements Runnable {
	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {
				// 執行緒進入runnable狀態
				Thread.sleep(1000);
				System.out.printf("我睡了%d分鐘\n", i);

			} catch (InterruptedException e) {
				System.out.println("我被吵醒了");
			}
		}
		System.out.printf("上課鐘聲響了 ");
	}
}
