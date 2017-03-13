package example21_electronic_locks;

import java.util.*;

public class Electronic_locks {

	public static void main(String[] args) {
		try {
			test();
		} catch (Exception e) {
			System.out.println("你輸入的數不是可用字元");
		}
	}

	static void test() {
		Locks locks = new Locks();
		boolean result = true;
		while (result == true) {
			String setinput = set();
			if (setinput.length() >= 6 && setinput.length() <= 20 && decide(setinput)) {
				locks.setPassword(setinput);
				while (true) {
					String getinput = get();
					if (getinput.equals(locks.getPassword())) {
						System.out.println("密碼正確,門將打開");
						result = false;
						break;
					} else {
						System.out.println("密碼錯誤,請重新輸入");
						continue;
					}
				}
			} else {
				System.out.println("密碼長度要介於6~20之間喔和可用字元為a-z, A-Z, 0-9, 或$_*%?^");
				continue;
			}
		}

	}

	static String set() {
		Scanner a = new Scanner(System.in);
		System.out.println("請輸入你要設定的密碼:");
		String setinput = a.nextLine();
		return setinput;

	}

	static String get() {
		Scanner a = new Scanner(System.in);
		System.out.println("請輸入門的密碼:");
		String getinput = a.nextLine();
		return getinput;
	}

	static boolean decide(String S) {
		String S1 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789$_*%?^";
		int checkChar = 0;
		for (int w = 0; w < S.length(); w++) {
			if (S1.indexOf(S.charAt(w)) != -1) {
				checkChar++;
			}
		}
		if (checkChar != 0) {
			return true;
		} else {
			return false;
		}
	}
}

class Locks {
	private String password;

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
}