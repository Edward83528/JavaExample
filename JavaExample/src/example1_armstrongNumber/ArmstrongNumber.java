package example1_armstrongNumber;

public class ArmstrongNumber {

	public static void main(String[] args) {
		System.out.println("�C�X�T��ƪ����i������:");
		for (int i = 100; i <= 999; i++) {
			int a = i / 100;
			int b = (i % 100) / 10;
			int c = (i % 100) % 10;
			if (a * a * a + b * b * b + c * c * c == i) {
				System.out.println(i);
			}
		}

	}
}
