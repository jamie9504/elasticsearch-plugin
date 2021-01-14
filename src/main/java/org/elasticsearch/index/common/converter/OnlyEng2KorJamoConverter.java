package org.elasticsearch.index.common.converter;

import java.util.Objects;

import org.elasticsearch.index.common.util.AlphabetUtil;
import org.elasticsearch.index.common.util.JamoUtil;
import org.elasticsearch.index.common.util.KeyboardUtil;

public class OnlyEng2KorJamoConverter {

	/**
	 * 토큰이 오직 영문일 때(한글이 없을 때), 키보드 기준으로 한글 자모로 변환한다.
	 * 한글이 있다면, 기존 값을 그대로 반환한다.
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

			// 한글이 있으면 기존 값을 그대로 반환한다.
			if (JamoUtil.isHangul(init)) {
				return token;
			}

			// 영문이 아니면 넘긴다.
			if (!AlphabetUtil.isAlphabet(init)) {
				sb.append(word.charAt(index));
				continue;
			}

			// 영문이면 자+모로 치환한다.
			Character jamo = KeyboardUtil.tranceJamoAndAlphabet(init, true);
			if (Objects.isNull(jamo)) {
				return token;
			}
			sb.append(jamo);
		}
		return sb.toString();
	}
}
