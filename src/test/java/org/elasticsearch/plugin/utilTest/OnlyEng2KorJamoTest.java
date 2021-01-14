package org.elasticsearch.plugin.utilTest;

import static org.junit.Assert.*;

import org.elasticsearch.index.common.converter.OnlyEng2KorJamoConverter;
import org.junit.Test;

public class OnlyEng2KorJamoTest {

	@Test
	public void onlyEng2KorJamoTest_OnlyKorean1() {
		String token = "제이미";
		OnlyEng2KorJamoConverter converter = new OnlyEng2KorJamoConverter();
		String result = converter.convert(token);

		System.out.println(result);
		assertEquals(token, result);
	}

	@Test
	public void onlyEng2KorJamoTest_OnlyKorean2() {
		String token = "제-이1미!";
		OnlyEng2KorJamoConverter converter = new OnlyEng2KorJamoConverter();
		String result = converter.convert(token);

		System.out.println(result);
		assertEquals(token, result);
	}

	@Test
	public void onlyEng2KorJamoTest_MixedKorean1() {
		String token = "Ja이미";
		OnlyEng2KorJamoConverter converter = new OnlyEng2KorJamoConverter();
		String result = converter.convert(token);

		System.out.println(result);
		assertEquals(token, result);
	}

	@Test
	public void onlyEng2KorJamoTest_MixedKorean2() {
		String token = "Ja-이1미!";
		OnlyEng2KorJamoConverter converter = new OnlyEng2KorJamoConverter();
		String result = converter.convert(token);

		System.out.println(result);
		assertEquals(token, result);
	}

	@Test
	public void onlyEng2KorJamoTest_OnlyEnglish1() {
		String token = "wpdlal";
		OnlyEng2KorJamoConverter converter = new OnlyEng2KorJamoConverter();
		String result = converter.convert(token);

		System.out.println(result);
		assertEquals("ㅈㅔㅇㅣㅁㅣ", result);
	}

	@Test
	public void onlyEng2KorJamoTest_OnlyEnglish2() {
		String token = "Wnp-dl1ald!";
		OnlyEng2KorJamoConverter converter = new OnlyEng2KorJamoConverter();
		String result = converter.convert(token);

		System.out.println(result);
		assertEquals("ㅉㅜㅔ-ㅇㅣ1ㅁㅣㅇ!", result);
	}

	@Test
	public void onlyEng2KorJamoTest_OnlyEnglishButNotKorean1() {
		String token = "wpdlAl";
		OnlyEng2KorJamoConverter converter = new OnlyEng2KorJamoConverter();
		String result = converter.convert(token);

		System.out.println(result);
		assertEquals(token, result);
	}

	@Test
	public void onlyEng2KorJamoTest_OnlyEnglishButNotKorean2() {
		String token = "Jamie";
		OnlyEng2KorJamoConverter converter = new OnlyEng2KorJamoConverter();
		String result = converter.convert(token);

		System.out.println(result);
		assertEquals(token, result);
	}

	@Test
	public void onlyEng2KorJamoTest_OnlyEnglishButNotKorean3() {
		String token = "cjDqKwl";

		OnlyEng2KorJamoConverter converter = new OnlyEng2KorJamoConverter();
		String result = converter.convert(token);

		System.out.println(result);
		assertEquals(token, result);
	}
}
