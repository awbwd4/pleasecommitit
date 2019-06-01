package noobchain;

import java.security.MessageDigest;

public class StringUtil {

	// Sha256 알고리즘으로 디지털 서명 만들기

	public static String applySha256(String input) {

		try {

			MessageDigest digest = MessageDigest.getInstance("SHA-256");

			byte[] hash = digest.digest(input.getBytes("UTF-8"));

			StringBuffer hexString = new StringBuffer();
			// this will contain hash.

			for (int i = 0; i < hash.length; i++) {

				String hex = Integer.toHexString(0xff & hash[i]);

				if (hex.length() == 1) {
					hexString.append(0);
				} else {
					hexString.append(hex);
				}

			}

			return hexString.toString();
			// SHA256 알고리즘을 문자열에 적용하고
			// 발생된 시그니쳐를 문자열로 리턴함.

		} catch (Exception e) {

			throw new RuntimeException(e);

		}

	}

}
