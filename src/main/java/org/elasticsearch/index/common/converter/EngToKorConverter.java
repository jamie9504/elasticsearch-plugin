package org.elasticsearch.index.common.converter;

import java.util.Map;

import org.elasticsearch.index.common.util.AlphabetUtil;
import org.elasticsearch.index.common.util.JamoUtil;
import org.elasticsearch.index.common.util.KeyboardUtil;

/**
 * 영한 오타 변환기 (Eng -> Kor)
 *
 * @author hrkim
 *
 */
public class EngToKorConverter {

	/**
	 * 토큰을 영문 키보드 기준으로 변환한다.
	 *
	 * @param token
	 * @return
	 */
	public String convert(String token) {
		StringBuilder sb = new StringBuilder();
		// 문자열을 한글자씩 잘라서 처리한다.
		String word = token.trim();
		for (int index = 0; index < word.length(); index++) {
			// 알파벳이 아니면 넘긴다.
			char init = word.charAt(index);
			if (!AlphabetUtil.isAlphabet(init)) {
				sb.append(init);
				continue;
			}

			try {
				// 초성 정보를 구한다.
				Map<String, Integer> mChoSung = KeyboardUtil.getInfoForChoSung(index, word);
				int cho = mChoSung.get("code");

				// 다음에 글자가 없는 경우
				if (index + 1 == word.length()) {
					sb.append(KeyboardUtil.getJamoFromAlphabet(init));
					continue;
				}

				// 자음만 있는 경우
				char nextInit = word.charAt(index + 1);
				if (!AlphabetUtil.isAlphabet(nextInit)
					|| (AlphabetUtil.isAlphabet(nextInit)
					&& KeyboardUtil.getInfoForChoSung(index + 1, word).get("code") != -1)) {
					sb.append(KeyboardUtil.getJamoFromAlphabet(init));
					continue;
				}
				index = mChoSung.get("idx");

				// 모음만 있는 경우
				if (cho == -1) {
					index--;
					sb.append(KeyboardUtil.getJamoFromAlphabet(word.charAt(index)));
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
}
