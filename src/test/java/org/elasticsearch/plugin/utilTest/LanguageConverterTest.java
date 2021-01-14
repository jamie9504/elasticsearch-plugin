package org.elasticsearch.plugin.utilTest;

import static org.junit.Assert.*;

import org.elasticsearch.index.common.converter.LanguageConverter;
import org.junit.Test;

public class LanguageConverterTest {

	@Test
	public void 자바카페() {
		String token = "wkqkzkvp";

		LanguageConverter convert = new LanguageConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("자바카페", result);
	}

	@Test
	public void 삼성전자() {
		String token = "tkatjdwjswk";

		LanguageConverter convert = new LanguageConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("삼성전자", result);
	}

	@Test
	public void 한글() {
		String token = "gksrmf";

		LanguageConverter convert = new LanguageConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("한글", result);
	}

	@Test
	public void 한글1() {
		String token = "gksrmf1";

		LanguageConverter convert = new LanguageConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("한글1", result);
	}

	@Test
	public void 한글duddj1() {
		String token = "gksrmf영어1";

		LanguageConverter convert = new LanguageConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("한글duddj1", result);
	}

	@Test
	public void 뮹skㄴsbsm() {
		String token = "abd나S뉴느";

		LanguageConverter convert = new LanguageConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("뮹skㄴsbsm", result);
	}

	@Test
	public void ㅇㄹㅁㄴ() {
		String token = "dfas";

		LanguageConverter convert = new LanguageConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("ㅇㄹㅁㄴ", result);
	}

	@Test
	public void javacafe() {
		String token = "ㅓㅁㅍㅁㅊㅁㄹㄷ";

		LanguageConverter convert = new LanguageConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("javacafe", result);
	}

	@Test
	public void iphone() {
		String token = "ㅑㅔㅗㅐㅜㄷ";

		LanguageConverter convert = new LanguageConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("iphone", result);
	}

	@Test
	public void woman() {
		String token = "재ㅡ무";

		LanguageConverter convert = new LanguageConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("woman", result);
	}

	@Test
	public void samsung() {
		String token = "ㄴ므녀ㅜㅎ";

		LanguageConverter convert = new LanguageConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("samsung", result);
	}

	@Test
	public void samsung1() {
		String token = "ㄴ므녀ㅜㅎ1";

		LanguageConverter convert = new LanguageConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("samsung1", result);
	}

	@Test
	public void aorqnr() {
		String token = "맥북";

		LanguageConverter convert = new LanguageConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("aorqnr", result);
	}

	@Test
	public void 메ㅔㅣㄷgood() {
		String token = "apple해ㅐㅇ";

		LanguageConverter convert = new LanguageConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("메ㅔㅣㄷgood", result);
	}

	@Test
	public void banana해ㅐㅇ() {
		String token = "ㅠ무뭄good";

		LanguageConverter convert = new LanguageConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("banana해ㅐㅇ", result);
	}

	@Test
	public void ㅊ무dygoㅐㅇ() {
		String token = "can요해od";

		LanguageConverter convert = new LanguageConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("ㅊ무dygoㅐㅇ", result);
	}

	@Test
	public void dessertgood() {
		String token = "ㅇㄷㄴㄴㄷㄱㅅ해ㅐㅇ";

		LanguageConverter convert = new LanguageConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("dessertgood", result);
	}

	@Test
	public void egggood() {
		String token = "ㄷㅎㅎㅎㅐㅐㅇ";

		LanguageConverter convert = new LanguageConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("egggood", result);
	}

	@Test
	public void 꾸꾸() {
		String token = "RnRn";

		LanguageConverter convert = new LanguageConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("꾸꾸", result);
	}

	@Test
	public void 구구() {
		String token = "rnrn";

		LanguageConverter convert = new LanguageConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("구구", result);
	}

	@Test
	public void 청바지() {
		String token = "cjDqKwl";

		LanguageConverter convert = new LanguageConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("청바지", result);
	}

	@Test
	public void 상() {
		String token = "tKD";

		LanguageConverter convert = new LanguageConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("상", result);
	}

	@Test
	public void 청1() {
		String token = "cjd1";

		LanguageConverter convert = new LanguageConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("청1", result);
	}

	@Test
	public void 청2() {
		String token = "CJD2";

		LanguageConverter convert = new LanguageConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("청2", result);
	}

	@Test
	public void 청3() {
		String token = "cJD3";

		LanguageConverter convert = new LanguageConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("청3", result);
	}

	@Test
	public void zdqdㅃㅉㄲ() {
		String token = "ㅋㅇㅂㅇQWR";

		LanguageConverter convert = new LanguageConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("zdqdㅃㅉㄲ", result);
	}
}