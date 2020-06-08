package example24_fileInputStream1;

import java.io.*;

/*
 * java.io.FileInputStream 是 InputStream 的子類
 * FileInputStream 與從指定的檔案中讀取資料至目的地有關
 *  java.io.FileOutputStream 是 OutputStream 的子類
 *  FileOnputStream 主要與從來源地寫入資料至指定的檔案中有關。
 */
/*
 * FileInputStream 可以使用 read() 方法一次讀入一個位元組，並以 int 型態傳回
 * 也可使用 read() 方法時讀入至一個 byte 陣列(緩衝區)
 */
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
