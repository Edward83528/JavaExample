package example7_printGraph2;

import java.util.Scanner;
/*�]�p�@�{���A��Jn�A�L�X�H�U���e(�H�U�Hn=5 �|��):
         1
        21
       321
      4321
     54321
 */

public class PrintGraph2 {

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

			System.out.println();// ����

		}

	}

}
