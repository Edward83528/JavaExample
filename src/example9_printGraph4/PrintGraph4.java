package example9_printGraph4;

import java.util.Scanner;

/*�]�p�@�{���A��Jn�A�L�X�H�U���e(�H�U�Hn=5 �|��):
  12345
  1234
  123
  12
  1
 */
public class PrintGraph4 {

	public static void main(String[] args) {
		System.out.println("��J�@�����n(n�N��T���Φ�n�h):");
		Scanner a = new Scanner(System.in);
		int input = a.nextInt();
		for (int n = 1; n <= input; n++)// �����
		{

			for (int y = 1; y <= input - n + 1; y++)// �L�X�Ʀr
			{
				System.out.print(y);
			}

			System.out.println();// ����

		}

	}
}
