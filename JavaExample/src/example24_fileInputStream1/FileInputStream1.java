package example24_fileInputStream1;

import java.io.*;

public class FileInputStream1 {

	public static void main(String[] args) {
		FileInputStream f = null;
		int totalbytes = 0;
		try {
			f = new FileInputStream("C:/Users/u0151051/a.txt");
			totalbytes = f.available();
			System.out.println("顯示可讀取資料的位元組數:");
			System.out.printf("%d\t\n", totalbytes);

			// 宣告byte 陣列當作資料緩衝區

			byte[] buffer = new byte[totalbytes];

			// 利用read()將資料讀進buffer陣列中

			if (f.read(buffer) == totalbytes) {
				String s = new String(buffer);
				System.out.println("顯示檔案內容:");
				System.out.print(s);
			} else {
				System.out.println("資料的位元總數錯誤:");
			}
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			// 關閉檔案
			try {
				f.close();
			} catch (IOException e) {
				System.out.println(e);

			}
		}
	}

}
