package example6_printGraph1;

import java.util.Scanner;
/*��Jn�A�L�X�H�U���e(�H�U�Hn=5 �|��):
      1
     212
    32123
   4321234
  543212345   */

public class PrintGraph1 {

	public static void main(String[] args) {
		System.out.println("��J�@�����n(n�N��T���Φ�n�h):");
		Scanner a = new Scanner(System.in);
		int input = a.nextInt();
		for (int n = 1; n <= input; n++)// �����
		{
			for (int i = input - 1; i >= n; i--)// ����L�ť�
			{
				System.out.print(" ");

			}
			for (int y = n; y >= 1; y--)// �L�X�Ʀr
			{
				System.out.print(y);
			}
			while (n >= 2) {
				for (int z = 2; z <= n; z++)// �L�X�Ʀr
				{
					System.out.print(z);
				}
				break;
			}

			System.out.println();// ����

		}
	}

}
