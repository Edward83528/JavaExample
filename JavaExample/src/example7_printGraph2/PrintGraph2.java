package example7_printGraph2;

import java.util.Scanner;
/*砞璸祘Α块nず甧(n=5 羭ㄒ):
         1
        21
       321
      4321
     54321
 */

public class PrintGraph2 {

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

			System.out.println();// 传︽

		}

	}

}
