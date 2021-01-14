package org.elasticsearch.index.common.converter;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.common.type.CodeType;
import org.elasticsearch.index.common.util.AlphabetUtil;
import org.elasticsearch.index.common.util.JamoUtil;
import org.elasticsearch.index.common.util.KeyboardUtil;

public class OnlyKor2EngConverter {

	/**
	 * 토큰이 오직 한글일 때(영문이 없을 때), 키보드 기준으로 영문으로 변환한다.
	 * 영문이 있다면, 기존 값을 그대로 반환한다.
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

			// 영문이 있으면 기존 값을 그대로 반환한다.
			if (AlphabetUtil.isAlphabet(init)) {
				return token;
			}

			// 한글이 아니면 넘긴다.
			if (!JamoUtil.isHangul(init)) {
				sb.append(word.charAt(index));
				continue;
			}

			try {
				if (JamoUtil.isKorean(init)) {
					int initUnicode = init - JamoUtil.START_KOREA_UNICODE;
					/**
					 * 1글자로 조합형 한글이 들어올 경우 처리
					 */
					int cho = initUnicode / 21 / 28;   // 0 ~ 18
					String strCho = getSameEngChar(CodeType.CHOSUNG, cho);
					if (StringUtils.isNotEmpty(strCho)) {
						sb.append(strCho);
					}

					int jung = initUnicode / 28 % 21;   // 0 ~ 20
					String strJung = getSameEngChar(CodeType.JUNGSUNG, jung);
					if (StringUtils.isNotEmpty(strJung)) {
						sb.append(strJung);
					}

					int jong = initUnicode % 28;        // 0 ~ 27
					String strJong = getSameEngChar(CodeType.JONGSUNG, jong);
					if (StringUtils.isNotEmpty(strJong)) {
						sb.append(strJong);
					}
					continue;
				}

				/**
				 * 1글자로 자모가 들어올 경우 처리
				 */
				Character sameEngCharForJamo = getSameEngCharForJamo(init);
				if (Objects.nonNull(sameEngCharForJamo)) {
					sb.append(sameEngCharForJamo);
				}
			} catch (Exception e) {
			}
		}
		return sb.toString();
	}

	protected String getSameEngChar(CodeType type, int pos) {
		switch (type) {
			case CHOSUNG:
				return KeyboardUtil.KEYBOARD_CHO_SUNG_STRING[pos];

			case JUNGSUNG:
				return KeyboardUtil.KEYBOARD_JUNG_SUNG_STRING[pos];

			case JONGSUNG:
				if ((pos - 1) > -1) {
					return KeyboardUtil.KEYBOARD_JONG_SUNG_STRING[pos - 1];
				}
				return "";
		}
		return "";
	}

	private Character getSameEngCharForJamo(char key) {
		Character sameEngCharForJamo = KeyboardUtil.tranceJamoAndAlphabet(key, true);
		if (Objects.isNull(sameEngCharForJamo) || !AlphabetUtil.isAlphabet(sameEngCharForJamo)) {
			return null;
		}
		return sameEngCharForJamo;
	}
}
