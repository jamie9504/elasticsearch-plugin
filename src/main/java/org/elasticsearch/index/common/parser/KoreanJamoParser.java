package org.elasticsearch.index.common.parser;

import java.util.Objects;

import org.elasticsearch.index.common.util.JamoUtil;

/**
 * 한글 자모 Parser
 *
 * @author hrkim
 *
 */
public class KoreanJamoParser extends AbstractKoreanParser {

	@Override
	protected void processForKoreanChar(StringBuilder sb, char chosung, char jungsung, char jongsung) {
		sb.append(chosung);

		char[] jungsungs = JamoUtil.UNICODE_DOUBLE_JUNG_SUNG_MAPPER.get(jungsung);
		if (Objects.isNull(jungsungs)) {
			sb.append(jungsung);
		} else {
			sb.append(jungsungs[0]);
			sb.append(jungsungs[1]);
		}

		if (jongsung == JamoUtil.UNICODE_JONG_SUNG_EMPTY) {
			return;
		}

		char[] jongsungs = JamoUtil.UNICODE_DOUBLE_JONG_SUNG_MAPPER.get(jongsung);
		if (Objects.isNull(jongsungs)) {
			sb.append(jongsung);
		} else {
			sb.append(jongsungs[0]);
			sb.append(jongsungs[1]);
		}
	}

	@Override
	protected void processForOther(StringBuilder sb, char eachToken) {
		sb.append(eachToken);
	}

}


