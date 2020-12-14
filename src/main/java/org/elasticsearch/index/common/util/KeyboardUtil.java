package org.elasticsearch.index.common.util;

import static org.elasticsearch.index.common.type.CodeType.*;
import static org.elasticsearch.index.common.util.AlphabetUtil.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.elasticsearch.index.common.converter.ShiftConverter;
import org.elasticsearch.index.common.type.CodeType;

/**
 * 한글 키보드 유틸리티
 *
 *
 * @author hrkim
 *
 */
public class KeyboardUtil {

	/**
	 * 초성 키에 해당하는 키보드상의 영문자 (19자)
	 */
	public static final String[] KEYBOARD_CHO_SUNG_STRING = {
		"r", "R", "s", "e", "E", "f", "a", "q", "Q", "t",
		"T", "d", "w", "W", "c", "z", "x", "v", "g"
	};

	/**
	 * 중성 키에 해당하는 키보드상의 영문자 (21자)
	 */
	public static final String[] KEYBOARD_JUNG_SUNG_STRING = {
		"k", "o", "i", "O", "j", "p", "u", "P", "h", "hk",
		"ho", "hl", "y", "n", "nj", "np", "nl", "b", "m", "ml", "l"
	};

	/**
	 * 종성 키에 해당하는 키보드상의 영문자 (27자) - "빈값" 제외
	 */
	public static final String[] KEYBOARD_JONG_SUNG_STRING = {
		"r", "R", "rt", "s", "sw", "sg", "e", "f", "fr", "fa",
		"fq", "ft", "fx", "fv", "fg", "a", "q", "qt", "t", "T",
		"d", "w", "c", "z", "x", "v", "g"
	};

	public static final Map<String, Integer> KEYBOARD_CHO_SUNG_UNICODE_INDEX_MAPPER;
	public static final Map<String, Integer> KEYBOARD_JUNG_SUNG_UNICODE_INDEX_MAPPER;
	public static final Map<String, Integer> KEYBOARD_JONG_SUNG_UNICODE_INDEX_MAPPER;

	public static final Map<Character, Character> KEYBOARD_KEY_KO_EN_MAPPER;
	public static final Map<Character, Character> KEYBOARD_KEY_SHIFT_MAPPER;

	static {
		// 키보드상에서 한영키에 의해서 오타 교정이 필요한 키배열 (영문키 33자)
		char[] keyboardKeyEng = {
			'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
			'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
			'u', 'v', 'w', 'x', 'y', 'z', 'Q', 'W', 'E', 'R',
			'T', 'O', 'P'
		};

		// 키보드상에서 한영키에 의해서 오타 교정이 필요한 키배열 (한글키 33자)
		char[] keyboardKeyKor = {
			'ㅁ', 'ㅠ', 'ㅊ', 'ㅇ', 'ㄷ', 'ㄹ', 'ㅎ', 'ㅗ', 'ㅑ', 'ㅓ',
			'ㅏ', 'ㅣ', 'ㅡ', 'ㅜ', 'ㅐ', 'ㅔ', 'ㅂ', 'ㄱ', 'ㄴ', 'ㅅ',
			'ㅕ', 'ㅍ', 'ㅈ', 'ㅌ', 'ㅛ', 'ㅋ', 'ㅃ', 'ㅉ', 'ㄸ', 'ㄲ',
			'ㅆ', 'ㅒ', 'ㅖ'
		};

		char[] keyboardKeyEngShift = {
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
			'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
			'U', 'V', 'W', 'X', 'Y', 'Z', 'q', 'w', 'e', 'r',
			't', 'o', 'p'
		};

		char[] keyboardKeyKorShift = {
			'ㅁ', 'ㅠ', 'ㅊ', 'ㅇ', 'ㄸ', 'ㄹ', 'ㅎ', 'ㅗ', 'ㅑ', 'ㅓ',
			'ㅏ', 'ㅣ', 'ㅡ', 'ㅜ', 'ㅒ', 'ㅖ', 'ㅃ', 'ㄲ', 'ㄴ', 'ㅆ',
			'ㅕ', 'ㅍ', 'ㅉ', 'ㅌ', 'ㅛ', 'ㅋ', 'ㅂ', 'ㅈ', 'ㄷ', 'ㄱ',
			'ㅅ', 'ㅐ', 'ㅔ'
		};

		Map<Character, Character> keyboardKeyMapper = new HashMap<>();
		for (int i = 0; i < keyboardKeyEng.length; i++) {
			keyboardKeyMapper.put(keyboardKeyEng[i], keyboardKeyKor[i]);
			keyboardKeyMapper.put(keyboardKeyKor[i], keyboardKeyEng[i]);
		}

		Map<Character, Character> keyboardKeyShiftMapper = new HashMap<>();
		for (int i = 0; i < keyboardKeyEng.length; i++) {
			keyboardKeyShiftMapper.put(keyboardKeyEng[i], keyboardKeyEngShift[i]);
			keyboardKeyShiftMapper.put(keyboardKeyKor[i], keyboardKeyKorShift[i]);

			if (!keyboardKeyMapper.containsKey(keyboardKeyEngShift[i])) {
				keyboardKeyMapper.put(keyboardKeyEngShift[i], keyboardKeyKorShift[i]);
			}
			if (!keyboardKeyMapper.containsKey(keyboardKeyKorShift[i])) {
				keyboardKeyMapper.put(keyboardKeyKorShift[i], keyboardKeyEngShift[i]);
			}
		}
		KEYBOARD_KEY_KO_EN_MAPPER = Collections.unmodifiableMap(keyboardKeyMapper);
		KEYBOARD_KEY_SHIFT_MAPPER = Collections.unmodifiableMap(keyboardKeyShiftMapper);

		Map<String, Integer> keyboardChoSung = new HashMap<>();
		for (int i = 0; i < KEYBOARD_CHO_SUNG_STRING.length; i++) {
			keyboardChoSung.put(KEYBOARD_CHO_SUNG_STRING[i], i * 28 * 21);
			keyboardChoSung.put(KEYBOARD_CHO_SUNG_STRING[i], i * 28 * 21);
		}
		Set<String> choSungs = new HashSet<>(keyboardChoSung.keySet());
		for (String choSung : choSungs) {
			String upperCaseChoSung = choSung.toUpperCase();
			if(Objects.isNull(keyboardChoSung.get(upperCaseChoSung))) {
				keyboardChoSung.put(upperCaseChoSung, keyboardChoSung.get(choSung));
			}
		}
		KEYBOARD_CHO_SUNG_UNICODE_INDEX_MAPPER = Collections.unmodifiableMap(new HashMap<>(keyboardChoSung));

		Map<String, Integer> keyboardJungSung = new HashMap<>();
		for (int i = 0; i < KEYBOARD_JUNG_SUNG_STRING.length; i++) {
			keyboardJungSung.put(KEYBOARD_JUNG_SUNG_STRING[i], i * 28);
		}
		Set<String> jungSungs = new HashSet<>(keyboardJungSung.keySet());
		for (String jungSung : jungSungs) {
			String upperCaseJungSung = jungSung.toUpperCase();
			if(Objects.isNull(keyboardJungSung.get(upperCaseJungSung))) {
				keyboardJungSung.put(upperCaseJungSung, keyboardJungSung.get(jungSung));
			}
		}
		KEYBOARD_JUNG_SUNG_UNICODE_INDEX_MAPPER = Collections.unmodifiableMap(new HashMap<>(keyboardJungSung));

		Map<String, Integer> keyboardJongSung = new HashMap<>();
		for (int i = 0; i < KEYBOARD_JONG_SUNG_STRING.length; i++) {
			keyboardJongSung.put(KEYBOARD_JONG_SUNG_STRING[i], i + 1);
		}
		Set<String> jongSungs = new HashSet<>(keyboardJongSung.keySet());
		for (String jungSong : jongSungs) {
			String upperCaseJongSung = jungSong.toUpperCase();
			if(Objects.isNull(keyboardJongSung.get(upperCaseJongSung))) {
				keyboardJongSung.put(upperCaseJongSung, keyboardJongSung.get(jungSong));
			}
		}
		KEYBOARD_JONG_SUNG_UNICODE_INDEX_MAPPER = Collections.unmodifiableMap(new HashMap<>(keyboardJongSung));
	}

	/**
	 * 초성 정보를 제공한다.
	 *
	 * - 초성과 매칭된 코드 조회
	 * - 한 자로 이루어진 초성코드만 존재한다.
	 *
	 * @param index
	 * @param word
	 * @return
	 */
	public static Map<String, Integer> getInfoForChoSung(int index, String word) {
		int code = KeyboardUtil.makeUnicodeIndex(CodeType.CHOSUNG, word.substring(index, index + 1));
		int idx = index + 1;

		Map<String, Integer> m = new HashMap<>();
		m.put("code", code);
		m.put("idx", idx);

		return m;
	}

	/**
	 * 중성 정보를 제공한다.
	 *
	 * - 중성과 매칭된 코드 조회
	 * - 두 자로 이루어진 중성코드가 존재한다.
	 *
	 * @param index
	 * @param word
	 * @return
	 */
	public static Map<String, Integer> getInfoForJungSung(int index, String word) {
		int code = KeyboardUtil.getDoubleMedial(index, word);
		int idx = index + 2;

		if (-1 == code) {
			code = KeyboardUtil.getSingleMedial(index, word);
			idx = index + 1;
		}

		Map<String, Integer> m = new HashMap<>();
		m.put("code", code);
		m.put("idx", idx);

		return m;
	}

	/**
	 * 종성 정보를 제공한다.
	 *
	 * - 종성과 매칭된 코드 조회
	 * - 두 자로 이루어진 종성코드가 존재한다.
	 *
	 * @param index
	 * @param word
	 * @return
	 */
	public static Map<String, Integer> getInfoForJongSung(int index, String word) {
		int code;
		int idx = index;

		int temp = KeyboardUtil.getDoubleFinal(idx, word);
		if (-1 == temp) {
			temp = KeyboardUtil.getSingleMedial(idx + 1, word);
			if (temp != -1) {
				code = 0;
				idx--;
			} else {
				code = KeyboardUtil.getSingleFinal(idx, word);
				if (code == -1) {
					code = 0;
					idx--;
				}
			}

		} else {
			code = temp;
			temp = KeyboardUtil.getSingleMedial(idx + 2, word);
			if (temp != -1) {
				code = KeyboardUtil.getSingleFinal(idx, word);
			} else {
				idx++;
			}

		}

		Map<String, Integer> m = new HashMap<>();
		m.put("code", code);
		m.put("idx", idx);

		return m;
	}

	/**
	 * 1자로 구성된 중성 유니코드 Index를 리턴한다.
	 *
	 * @param index
	 * @param word
	 * @return
	 */
	private static int getSingleMedial(int index, String word) {
		if ((index + 1) <= word.length()) {
			return makeUnicodeIndex(CodeType.JUNGSUNG, word.substring(index, index + 1));
		} else {
			return -1;
		}
	}

	/**
	 * 2자로 구성된 중성 유니코드 Index를 리턴한다.
	 *
	 * @param index
	 * @param word
	 * @return
	 */
	private static int getDoubleMedial(int index, String word) {
		if ((index + 2) > word.length()) {
			return -1;
		} else {
			return makeUnicodeIndex(CodeType.JUNGSUNG, word.substring(index, index + 2));
		}
	}

	/**
	 * 1자로 구성된 종성 유니코드 Index를 리턴한다.
	 *
	 * @param index
	 * @param word
	 * @return
	 */
	private static int getSingleFinal(int index, String word) {
		if ((index + 1) <= word.length()) {
			return makeUnicodeIndex(JONGSUNG, word.substring(index, index + 1));
		} else {
			return -1;
		}
	}

	/**
	 * 2자로 구성된 종성 유니코드 Index를 리턴한다.
	 *
	 * @param index
	 * @param word
	 * @return
	 */
	private static int getDoubleFinal(int index, String word) {
		if ((index + 2) > word.length()) {
			return -1;
		} else {
			return makeUnicodeIndex(JONGSUNG, word.substring(index, index + 2));
		}
	}

	/**
	 * 키보드상에 매칭된 유니코드값 Index를 리턴한다.
	 *
	 * @param type
	 * @param subStr
	 * @return
	 */
	private static int makeUnicodeIndex(CodeType type, String subStr) {
		Integer unicodeIndex;

		switch (type) {
			case CHOSUNG:
				unicodeIndex = KEYBOARD_CHO_SUNG_UNICODE_INDEX_MAPPER.get(subStr);
				if (Objects.nonNull(unicodeIndex)) {
					return unicodeIndex;
				}
				break;

			case JUNGSUNG:
				unicodeIndex = KEYBOARD_JUNG_SUNG_UNICODE_INDEX_MAPPER.get(subStr);
				if (Objects.nonNull(unicodeIndex)) {
					return unicodeIndex;
				}
				break;

			case JONGSUNG:
				unicodeIndex = KEYBOARD_JONG_SUNG_UNICODE_INDEX_MAPPER.get(subStr);
				if (Objects.nonNull(unicodeIndex)) {
					return unicodeIndex;
				}
				break;

			default:
				break;
		}
		return -1;
	}

	public static char getJamoFromAlphabet(char init) {
		return KEYBOARD_KEY_KO_EN_MAPPER.get(init);
	}
}


















