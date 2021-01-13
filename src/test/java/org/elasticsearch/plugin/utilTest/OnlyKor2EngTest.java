package org.elasticsearch.plugin.utilTest;

import static org.junit.Assert.*;

import org.elasticsearch.index.common.converter.OnlyKor2EngConverter;
import org.junit.Test;

public class OnlyKor2EngTest {

	@Test
	public void onlyKor2EngTest_OnlyKorean1() {
		String token = "제이미";
		OnlyKor2EngConverter converter = new OnlyKor2EngConverter();
		String result = converter.convert(token);

		System.out.println(result);
		assertEquals("wpdlal", result);
	}

	@Test
	public void onlyKor2EngTest_OnlyKorean2() {
		String token = "제-이1미!";
		OnlyKor2EngConverter converter = new OnlyKor2EngConverter();
		String result = converter.convert(token);

		System.out.println(result);
		assertEquals("wp-dl1al!", result);
	}

	@Test
	public void onlyKor2EngTest_MixedKorean1() {
		String token = "Ja이미";
		OnlyKor2EngConverter converter = new OnlyKor2EngConverter();
		String result = converter.convert(token);

		System.out.println(result);
		assertEquals(token, result);
	}

	@Test
	public void onlyKor2EngTest_MixedKorean2() {
		String token = "Ja-이1미!";
		OnlyKor2EngConverter converter = new OnlyKor2EngConverter();
		String result = converter.convert(token);

		System.out.println(result);
		assertEquals(token, result);
	}

	@Test
	public void onlyKor2EngTest_OnlyEnglish1() {
		String token = "Jamie";
		OnlyKor2EngConverter converter = new OnlyKor2EngConverter();
		String result = converter.convert(token);

		System.out.println(result);
		assertEquals(token, result);
	}

	@Test
	public void onlyKor2EngTest_OnlyEnglish2() {
		String token = "Ja-mi1e!";
		OnlyKor2EngConverter converter = new OnlyKor2EngConverter();
		String result = converter.convert(token);

		System.out.println(result);
		assertEquals(token, result);
	}

}