package example25_fileoutputStream1;

import java.io.*;
import java.util.Scanner;

public class FileoutputStream1 {

	public static void main(String[] args) {
		FileOutputStream f = null;
		Scanner input = new Scanner(System.in);
		System.out.println("寫入檔案的資料:");
		String s = input.nextLine();
		// 把字串變成byte陣列
		byte[] data = s.getBytes();
		try {
			/*
			 * 建立FileOutputStream實體並打開a.txt,
			 * FileOutputStream方法中的布林值為true會把值寫進原來檔案內容之後如果是false會清空檔案再寫入
			 */
			f = new FileOutputStream("C:/Users/u0151051/a.txt", true);
			// 寫入檔案
			f.write(data);
		} catch (IOException e) {
			System.out.print(e);
		} finally {

			try {
				f.close();
			} catch (IOException e) {
				System.out.print(e);
			}
		}

	}

}
