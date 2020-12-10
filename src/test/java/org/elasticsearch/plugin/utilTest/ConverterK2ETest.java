package org.elasticsearch.plugin.utilTest;

import static org.junit.Assert.*;

import org.elasticsearch.index.common.converter.KorToEngConverter;
import org.junit.Test;

public class ConverterK2ETest {

	@Test
	public void javacafe() {
		String token = "ㅓㅁㅍㅁㅊㅁㄹㄷ";

		KorToEngConverter convert = new KorToEngConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("javacafe", result);
	}

	@Test
	public void iphone() {
		String token = "ㅑㅔㅗㅐㅜㄷ";

		KorToEngConverter convert = new KorToEngConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("iphone", result);
	}

	@Test
	public void woman() {
		String token = "재ㅡ무";

		KorToEngConverter convert = new KorToEngConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("woman", result);
	}

	@Test
	public void samsung() {
		String token = "ㄴ므녀ㅜㅎ";

		KorToEngConverter convert = new KorToEngConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("samsung", result);
	}

	@Test
	public void samsung1() {
		String token = "ㄴ므녀ㅜㅎ1";

		KorToEngConverter convert = new KorToEngConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("samsung1", result);
	}

	@Test
	public void aorqnr() {
		String token = "맥북";

		KorToEngConverter convert = new KorToEngConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("aorqnr", result);
	}

	@Test
	public void applegood() {
		String token = "apple해ㅐㅇ";

		KorToEngConverter convert = new KorToEngConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("applegood", result);
	}

	@Test
	public void bananagood() {
		String token = "ㅠ무뭄good";

		KorToEngConverter convert = new KorToEngConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("bananagood", result);
	}

	@Test
	public void candygood() {
		String token = "can요해od";

		KorToEngConverter convert = new KorToEngConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("candygood", result);
	}

	@Test
	public void dessertgood() {
		String token = "ㅇㄷㄴㄴㄷㄱㅅ해ㅐㅇ";

		KorToEngConverter convert = new KorToEngConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("dessertgood", result);
	}

	@Test
	public void egggood() {
		String token = "ㄷㅎㅎㅎㅐㅐㅇ";

		KorToEngConverter convert = new KorToEngConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("egggood", result);
	}
}
