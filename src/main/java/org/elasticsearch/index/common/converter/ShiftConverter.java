package org.elasticsearch.index.common.converter;

import java.util.Objects;

import org.elasticsearch.index.common.util.KeyboardUtil;

public class ShiftConverter {

	/**
	 * 토큰을 Shift 키보드 기준으로 상호 변환한다.
	 *
	 * @param token
	 * @return
	 */
	public String convert(String token) {
		StringBuilder sb = new StringBuilder();
		// 문자열을 한글자씩 잘라서 처리한다.
		String word = token.trim();
		for (int index = 0; index < word.length(); index++) {
			char init = word.charAt(index);
			Character convertedInit = KeyboardUtil.KEYBOARD_KEY_SHIFT_MAPPER.get(init);
			if (Objects.nonNull(convertedInit)) {
				sb.append(convertedInit);
				continue;
			}
			sb.append(init);
		}
		return sb.toString();
	}
}
