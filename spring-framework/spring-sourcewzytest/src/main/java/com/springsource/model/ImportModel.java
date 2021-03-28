package com.springsource.model;

import org.springframework.context.annotation.Import;

@Import(value={ComponentModel.class,ServiceModel.class})
public class ImportModel {
}
