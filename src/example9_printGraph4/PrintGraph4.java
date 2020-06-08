package example9_printGraph4;

import java.util.Scanner;

/*砞璸祘Α块nず甧(n=5 羭ㄒ):
  12345
  1234
  123
  12
  1
 */
public class PrintGraph4 {

	public static void main(String[] args) {
		System.out.println("块タ俱计n(nàΤn糷):");
		Scanner a = new Scanner(System.in);
		int input = a.nextInt();
		for (int n = 1; n <= input; n++)// 北传︽
		{

			for (int y = 1; y <= input - n + 1; y++)// 计
			{
				System.out.print(y);
			}

			System.out.println();// 传︽

		}

	}
}
