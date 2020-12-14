package org.elasticsearch.index.analysis.shiftconvert;

import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenFilterFactory;
import org.elasticsearch.index.analysis.krenconvert.JamieKrEnConvertFilter;

public class JamieShiftConvertFilterFactory  extends AbstractTokenFilterFactory {
	public JamieShiftConvertFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
		super(indexSettings, name, settings);
	}

	@Override
	public TokenStream create(TokenStream tokenStream) {
		return new JamieShiftConvertFilter(tokenStream);
	}
}