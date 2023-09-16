/* ©2017-2020 Elder Research, Inc. All rights reserved. */
package com.compassion.commons.jackson;

import java.io.IOException;
import java.io.Writer;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.DumperOptions.LineBreak;
import org.yaml.snakeyaml.DumperOptions.Version;

import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;

import lombok.AllArgsConstructor;
import lombok.val;

/**
 * Custom classes that override the default line break behavior and allow it to be customized. Ideally, this wouldn't
 * require our own subclasses/hacking, but I don't see a way of setting the line breaks in a more general way.
 * 
 * @author <a href="mailto:dimeo@elderresearch.com">John Dimeo</a>
 * @since Nov 14, 2017
 */
@AllArgsConstructor
class YAMLFactoryCustom extends YAMLFactory {
	private LineBreak lineBreak;
	
	@Override
	protected YAMLGenerator _createGenerator(Writer out, IOContext ctxt) throws IOException {
		return new YAMLGeneratorCustom(ctxt, _generatorFeatures, _yamlGeneratorFeatures, _objectCodec, out, _version);
	}
	
	private class YAMLGeneratorCustom extends YAMLGenerator {
		YAMLGeneratorCustom(IOContext ctxt, int jsonFeatures, int yamlFeatures, ObjectCodec codec, Writer out, Version version) throws IOException {
			super(ctxt, jsonFeatures, yamlFeatures, null, codec, out, version);
		}
		
		@Override
		protected DumperOptions buildDumperOptions(int jsonFeatures, int yamlFeatures, Version version) {
			val ret = super.buildDumperOptions(jsonFeatures, yamlFeatures, version);
			ret.setLineBreak(lineBreak);
			return ret;
		}
	}
}
