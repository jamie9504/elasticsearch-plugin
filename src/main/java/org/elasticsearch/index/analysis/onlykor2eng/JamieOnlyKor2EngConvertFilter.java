package org.elasticsearch.index.analysis.onlykor2eng;

import java.io.IOException;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.elasticsearch.index.common.converter.OnlyKor2EngConverter;

/**
 * 한영 상호 변환 필터
 *
 * @author jamie
 *
 */
public class JamieOnlyKor2EngConvertFilter extends TokenFilter {
	private final OnlyKor2EngConverter converter;
	private final CharTermAttribute termAtt;

	public JamieOnlyKor2EngConvertFilter(TokenStream stream) {
		super(stream);
		this.converter = new OnlyKor2EngConverter();
		this.termAtt = addAttribute(CharTermAttribute.class);
	}

	@Override
	public boolean incrementToken() throws IOException {
		if (input.incrementToken()) {
			CharSequence parserdData = converter.convert(termAtt.toString());
			termAtt.setEmpty();
			termAtt.append(parserdData);
			return true;
		}
		return false;
	}
}
