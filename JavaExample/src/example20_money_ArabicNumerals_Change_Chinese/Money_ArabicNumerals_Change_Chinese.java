package example20_money_ArabicNumerals_Change_Chinese;

import java.util.Scanner;
import java.util.Scanner;

public class Money_ArabicNumerals_Change_Chinese {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("�п�J�A���]�����B:");
		String w = input.nextLine();
		int b = w.length(); // ���Ʀr������,�ت��O�n�P�_���X���

		test(b, w);

	}

	static void test(int a, String v) {
		String S = v;
		String S1[] = new String[a];// �Q�ζǶi�Ӫ�����new�X�r��}�C�s��
		String S2[] = { "��", " �d", "��", "�Q", "��", "�d", "��", "�Q", "�U", "�d", "��", "�Q", "����" };
		for (int i = 0; i < a; i++) {
			switch (S.charAt(i)) { // �Ʀr���r
			case '0':
				S1[i] = "";
				break;
			case '1':
				S1[i] = "�@";
				break;
			case '2':
				S1[i] = "�G";

				break;
			case '3':
				S1[i] = "�T";

				break;
			case '4':
				S1[i] = "�|";

				break;
			case '5':
				S1[i] = "��";

				break;
			case '6':
				S1[i] = "��";

				break;
			case '7':
				S1[i] = "�C";

				break;
			case '8':
				S1[i] = "�K";

				break;
			case '9':
				S1[i] = "�E";

				break;

			}
		}
		for (int x = 0; x < S1.length; x++) {
			if (a == 13) {
				System.out.print(S1[x] + S2[x]);
			} else if (a == 12) {
				System.out.print(S1[x] + S2[x + 1]);
			} else if (a == 11) {
				System.out.print(S1[x] + S2[x + 2]);
			} else if (a == 10) {
				System.out.print(S1[x] + S2[x + 3]);
			} else if (a == 9) {
				System.out.print(S1[x] + S2[x + 4]);
			} else if (a == 8) {
				System.out.print(S1[x] + S2[x + 5]);
			} else if (a == 7) {
				System.out.print(S1[x] + S2[x + 6]);
			} else if (a == 6) {
				System.out.print(S1[x] + S2[x + 7]);
			} else if (a == 5) {
				System.out.print(S1[x] + S2[x + 8]);
			} else if (a == 4) {
				System.out.print(S1[x] + S2[x + 9]);
			} else if (a == 3) {
				System.out.print(S1[x] + S2[x + 10]);
			} else if (a == 2) {
				System.out.print(S1[x] + S2[x + 11]);
			} else {
				System.out.print(S1[x] + S2[x + 12]);
			}
		}
	}
}