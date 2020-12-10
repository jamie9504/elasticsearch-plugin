package org.apache.solr.index.analysis.jamo;

import java.util.Map;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.util.TokenFilterFactory;
import org.elasticsearch.index.analysis.jamo.JavacafeJamoTokenFilter;

public class JavacafeJamoTokenFilterFactory extends TokenFilterFactory {

	public JavacafeJamoTokenFilterFactory(Map<String, String> args) {
		super(args);
	}

	@Override
	public TokenStream create(TokenStream stream) {
		return new JavacafeJamoTokenFilter(stream);
	}

}
