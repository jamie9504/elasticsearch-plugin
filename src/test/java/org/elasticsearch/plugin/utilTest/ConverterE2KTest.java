package org.elasticsearch.plugin.utilTest;

import static org.junit.Assert.*;

import org.elasticsearch.index.common.converter.EngToKorConverter;
import org.junit.Test;

public class ConverterE2KTest {

	@Test
	public void 자바카페() {
		String token = "wkqkzkvp";

		EngToKorConverter convert = new EngToKorConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("자바카페", result);
	}

	@Test
	public void 삼성전자() {
		String token = "tkatjdwjswk";

		EngToKorConverter convert = new EngToKorConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("삼성전자", result);
	}

	@Test
	public void 한글() {
		String token = "gksrmf";

		EngToKorConverter convert = new EngToKorConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("한글", result);
	}

	@Test
	public void 한글1() {
		String token = "gksrmf1";

		EngToKorConverter convert = new EngToKorConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("한글1", result);
	}

	@Test
	public void 한글영어1() {
		String token = "gksrmf영어1";

		EngToKorConverter convert = new EngToKorConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("한글영어1", result);
	}

	@Test
	public void 뮹나ㄴ뉴느() {
		String token = "abd나s뉴느";

		EngToKorConverter convert = new EngToKorConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("뮹나ㄴ뉴느", result);
	}

	@Test
	public void ㅇㄹㅁㄴ() {
		String token = "dfas";

		EngToKorConverter convert = new EngToKorConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("ㅇㄹㅁㄴ", result);
	}

	@Test
	public void 메ㅔㅣㄷ() {
		String token = "apple";

		EngToKorConverter convert = new EngToKorConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("메ㅔㅣㄷ", result);
	}

	@Test
	public void 꾸꾸() {
		String token = "RnRn";

		EngToKorConverter convert = new EngToKorConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("꾸꾸", result);
	}

	@Test
	public void 뚜뚜() {
		String token = "EnEn";

		EngToKorConverter convert = new EngToKorConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("뚜뚜", result);
	}

	@Test
	public void 구구() {
		String token = "rnrn";

		EngToKorConverter convert = new EngToKorConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("구구", result);
	}

	@Test
	public void 청바지() {
		String token = "cjDqKwl";

		EngToKorConverter convert = new EngToKorConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("청바지", result);
	}
}
