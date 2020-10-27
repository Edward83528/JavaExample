package example62_uuid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/***
 * 生成8位元的uuid
 * 
 * 短8位UUID思想其實借鑑微博短域名的生成方式，但是其重複概率過高，而且每次生成4個，需要隨即選取一個。
 * 本演算法利用62個可列印字元，通過隨機生成32位UUID，由於UUID都為十六進位制，所以將UUID分成8組，每4個為一組，然後通過模62操作，結果作為索引取出字元，這樣重複率大大降低。
 */
public class shortUuid {

	public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
			"o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8",
			"9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
			"U", "V", "W", "X", "Y", "Z" };

	public static void main(String[] args) {

		List<String> uuid_list = new ArrayList<String>();
		for (int i = 0; i < 10000000; i++) {
			String shortUuid = generateShortUuid();
			uuid_list.add(shortUuid);
		}

		System.out.println("看一筆:" + uuid_list.get(10));
		System.out.println("跑1千萬筆的list_size" + uuid_list.size());
		Set<String> uuid_set = new HashSet<String>(uuid_list);
		System.out.println("跑1千萬筆的set_size" + uuid_set.size());

	}

	public static String generateShortUuid() {
		StringBuffer shortBuffer = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replace("-", ""); // 7f98a6f7-7e2a-4c56-a75a-f99b4778b1ad>7f98a6f77e2a4c56a75af99b4778b1ad
		for (int i = 0; i < 8; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(chars[x % 0x3E]);
		}
		return shortBuffer.toString();

	}

}
