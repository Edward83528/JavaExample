package example21_electronic_locks;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Electronic_locks {

	public static void main(String[] args) {
	//	try {
			test();
	//	} catch (Exception e) {
		//	System.out.println("�A��J���Ƥ��O�i�Φr��");
	//	}
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
						System.out.println("�K�X���T,���N���}");
						result = false;
						break;
					} else {
						System.out.println("�K�X���~,�Э��s��J");
						continue;
					}
				}
			} else {
				System.out.println("�K�X���׭n����6~20������M�i�Φr����0~9,A~Z,a~z");
				continue;
			}
		}

	}

	static String set() {
		Scanner a = new Scanner(System.in);
		System.out.println("�п�J�A�n�]�w���K�X:");
		String setinput = a.nextLine();
		return setinput;

	}

	static String get() {
		Scanner a = new Scanner(System.in);
		System.out.println("�п�J�����K�X:");
		String getinput = a.nextLine();
		return getinput;
	}

	static boolean decide(String S) {
		char S1[] = { 'a', 's', '1', '2', '3' };
		ArrayList a1 = new ArrayList();
		/*
		 * { 'A', 'B', 'C','D','E', 'F ', 'G ', 'H ', 'I ', 'J ', 'K ', 'L ', 'M
		 * ', 'N ', 'O ', 'P ', 'Q ', 'R', 'S ', 'T ', 'U ', 'V ', 'W ', ' X',
		 * 'Y ', 'Z ', 'a', ' b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
		 * 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', ' v' , 'w', 'x',
		 * 'y', 'z' };
		 */
		for (int w = 0; w <S1.length; w++) {
			if ((S.charAt(S1[w])) != -1) {
				a1.add(S1[w]);
			}
		}
		if(a1.size()==S.length()){
			return true;
		}else{
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