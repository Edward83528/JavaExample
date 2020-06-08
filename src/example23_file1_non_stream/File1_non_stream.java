package example23_file1_non_stream;

//使用Fileimport java.io.File;
import java.io.File;
import java.io.IOException;

public class File1_non_stream {

	public static void main(String[] args) {
		// 建構File類別(new File()並不會在實體檔案系統建立只是在記憶體建立一個類別物件的實例)
		File f = new File("C:/Users/u0151051/a.txt");
		System.out.println("檔案是否存在?" + f.exists());// false
		if (!f.exists()) {
			// 用createNewFile()方法建立真實實體檔案,但系統用createNewFile()方法會丟出IO例外
			try {
				System.out.println(f.createNewFile());
			} catch (IOException e) {
				System.out.println(e);
			}

		}
		System.out.println("檔案是否存在?" + f.exists());// true

	}

}
