package example6_printGraph1;

import java.util.Scanner;
/*块nず甧(n=5 羭ㄒ):
      1
     212
    32123
   4321234
  543212345   */

public class PrintGraph1 {

	public static void main(String[] args) {
		System.out.println("块タ俱计n(nàΤn糷):");
		Scanner a = new Scanner(System.in);
		int input = a.nextInt();
		for (int n = 1; n <= input; n++)// 北传︽
		{
			for (int i = input - 1; i >= n; i--)// 北フ
			{
				System.out.print(" ");

			}
			for (int y = n; y >= 1; y--)// 计
			{
				System.out.print(y);
			}
			while (n >= 2) {
				for (int z = 2; z <= n; z++)// 计
				{
					System.out.print(z);
				}
				break;
			}

			System.out.println();// 传︽

		}
	}

}
