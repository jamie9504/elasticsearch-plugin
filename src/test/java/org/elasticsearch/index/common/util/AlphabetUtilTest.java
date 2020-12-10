package org.elasticsearch.index.common.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlphabetUtilTest {

	@Test
	public void isAlphabet() {
		assertTrue(AlphabetUtil.isAlphabet('a'));
		assertTrue(AlphabetUtil.isAlphabet('o'));
		assertTrue(AlphabetUtil.isAlphabet('z'));
		assertTrue(AlphabetUtil.isAlphabet('A'));
		assertTrue(AlphabetUtil.isAlphabet('O'));
		assertTrue(AlphabetUtil.isAlphabet('Z'));
		assertFalse(AlphabetUtil.isAlphabet('ㄱ'));
		assertFalse(AlphabetUtil.isAlphabet('['));
		assertFalse(AlphabetUtil.isAlphabet('가'));
		assertFalse(AlphabetUtil.isAlphabet('ㅏ'));
		assertFalse(AlphabetUtil.isAlphabet('.'));
		assertFalse(AlphabetUtil.isAlphabet('1'));
		assertFalse(AlphabetUtil.isAlphabet('+'));
	}
}