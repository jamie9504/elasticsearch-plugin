package org.elasticsearch.index.analysis.onlyeng2korjamo;

import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenFilterFactory;
import org.elasticsearch.index.analysis.onlykor2eng.JamieOnlyKor2EngConvertFilter;

public class JamieOnlyEng2KorJamoConvertFilterFactory extends AbstractTokenFilterFactory {
	public JamieOnlyEng2KorJamoConvertFilterFactory(
		IndexSettings indexSettings, Environment env, String name, Settings settings) {
		super(indexSettings, name, settings);
	}

	@Override
	public TokenStream create(TokenStream tokenStream) {
		return new JamieOnlyEng2KorJamoConvertFilter(tokenStream);
	}
}
