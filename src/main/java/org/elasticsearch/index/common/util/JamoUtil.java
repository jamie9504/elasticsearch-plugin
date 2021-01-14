package org.elasticsearch.index.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 한글 자모 유니코드 유틸리티
 *
 * https://www.unicode.org/charts/PDF/U1100.pdf
 *
 * @author hrkim
 *
 */
public class JamoUtil {

	/**
	 * 초성 (19자)<br>
	 * <br>
	 * 초성으로 올 수 있는 유니코드들<br>
	 * 총 19자로 구성된다.<br>
	 * <br>
	 * ㄱ ㄲ ㄴ ㄷ ㄸ ㄹ ㅁ ㅂ ㅃ ㅅ <br>
	 * ㅆ ㅇ ㅈ ㅉ ㅊ ㅋ ㅌ ㅍ ㅎ<br>
	 *
	 */
	public static final char[] UNICODE_CHO_SUNG = {
		0x3131, 0x3132, 0x3134, 0x3137, 0x3138, 0x3139, 0x3141, 0x3142, 0x3143, 0x3145,
		0x3146, 0x3147, 0x3148, 0x3149, 0x314A, 0x314B, 0x314C, 0x314D, 0x314E
	};

	/**
	 * 중성 (21자)<br>
	 * <br>
	 * 중성으로 올 수 있는 유니코드들<br>
	 * 총 21자로 구성된다.<br>
	 * <br>
	 * ㅏ ㅐ ㅑ ㅒ ㅓ ㅔ ㅕ ㅖ ㅗ ㅘ <br>
	 * ㅙ ㅚ ㅛ ㅜ ㅝ ㅞ ㅟ ㅠ ㅡ ㅢ <br>
	 * ㅣ<br>
	 *
	 */
	public static final char[] UNICODE_JUNG_SUNG = {
		0x314F, 0x3150, 0x3151, 0x3152, 0x3153, 0x3154, 0x3155, 0x3156, 0x3157, 0x3158,
		0x3159, 0x315A, 0x315B, 0x315C, 0x315D, 0x315E, 0x315F, 0x3160, 0x3161, 0x3162,
		0x3163
	};

	/**
	 * 종성 (28자)<br>
	 * <br>
	 * 종성으로 올 수 있는 유니코드들<br>
	 * 기본 27자와 "빈값"을 표현하는 1자를 합쳐서 총 28자로 구성된다.<br>
	 * <br>
	 *  빈값 ㄱ ㄲ ㄳ ㄴ ㄵ ㄶ ㄷ ㄹ ㄺ <br>
	 *  ㄻ ㄼ ㄽ ㄾ ㄿ ㅀ ㅁ ㅂ ㅄ ㅅ <br>
	 *  ㅆ ㅇ ㅈ ㅊ ㅋ ㅌ ㅍ ㅎ<br>
	 *
	 */
	public static final char[] UNICODE_JONG_SUNG = {
		0x0000, 0x3131, 0x3132, 0x3133, 0x3134, 0x3135, 0x3136, 0x3137, 0x3139, 0x313A,
		0x313B, 0x313C, 0x313D, 0x313E, 0x313F, 0x3140, 0x3141, 0x3142, 0x3144, 0x3145,
		0x3146, 0x3147, 0x3148, 0x314A, 0x314B, 0x314C, 0x314D, 0x314E
	};

	/**
	 * 겹모음 중성
	 *
	 * 겹모음 중성으로 올 수 있는 유니코드들
	 * ㅘ ㅙ ㅚ ㅝ ㅞ ㅟ ㅢ <br>
	 */
	public static final Map<Character, char[]> UNICODE_DOUBLE_JUNG_SUNG_MAPPER;

	/**
	 * 겹자음 종성
	 *
	 * 겹자음 종성으로 올 수 있는 유니코드들
	 */
	public static final Map<Character, char[]> UNICODE_DOUBLE_JONG_SUNG_MAPPER;

	static {
		UNICODE_DOUBLE_JUNG_SUNG_MAPPER = new HashMap<>();
		UNICODE_DOUBLE_JUNG_SUNG_MAPPER.put((char)0x3158, new char[] {0x3157, 0x314F}); // ㅘ, ㅗ+ㅏ
		UNICODE_DOUBLE_JUNG_SUNG_MAPPER.put((char)0x3159, new char[] {0x3157, 0x3150}); // ㅙ, ㅗ+ㅐ
		UNICODE_DOUBLE_JUNG_SUNG_MAPPER.put((char)0x315A, new char[] {0x3157, 0x3163}); // ㅚ, ㅗ+ㅣ
		UNICODE_DOUBLE_JUNG_SUNG_MAPPER.put((char)0x315D, new char[] {0x315C, 0x3153}); // ㅝ, ㅜ+ㅓ
		UNICODE_DOUBLE_JUNG_SUNG_MAPPER.put((char)0x315E, new char[] {0x315C, 0x3154}); // ㅞ, ㅜ+ㅔ
		UNICODE_DOUBLE_JUNG_SUNG_MAPPER.put((char)0x315F, new char[] {0x315C, 0x3163}); // ㅟ, ㅜ+ㅣ
		UNICODE_DOUBLE_JUNG_SUNG_MAPPER.put((char)0x3162, new char[] {0x3161, 0x3163}); // ㅢ, ㅡ+ㅣ


		UNICODE_DOUBLE_JONG_SUNG_MAPPER = new HashMap<>();
		UNICODE_DOUBLE_JONG_SUNG_MAPPER.put((char)0x3133, new char[] {0x3131, 0x3145}); // ㄳ, ㄱ+ㅅ
		UNICODE_DOUBLE_JONG_SUNG_MAPPER.put((char)0x3135, new char[] {0x3134, 0x3148}); // ㄵ, ㄴ+ㅈ
		UNICODE_DOUBLE_JONG_SUNG_MAPPER.put((char)0x3136, new char[] {0x3134, 0x314e}); // ㄶ, ㄴ+ㅎ
		UNICODE_DOUBLE_JONG_SUNG_MAPPER.put((char)0x313a, new char[] {0x3139, 0x3131}); // ㄺ, ㄹ+ㄱ
		UNICODE_DOUBLE_JONG_SUNG_MAPPER.put((char)0x313b, new char[] {0x3139, 0x3141}); // ㄻ, ㄹ+ㅁ
		UNICODE_DOUBLE_JONG_SUNG_MAPPER.put((char)0x313c, new char[] {0x3139, 0x3142}); // ㄼ, ㄹ+ㅂ
		UNICODE_DOUBLE_JONG_SUNG_MAPPER.put((char)0x313d, new char[] {0x3139, 0x3145}); // ㄽ, ㄹ+ㅅ
		UNICODE_DOUBLE_JONG_SUNG_MAPPER.put((char)0x313e, new char[] {0x3139, 0x314c}); // ㄾ, ㄹ+ㅌ
		UNICODE_DOUBLE_JONG_SUNG_MAPPER.put((char)0x313f, new char[] {0x3139, 0x314d}); // ㄿ, ㄹ+ㅍ
		UNICODE_DOUBLE_JONG_SUNG_MAPPER.put((char)0x3140, new char[] {0x3139, 0x314e}); // ㅀ, ㄹ+ㅎ
		UNICODE_DOUBLE_JONG_SUNG_MAPPER.put((char)0x3144, new char[] {0x3142, 0x3145}); // ㅄ, ㅂ+ㅅ
	}

	/**
	 * 한글 유니코드의 시작값 (가)<br>
	 * <br>
	 * 한글 유니코드는 0xAC00로 시작하여 0xD79F로 끝난다.<br>
	 * 시작값과 끝값을 벗어난 유니코드는 한글이 아니다.<br>
	 * <br>
	 * 시작값 : 0xAC00 가<br>
	 * 끝값   : 0xD79F 힟<br>
	 */
	public static final char START_KOREA_UNICODE = 0xAC00;

	/**
	 * 한글 유니코드의 끝값 ()<br>
	 */
	public static final char END_KOREA_UNICODE = 0xD7A3;

	/**
	 * 종성 빈값 유니코드
	 */
	public static final char UNICODE_JONG_SUNG_EMPTY = 0x0000;

	/**
	 * 초성 시작 값 (ㄱ)
	 */
	public static final char START_CHO_SUNG_UNICODE = 0x3131;

	/**
	 * 초성 끝 값 (ㅎ)
	 */
	public static final char END_CHO_SUNG_UNICODE = 0x314E;

	/**
	 * 중성 시작 값 (ㅏ)
	 */
	public static final char START_JUNG_SUNG_UNICODE = 0x314F;

	/**
	 * 중성 끝 값 (ㅣ)
	 */
	public static final char END_JUNG_SUNG_UNICODE = 0x3163;

	public static boolean isChosung(char text) {
		return text - START_CHO_SUNG_UNICODE >= 0
			&& text - END_CHO_SUNG_UNICODE <= 0;
	}

	public static boolean isKorean(char text) {
		return text - START_KOREA_UNICODE >= 0
			&& text - END_KOREA_UNICODE <= 0;
	}

	public static boolean isJungsung(char text) {
		return text - START_JUNG_SUNG_UNICODE >= 0
			&& text - END_JUNG_SUNG_UNICODE <= 0;
	}

	public static boolean isJamo(char text) {
		return isChosung(text) || isJungsung(text);
	}

	public static boolean isHangul(char text) {
		return isKorean(text) || isChosung(text) || isJungsung(text);
	}
}
