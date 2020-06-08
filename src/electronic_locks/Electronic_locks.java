package electronic_locks;

import java.util.Scanner;

public class Electronic_locks {

	public static void main(String[] args) {
		try {
			test();
		} catch (Exception e) {
			System.out.println("你輸入的數不是整數密碼");
		}
	}

	static void test() {
		Locks locks = new Locks();
		boolean result = true;
		while (result == true) {
			int setinput = set();
			if (setinput >= 1000 && setinput <= 9999) {
				locks.setPassword(setinput);
				while (true) {
					int getinput = get();
					if (getinput == locks.getPassword()) {

						result = false;
						break;
					} else {
						System.out.println("密碼錯誤,請重新輸入");
						continue;
					}
				}
			} else {
				System.out.println("密碼要介於1000~9999之間喔");
				continue;
			}
		}

	}

	static int set() {
		Scanner a = new Scanner(System.in);
		System.out.println("請輸入你要設定的密碼:");
		int setinput = a.nextInt();
		return setinput;

	}

	static int get() {
		Scanner a = new Scanner(System.in);
		System.out.println("請輸入門的密碼:");
		int getinput = a.nextInt();
		return getinput;
	}

}

class Locks {
	private int password;

	public void setPassword(int password) {
		this.password = password;
	}

	public int getPassword() {
		return password;
	}
}