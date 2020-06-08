package example47_thread5;

//join():呼叫ThreadA.join()的執行緒會等到ThreadA結束後,才能繼續執行
public class Thread5 extends Thread {
	String name;

	Thread5(String name) {
		this.name = name;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(name);
		}

	}

	public static void main(String[] args) {
		Thread5 t1 = new Thread5("T1");
		Thread5 t2 = new Thread5("T2");
		t1.start();
		t2.start();
		try {
			t1.join();// 等待t1結束才可執行下個執行緒(t2)
			t2.join();//// 等待t2結束才可執行下個執行緒(主執行緒)
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		for (int i = 0; i < 5; i++) {
			System.out.println("主要執行緒");
		}

	}

}
