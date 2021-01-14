package org.elasticsearch.index.analysis.onlyeng2korjamo;

import java.io.IOException;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.elasticsearch.index.common.converter.OnlyEng2KorJamoConverter;

public class JamieOnlyEng2KorJamoConvertFilter extends TokenFilter {
	private final OnlyEng2KorJamoConverter converter;
	private final CharTermAttribute termAtt;

	public JamieOnlyEng2KorJamoConvertFilter(TokenStream stream) {
		super(stream);
		this.converter = new OnlyEng2KorJamoConverter();
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
