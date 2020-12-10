package org.elasticsearch.index.analysis.krenconvert;

import java.io.IOException;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.elasticsearch.index.common.converter.LanguageConverter;

/**
 * 한영 상호 변환 필터
 *
 * @author jamie
 *
 */
public class JamieKrEnConvertFilter extends TokenFilter {
	private final LanguageConverter converter;
	private final CharTermAttribute termAtt;

	public JamieKrEnConvertFilter(TokenStream stream) {
		super(stream);
		this.converter = new LanguageConverter();
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
