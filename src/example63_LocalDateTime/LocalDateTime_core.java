package example63_LocalDateTime;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.Chronology;
import java.time.chrono.MinguoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DecimalStyle;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Pattern;

public final class LocalDateTime_core {

	public static void main(String[] args) {
		System.out.println(parse("2020-10-29 00:00:00"));
	}

	public static LocalDateTime transfer(String date, String hour, String minute) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(date, formatter);
		return localDate.atTime(Integer.valueOf(hour), Integer.valueOf(minute));
	}

	public static LocalDateTime parse(String timestamp) {
		String regex = "^\\d{2,3}-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01]) ([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$";
		Pattern p = Pattern.compile(regex);
		if (p.matcher(timestamp).find()) {
			timestamp = convertTWDate(timestamp, "yyy-MM-dd", "yyyy-MM-dd HH:mm:ss");
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return LocalDateTime.parse(timestamp, formatter);
	}

	public static String getChina(LocalDateTime localDateTime) {

		Chronology chrono = MinguoChronology.INSTANCE;
		DateTimeFormatter df = new DateTimeFormatterBuilder().parseLenient().appendPattern("yyy-MM-dd").toFormatter()
				.withChronology(chrono).withDecimalStyle(DecimalStyle.of(Locale.getDefault()));

		return localDateTime.format(df);
	}

	public static String getDate(LocalDateTime localDateTime) {

		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		return localDateTime.format(dateFormatter);
	}

	/**
	 * 比較第一個日期是否大於第二個日期
	 *
	 * @param firstDateTime  第一個日期
	 * @param secondDateTime 第二個日期
	 * @return true-大於;false-不大於
	 */
	public static boolean localDateTimeIsBefore(LocalDateTime firstDateTime, LocalDateTime secondDateTime) {
		return firstDateTime.isBefore(secondDateTime);
	}

	/**
	 * 比較第一個日期是否小於第二個日期
	 *
	 * @param firstDateTime  第一個日期
	 * @param secondDateTime 第二個日期
	 * @return true-小於;false-大於
	 */
	public static boolean localDateTimeIsAfter(LocalDateTime firstDateTime, LocalDateTime secondDateTime) {
		return firstDateTime.isAfter(secondDateTime);
	}

	/**
	 * 比較兩個日期是否相等
	 *
	 * @param firstDateTime  第一個日期
	 * @param secondDateTime 第二個日期
	 * @return true-相等;false-不相等
	 */
	public static boolean localDateTimeIsEqual(LocalDateTime firstDateTime, LocalDateTime secondDateTime) {
		return firstDateTime.isEqual(secondDateTime);
	}

	public static String convertTWDate(String AD, String beforeFormat, String afterFormat) {
		if (AD == null)
			return "";
		SimpleDateFormat df_before = new SimpleDateFormat(beforeFormat);
		SimpleDateFormat df_after = new SimpleDateFormat(afterFormat);
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(df_after.parse(AD));
			if (cal.get(Calendar.YEAR) > 1492)
				cal.add(Calendar.YEAR, -1911);
			else
				cal.add(Calendar.YEAR, +1911);
			return df_after.format(cal.getTime());
		} catch (Exception e) {
			return null;
		}
	}

	private LocalDateTime_core() {
		super();
	}

}
