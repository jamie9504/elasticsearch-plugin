package org.elasticsearch.plugin.utilTest;

import static org.junit.Assert.*;

import org.elasticsearch.index.common.parser.KoreanJamoParser;
import org.junit.Test;

public class ParserJamoTest {

	private final KoreanJamoParser PARSER = new KoreanJamoParser();

	@Test
	public void jamoTest_초성중성() {
		String token = "자바카페";
		String result = PARSER.parse(token);

		System.out.println(result);
		assertEquals("ㅈㅏㅂㅏㅋㅏㅍㅔ", result);
	}

	@Test
	public void jamoTest_초성중성종성() {
		String token = "삼성전자";
		String result = PARSER.parse(token);

		System.out.println(result);
		assertEquals("ㅅㅏㅁㅅㅓㅇㅈㅓㄴㅈㅏ", result);
	}

	@Test
	public void jamoTest_초성ㅉ() {
		String token = "짜다";
		String result = PARSER.parse(token);

		System.out.println(result);
		assertEquals("ㅉㅏㄷㅏ", result);
	}

	@Test
	public void jamoTest_종성ㅆ() {
		String token = "갔다";
		String result = PARSER.parse(token);

		System.out.println(result);
		assertEquals("ㄱㅏㅆㄷㅏ", result);
	}

	@Test
	public void jamoTest_종성ㄹㅁ() {
		String token = "굶다";
		String result = PARSER.parse(token);

		System.out.println(result);
		assertEquals("ㄱㅜㄹㅁㄷㅏ", result);
	}

	@Test
	public void jamoTest_중성ㅙ() {
		String token = "왜";
		String result = PARSER.parse(token);

		System.out.println(result);
		assertEquals("ㅇㅗㅐ", result);
	}
}
