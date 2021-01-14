package org.elasticsearch.index.common.converter;

import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.common.type.CodeType;
import org.elasticsearch.index.common.util.AlphabetUtil;
import org.elasticsearch.index.common.util.JamoUtil;
import org.elasticsearch.index.common.util.KeyboardUtil;

public class LanguageConverter {

	/**
	 * 토큰을 한영 키보드 기준으로 상호 변환한다.
	 *
	 * @param token
	 * @return
	 */
	public String convert(String token) {
		StringBuilder sb = new StringBuilder();
		// 문자열을 한글자씩 잘라서 처리한다.
		String word = token.trim();
		for (int index = 0; index < word.length(); index++) {
			// 한글이나 알파벳이 아니라면 넘긴다.
			char init = word.charAt(index);
			if (!JamoUtil.isHangul(init) && !AlphabetUtil.isAlphabet(init)) {
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

				if (JamoUtil.isJamo(init)) {
					/**
					 * 1글자로 자모가 들어올 경우 처리
					 */
					Character sameEngCharForJamo = getSameEngCharForJamo(init);
					if (Objects.nonNull(sameEngCharForJamo)) {
						sb.append(sameEngCharForJamo);
					}
					continue;
				}

				// 영 한
				// 초성 정보를 구한다.
				Map<String, Integer> mChoSung = KeyboardUtil.getInfoForChoSung(index, word);
				int cho = mChoSung.get("code");

				// 다음에 글자가 없는 경우
				if (index + 1 == word.length()) {
					sb.append(KeyboardUtil.tranceJamoAndAlphabet(init, false));
					continue;
				}

				// 자음만 있는 경우
				char nextInit = word.charAt(index + 1);
				if (!AlphabetUtil.isAlphabet(nextInit)
					|| (AlphabetUtil.isAlphabet(nextInit)
					&& KeyboardUtil.getInfoForChoSung(index + 1, word).get("code") != -1)) {
					sb.append(KeyboardUtil.tranceJamoAndAlphabet(init, false));
					continue;
				}
				index = mChoSung.get("idx");

				// 모음만 있는 경우
				if (cho == -1) {
					index--;
					sb.append(KeyboardUtil.tranceJamoAndAlphabet(word.charAt(index), false));
					continue;
				}

				// 중성 정보를 구한다.
				Map<String, Integer> mJungSung = KeyboardUtil.getInfoForJungSung(index, word);
				int jung = mJungSung.get("code");
				index = mJungSung.get("idx");

				// 종성 정보를 구한다.
				Map<String, Integer> mJongSung = KeyboardUtil.getInfoForJongSung(index, word);
				int jong = mJongSung.get("code");
				index = mJongSung.get("idx");

				// 한글 유니코드를 생성한다.
				sb.append((char)(JamoUtil.START_KOREA_UNICODE + cho + jung + jong));
			} catch (Exception e) {
			}
		}
		return sb.toString();
	}

	private String getSameEngChar(CodeType type, int pos) {
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
