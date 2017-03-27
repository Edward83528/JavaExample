package example51_bufferedInputStream1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/*
    java.io.BufferedInputStream 與 java.io.BufferedOutputStream 
     可以為 InputStream、OutputStream 類的物件增加緩衝區功能(為了效率起見，可以儘量讀取多一點的資料)
  1:BufferedInputStream 的資料成員 是個位元陣列，預設為 2048位 元組，當讀取資料來源時BufferedInputStream 會儘量將 buf填滿
     當您使用 read() 方法時，實際上是先讀取 buf 中的資料，而不是直接對資料來源作讀取，當 buf 中的資料不足時
  BufferedInputStream 才會再操作給定的 InputStream 物件之 read() 方法，從指定的裝置中提取資料。
 */
/*
 *2.BufferedOutputStream 的資料成員 buf 是個位元陣列，預設為 512 個位元組，當使用 write() 方法寫入資料時
 *實際上會先將資料寫至 buf 中，當 buf 已滿時才會操作給定的 OutputStream 物件之 write() 方法
 *將 buf 資料寫至目的地，而不是每次都對目的地作寫入的動作
 */
public class BufferedInputStream1 {

	public static void main(String[] args) {
		byte[] b = new byte[1];
		File f1 = new File("C:/Users/u0151051/a.txt");
		File f2 = new File("C:/Users/u0151051/b.txt");

		try {
			// BufferedInputStream中放的是inputstream,所以要把f1變inputstream
			BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(f1));
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(f2));
			System.out.println("複製檔案：" + f1.length() + "位元組");
			while (bufferedInputStream.read(b) != -1) {
				bufferedOutputStream.write(b);
			}
			// 為了確保緩衝區中的資料一定被寫出至目的地，建議最後執行flush()將緩衝區中的資料全部寫出目的串流中
			bufferedOutputStream.flush();
			// 關閉串流
			bufferedInputStream.close();
			bufferedOutputStream.close();
			System.out.println("複製完成");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
