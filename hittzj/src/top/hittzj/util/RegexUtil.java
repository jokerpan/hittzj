package top.hittzj.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
	// 验证密码(8到10位数字)
	public static boolean checkPsd(String psd) {
		if (psd == null) {
			return false;
		}
		Pattern pattern = Pattern.compile("^[0-9]{8,10}$");
		Matcher matcher = pattern.matcher(psd);
		return matcher.matches();
	}

	// 验证账号格式(8到10位数字)
	public static boolean checkCount(String count) {
		if (count == null) {
			return false;
		}
		Pattern pattern = Pattern.compile("^[0-9]{8,10}$");
		Matcher matcher = pattern.matcher(count);
		return matcher.matches();
	}

	// 验证昵称
	public static boolean checkNickName(String nickName) {
		if (nickName == null) {
			return false;
		}
		char[] charArray = nickName.toCharArray();
		if (charArray.length > 8 || charArray.length < 1) {
			return false;
		}
		return true;

	}

	// 验证手机
	public static boolean checkPhone(String phone) {
		if (phone == null) {
			return false;
		}
		Pattern pattern = Pattern.compile("^[0-9]{11}$");
		Matcher matcher = pattern.matcher(phone);
		return matcher.matches();
	}

	// 验证密保
	public static boolean checkAnswer(String answer) {
		if (answer == null) {
			return false;
		}
		char[] charArray = answer.toCharArray();
		if (charArray.length > 10 || charArray.length < 1) {
			return false;
		}
		return true;
	}

	public static boolean checkCname_and_money_and_useTime(String context) {
		if (context == null) {
			return false;
		}
		char[] charArray = context.toCharArray();
		if (charArray.length > 15 || charArray.length < 1) {
			return false;
		}
		return true;
	}

	public static boolean checkFlaw_and_location(String context) {
		if (context == null) {
			return false;
		}
		char[] charArray = context.toCharArray();
		if (charArray.length > 40 || charArray.length < 1) {
			return false;
		}
		return true;
	}

	public static boolean checkDesc(String context) {
		if (context == null) {
			return false;
		}
		char[] charArray = context.toCharArray();
		if (charArray.length > 40 || charArray.length < 1) {
			return false;
		}
		return true;
	}

	public static boolean checkQq(String qq) {
		if (qq == null) {
			return false;
		}
		Pattern pattern = Pattern.compile("^[0-9]{8,10}$");
		Matcher matcher = pattern.matcher(qq);
		return matcher.matches();
	}
}
