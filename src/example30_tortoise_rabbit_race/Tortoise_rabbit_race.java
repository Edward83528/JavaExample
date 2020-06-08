package example30_tortoise_rabbit_race;

public class Tortoise_rabbit_race {

	public static void main(String[] args) {
		Thread tortoise = new Thread(new Tortoise());
		Thread rabbit = new Thread(new Rabbit());
		tortoise.start();
		rabbit.start();

	}

}

class Tortoise implements Runnable {
	int step = 1;

	public void run() {
		System.out.println("烏龜開始賽跑");
		while (step <= 10) {
			System.out.printf("烏龜走了%d步\n", step++);
		}
		System.out.println("烏龜抵達終點");

	}

}

class Rabbit implements Runnable {
	int step = 1;

	public void run() {
		boolean flags[] = { true, false };
		System.out.println("兔子開始賽跑");
		while (step <= 10) {
			if (flags[(int) (Math.random() * 10) % 2]) {
				System.out.printf("兔子走了%d步\n", step);
				step += 2;
			} else {
				System.out.printf("兔子睡著了......\n");
			}
		}

		System.out.println("兔子抵達終點");
	}

}
