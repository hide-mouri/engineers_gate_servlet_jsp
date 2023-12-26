package common;

public class StringUtil {

	/**
	 * 引数の値がemptyか否かをチェックする。
	 * @param str チェック対象の文字列。
	 * @return 判定結果。true.empty、false.emptyではない。
	 */
	public static boolean isEmpty(String str) {
		if (str == null || str.isEmpty()) {
			return true;
		}
		return false;
	}
}
