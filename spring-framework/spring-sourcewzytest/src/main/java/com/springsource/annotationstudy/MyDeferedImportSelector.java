package com.springsource.annotationstudy;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.Predicate;

public class MyDeferedImportSelector implements DeferredImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[0];
	}

	@Override
	public Predicate<String> getExclusionFilter() {
		return null;
	}

	@Override
	public Class<? extends Group> getImportGroup() {
		return null;
	}
}
