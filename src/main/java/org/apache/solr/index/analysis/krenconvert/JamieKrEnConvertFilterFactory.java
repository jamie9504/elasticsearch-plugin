package org.apache.solr.index.analysis.krenconvert;

import java.util.Map;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.util.TokenFilterFactory;
import org.elasticsearch.index.analysis.krenconvert.JamieKrEnConvertFilter;

public class JamieKrEnConvertFilterFactory extends TokenFilterFactory {

	public JamieKrEnConvertFilterFactory(Map<String, String> args) {
		super(args);
	}

	@Override
	public TokenStream create(TokenStream tokenStream) {
		return new JamieKrEnConvertFilter(tokenStream);
	}
}