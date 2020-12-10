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
}