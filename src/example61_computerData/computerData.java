package example61_computerData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class computerData {

	public static void main(String[] args) {
		try {

			String pathname = "data.txt"; // 檔案路徑
			File filename = new File(computerData.class.getResource(pathname).getFile());
			InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
			BufferedReader br = new BufferedReader(reader);

			ArrayList<ComputerItem> computers = new ArrayList<ComputerItem>();
			String line = br.readLine();
			do {
				// System.out.println(line);
				String[] values = line.replaceAll("(?:處理器種類:|處理器速度:|螢幕尺寸:|重量:|內建記憶體:)", "").split("-");
				ComputerItem computer = new ComputerItem();
				for (int i = 0; i < values.length; i++) {
					String value = values[i];
					String valueNotChinese = replaceChinese(values[i]);
					if (i == 0) {
						computer.setProcessorType(value);
						System.out.println(value);
					} else if (i == 1) {
						computer.setProcessorSpeed(value);
						System.out.println(value);
					} else if (i == 2) {
						computer.setProcessorSize(Double.parseDouble(valueNotChinese));
						System.out.println(valueNotChinese);
					} else if (i == 3) {
						computer.setWeight(value);
						System.out.println(value);
					} else if (i == 4) {
						computer.setRAM(value);
						System.out.println(value);
					}
				}
				System.out.println("---");
				computers.add(computer);
				line = br.readLine();
			} while (line != null);

			// TODO:資料庫連結存取

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 取代字串中文字 return str
	 */
	public static String replaceChinese(String str) {
		str = str.replaceAll("[(\\u4e00-\\u9fa5)]", "");
		return str;
	}
}