package example64_maskSensitive;

public final class MaskSensitive {

	public static void main(String[] args) {
		System.out.println(mask("L111023456", 6, 4, '*'));
	}

	/**
	 * 字串遮蔽
	 *
	 * @param text       原始字串
	 * @param start      遮罩起始位置index
	 * @param length     遮罩長度
	 * @param maskSymbol 遮罩符號
	 * @return 遮罩過的字串
	 */
	public static String mask(String text, int start, int length, char maskSymbol) {
		if (text == null || text.isEmpty()) {
			return "";
		}
		if (start < 0) {
			start = 0;
		}
		if (length < 1) {
			return text;
		}

		StringBuilder sb = new StringBuilder();
		char[] cc = text.toCharArray();
		for (int i = 0; i < cc.length; i++) {
			if (i >= start && i < (start + length)) {
				sb.append(maskSymbol);
			} else {
				sb.append(cc[i]);
			}
		}
		return sb.toString();
	}

}
