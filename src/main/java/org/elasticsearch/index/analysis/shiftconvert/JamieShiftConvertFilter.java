package org.elasticsearch.index.analysis.shiftconvert;

import java.io.IOException;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.elasticsearch.index.common.converter.LanguageConverter;
import org.elasticsearch.index.common.converter.ShiftConverter;

public class JamieShiftConvertFilter extends TokenFilter {
	private final ShiftConverter converter;
	private final CharTermAttribute termAtt;

	public JamieShiftConvertFilter(TokenStream stream) {
		super(stream);
		this.converter = new ShiftConverter();
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