package org.elasticsearch.plugin.utilTest;

import static org.junit.Assert.*;

import org.elasticsearch.index.common.converter.ShiftConverter;
import org.junit.Test;

public class ShiftConverterTest {

	@Test
	public void rNrN() {
		String token = "RnRn";

		ShiftConverter convert = new ShiftConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("rNrN", result);
	}

	@Test
	public void ㄱㄴㄷㄹㅁㅂㅏㅑㅒㅖㅐㅔ() {
		String token = "ㄲㄴㄸㄹㅁㅃㅏㅑㅐㅔㅒㅖ";

		ShiftConverter convert = new ShiftConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("ㄱㄴㄷㄹㅁㅂㅏㅑㅒㅖㅐㅔ", result);
	}

	@Test
	public void RrRrㄱㄴㄷㄹㅁㅂㅏㅑㅒㅖㅐㅔPpPp() {
		String token = "rRrRㄲㄴㄸㄹㅁㅃㅏㅑㅐㅔㅒㅖpPpP";

		ShiftConverter convert = new ShiftConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("RrRrㄱㄴㄷㄹㅁㅂㅏㅑㅒㅖㅐㅔPpPp", result);
	}

	@Test
	public void RrRrㄱ한국ㄴㄷㄹㅁㅂㅏㅑㅒㅖㅐㅔPpPp() {
		String token = "rRrRㄲ한국./ㄴㄸㄹㅁㅃㅏㅑㅐㅔㅒㅖpPpP";

		ShiftConverter convert = new ShiftConverter();
		String result = convert.convert(token);

		System.out.println(result);
		assertEquals("RrRrㄱ한국./ㄴㄷㄹㅁㅂㅏㅑㅒㅖㅐㅔPpPp", result);
	}
}