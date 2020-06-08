package example56_url_money_exchange;

import java.lang.Object;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import org.omg.IOP.Encoding;
//下面會用到ByteArrayBuffer和EncodingUtils這兩個類別物件在我們jar檔中找不到,所以要自行下載套件(到以下網址下載httpcore-osgi jar檔->下載完畢->專案右鍵->Build Path->Configure Build Path->Libraries->Add External jars->添加下載的jar檔)
//http://www.java2s.com/Code/Jar/h/Downloadhttpcoreosgi43beta1jar.htm
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.EncodingUtils;

public class Url_Money_Exchange {
	// 宣告一字串陣列放幣名
	static String s[] = { "美金", "港幣", "英镑", "澳幣", "加拿大幣", "新加坡幣", "瑞士法朗", "日圓", "南非幣", "瑞典幣", "紐圓", "泰幣", "菲國比索", "印尼幣",
			"歐元", "韓元", "越南幣", "馬來幣", "人民幣" };
	// 宣告四個ArrayList集合(利用泛型把傳入的物件先認定為字串物件)存放現金買進/現金買出/即期買入/即期賣出
	static List<String> buy_cash = new ArrayList<String>();// 現金買進
	static List<String> sell_cash = new ArrayList<String>();// 現金買出
	static List<String> buy_curren_rate = new ArrayList<String>();// 即期買入
	static List<String> sell_current_rate = new ArrayList<String>();// 即期賣出
	static String urlData = null;

	public static void main(String[] args) {
		// 宣告一字串放網址
		String string_url = "http://rate.bot.com.tw/xrt?Lang=zh-TW";
		try {
			// 產生一個URL類別物件,利用它的有字串的建構子用來定址
			URL url = new URL(string_url);
			// URL有一個openConnection()用來建立連線
			URLConnection urlconnection = url.openConnection();
			// 取得輸入串流
			InputStream in = urlconnection.getInputStream();
			// 把串流流進BufferedInputStream
			BufferedInputStream bufferedInputStream = new BufferedInputStream(in);
			// 宣告一個ByteArrayBuffer放入網頁的資料串流
			ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(bufferedInputStream.available());
			int data = 0;
			while ((data = bufferedInputStream.read()) != -1) {
				byteArrayBuffer.append((byte) data);
			}
			// 把網頁資料轉成編碼UTF-8的字串(因為要利用字串的特性去找尋我們要的資料)
			urlData = EncodingUtils.getString(byteArrayBuffer.toByteArray(), "UTF-8");
		} catch (Exception e) {
			System.out.println(e);
		}
		// 把字串丟進 Parser方法,取得現金買進/現金買出/即期買入/即期賣出
		Parser(urlData);

		// 輸出
		System.out.println("幣別\t現金本行買入\t現金本行賣出\t即期本行買入\t即期本行賣出");
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i] + "\t" + buy_cash.get(i) + "\t" + sell_cash.get(i) + "\t" + buy_curren_rate.get(i)
					+ "\t" + sell_current_rate.get(i));
		}
	}

	// 傳進來的網頁字串用indexOf比對我們要的資料的位置在哪,再利用substring得到我們要的字串資料
	static void Parser(String urlData) {
		String temp = null;
		int start = 0;
		int end = 0;
		int count = 0;
		do {
			// 1.現金買入
			// indexOf中的html碼要到該網頁去擷取這段html,知道我們要的頭和尾
			start = urlData.indexOf("<td data-table=\"本行現金買入\" class=\"rate-content-cash text-right print_hide\">",
					end + 1);
			end = urlData.indexOf("</td>", start + 1);
			temp = urlData.substring(start + 72, end);
			//如果無資料
			if (!temp.equals("-")) {
				buy_cash.add(temp);
			} else {
				buy_cash.add("無資料");
			}
			// 2.現金賣出
			start = urlData.indexOf("<td data-table=\"本行現金賣出\" class=\"rate-content-cash text-right print_hide\">",
					end + 1);
			end = urlData.indexOf("</td>", start + 1);
			temp = urlData.substring(start + 72, end);
			if (!temp.equals("-")) {
				sell_cash.add(temp);
			} else {
				sell_cash.add("無資料");
			}
			// 3.即期買入
			start = urlData.indexOf(
					"<td data-table=\"本行即期買入\" class=\"rate-content-sight text-right print_hide\" data-hide=\"phone\">",
					end + 1);
			end = urlData.indexOf("</td>", start + 1);
			temp = urlData.substring(start + 91, end);
			if (!temp.equals("-")) {
				buy_curren_rate.add(temp);
			} else {
				buy_curren_rate.add("無資料");
			}
			//4. 即期賣出
			start = urlData.indexOf(
					"<td data-table=\"本行即期賣出\" class=\"rate-content-sight text-right print_hide\" data-hide=\"phone\">",
					end + 1);
			end = urlData.indexOf("</td>", start + 1);
			temp = urlData.substring(start + 91, end);
			if (!temp.equals("-")) {
				sell_current_rate.add(temp);
			} else {
				sell_current_rate.add("無資料");
			}
			count++;
		} while (count < s.length);

	}

}
