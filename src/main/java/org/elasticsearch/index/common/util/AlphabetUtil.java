package org.elasticsearch.index.common.util;

public class AlphabetUtil {

	/**
	 * 영어 대문자 유니코드의 시작값 (A)<br>
	 */
	public static final char START_ALPHABET_BIG_UNICODE = 0x41;

	/**
	 * 영어 대문자 유니코드의 끝값 (Z)<br>
	 */
	public static final char END_ALPHABET_BIG_UNICODE = 0x5A;

	/**
	 * 영어 소문자 유니코드의 시작값 (a)<br>
	 */
	public static final char START_ALPHABET_SMALL_UNICODE = 0x61;

	/**
	 * 영어 소문자 유니코드의 끝값 (z)<br>
	 */
	public static final char END_ALPHABET_SMALL_UNICODE = 0x7A;

	/**
	 * 영어 대소문자 유니코드 차이값<br>
	 */
	public static final int ALPHABET_BIG_SMALL_INTERVAL = START_ALPHABET_SMALL_UNICODE - START_ALPHABET_BIG_UNICODE;

	public static boolean isAlphabet(char text) {
		return (text >= START_ALPHABET_SMALL_UNICODE && text <= END_ALPHABET_SMALL_UNICODE)
			|| (text >= START_ALPHABET_BIG_UNICODE && text <= END_ALPHABET_BIG_UNICODE);
	}
}
