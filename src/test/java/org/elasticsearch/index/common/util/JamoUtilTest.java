package org.elasticsearch.index.common.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class JamoUtilTest {

	@Test
	public void isChosung() {
		assertTrue(JamoUtil.isChosung('ㄱ'));
		assertTrue(JamoUtil.isChosung('ㅇ'));
		assertTrue(JamoUtil.isChosung('ㅎ'));
		assertFalse(JamoUtil.isChosung('ㅏ'));
		assertFalse(JamoUtil.isChosung('ㅣ'));
		assertFalse(JamoUtil.isChosung('각'));
		assertFalse(JamoUtil.isChosung('왕'));
		assertFalse(JamoUtil.isChosung('힣'));
		assertFalse(JamoUtil.isChosung('a'));
		assertFalse(JamoUtil.isChosung('z'));
		assertFalse(JamoUtil.isChosung('.'));
	}

	@Test
	public void isKorean() {
		assertFalse(JamoUtil.isKorean('ㄱ'));
		assertFalse(JamoUtil.isKorean('ㅇ'));
		assertFalse(JamoUtil.isKorean('ㅎ'));
		assertFalse(JamoUtil.isKorean('ㅏ'));
		assertFalse(JamoUtil.isKorean('ㅣ'));
		assertTrue(JamoUtil.isKorean('각'));
		assertTrue(JamoUtil.isKorean('왕'));
		assertTrue(JamoUtil.isKorean('힣'));
		assertFalse(JamoUtil.isKorean('a'));
		assertFalse(JamoUtil.isKorean('z'));
		assertFalse(JamoUtil.isKorean('.'));
	}

	@Test
	public void 종성분리() {
		assertEquals(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㄳ')[0], 'ㄱ');
		assertEquals(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㄳ')[1], 'ㅅ');
		assertEquals(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㄵ')[0], 'ㄴ');
		assertEquals(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㄵ')[1], 'ㅈ');
		assertEquals(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㄶ')[0], 'ㄴ');
		assertEquals(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㄶ')[1], 'ㅎ');
		assertEquals(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㄺ')[0], 'ㄹ');
		assertEquals(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㄺ')[1], 'ㄱ');
		assertEquals(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㄻ')[0], 'ㄹ');
		assertEquals(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㄻ')[1], 'ㅁ');
		assertEquals(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㄼ')[0], 'ㄹ');
		assertEquals(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㄼ')[1], 'ㅂ');
		assertEquals(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㄽ')[0], 'ㄹ');
		assertEquals(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㄽ')[1], 'ㅅ');
		assertEquals(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㄾ')[0], 'ㄹ');
		assertEquals(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㄾ')[1], 'ㅌ');
		assertEquals(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㄿ')[0], 'ㄹ');
		assertEquals(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㄿ')[1], 'ㅍ');
		assertEquals(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㅀ')[0], 'ㄹ');
		assertEquals(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㅀ')[1], 'ㅎ');
		assertEquals(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㅄ')[0], 'ㅂ');
		assertEquals(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㅄ')[1], 'ㅅ');

		assertNull(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㄱ'));
		assertNull(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㄲ'));
		assertNull(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㄴ'));
		assertNull(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㄷ'));
		assertNull(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㄸ'));
		assertNull(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㄹ'));
		assertNull(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㅁ'));
		assertNull(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㅂ'));
		assertNull(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㅃ'));
		assertNull(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㅅ'));

		assertNull(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㅆ'));
		assertNull(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㅈ'));
		assertNull(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㅉ'));
		assertNull(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㅊ'));
		assertNull(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㅋ'));
		assertNull(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㅌ'));
		assertNull(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㅍ'));
		assertNull(JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get('ㅎ'));
	}

	@Test
	public void 중성분리() {
		assertEquals(JamoUtil.UNICODE_DOUBLE_JUNG_SUNG_MAPPER.get('ㅘ')[0], 'ㅗ');
		assertEquals(JamoUtil.UNICODE_DOUBLE_JUNG_SUNG_MAPPER.get('ㅘ')[1], 'ㅏ');
		assertEquals(JamoUtil.UNICODE_DOUBLE_JUNG_SUNG_MAPPER.get('ㅙ')[0], 'ㅗ');
		assertEquals(JamoUtil.UNICODE_DOUBLE_JUNG_SUNG_MAPPER.get('ㅙ')[1], 'ㅐ');
		assertEquals(JamoUtil.UNICODE_DOUBLE_JUNG_SUNG_MAPPER.get('ㅚ')[0], 'ㅗ');
		assertEquals(JamoUtil.UNICODE_DOUBLE_JUNG_SUNG_MAPPER.get('ㅚ')[1], 'ㅣ');

		assertEquals(JamoUtil.UNICODE_DOUBLE_JUNG_SUNG_MAPPER.get('ㅝ')[0], 'ㅜ');
		assertEquals(JamoUtil.UNICODE_DOUBLE_JUNG_SUNG_MAPPER.get('ㅝ')[1], 'ㅓ');
		assertEquals(JamoUtil.UNICODE_DOUBLE_JUNG_SUNG_MAPPER.get('ㅞ')[0], 'ㅜ');
		assertEquals(JamoUtil.UNICODE_DOUBLE_JUNG_SUNG_MAPPER.get('ㅞ')[1], 'ㅔ');
		assertEquals(JamoUtil.UNICODE_DOUBLE_JUNG_SUNG_MAPPER.get('ㅟ')[0], 'ㅜ');
		assertEquals(JamoUtil.UNICODE_DOUBLE_JUNG_SUNG_MAPPER.get('ㅟ')[1], 'ㅣ');

		assertEquals(JamoUtil.UNICODE_DOUBLE_JUNG_SUNG_MAPPER.get('ㅢ')[0], 'ㅡ');
		assertEquals(JamoUtil.UNICODE_DOUBLE_JUNG_SUNG_MAPPER.get('ㅢ')[1], 'ㅣ');

		assertNull(JamoUtil.UNICODE_DOUBLE_JUNG_SUNG_MAPPER.get('ㅏ'));
		assertNull(JamoUtil.UNICODE_DOUBLE_JUNG_SUNG_MAPPER.get('ㅐ'));
		assertNull(JamoUtil.UNICODE_DOUBLE_JUNG_SUNG_MAPPER.get('ㅑ'));
		assertNull(JamoUtil.UNICODE_DOUBLE_JUNG_SUNG_MAPPER.get('ㅒ'));
		assertNull(JamoUtil.UNICODE_DOUBLE_JUNG_SUNG_MAPPER.get('ㅓ'));
		assertNull(JamoUtil.UNICODE_DOUBLE_JUNG_SUNG_MAPPER.get('ㅔ'));
		assertNull(JamoUtil.UNICODE_DOUBLE_JUNG_SUNG_MAPPER.get('ㅕ'));
		assertNull(JamoUtil.UNICODE_DOUBLE_JUNG_SUNG_MAPPER.get('ㅖ'));
		assertNull(JamoUtil.UNICODE_DOUBLE_JUNG_SUNG_MAPPER.get('ㅗ'));
		assertNull(JamoUtil.UNICODE_DOUBLE_JUNG_SUNG_MAPPER.get('ㅛ'));
		assertNull(JamoUtil.UNICODE_DOUBLE_JUNG_SUNG_MAPPER.get('ㅜ'));
		assertNull(JamoUtil.UNICODE_DOUBLE_JUNG_SUNG_MAPPER.get('ㅠ'));
		assertNull(JamoUtil.UNICODE_DOUBLE_JUNG_SUNG_MAPPER.get('ㅡ'));
		assertNull(JamoUtil.UNICODE_DOUBLE_JUNG_SUNG_MAPPER.get('ㅣ'));

	}
}