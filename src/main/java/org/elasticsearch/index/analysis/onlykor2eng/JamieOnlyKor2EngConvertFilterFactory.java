package org.elasticsearch.index.analysis.onlykor2eng;

import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenFilterFactory;

public class JamieOnlyKor2EngConvertFilterFactory extends AbstractTokenFilterFactory {
	public JamieOnlyKor2EngConvertFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
		super(indexSettings, name, settings);
	}

	@Override
	public TokenStream create(TokenStream tokenStream) {
		return new JamieOnlyKor2EngConvertFilter(tokenStream);
	}
}
