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

			byte[] buffer = new byte[1];
			System.out.println("顯示檔案內容:");

			// 利用read()將資料讀進buffer陣列中,直到回傳值為-1表示到檔案尾巴就停止

			while (f.read(buffer) != -1) {
				System.out.print((char) buffer[0]);// buffer[]會傳出ASCII碼,所以要轉型
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
