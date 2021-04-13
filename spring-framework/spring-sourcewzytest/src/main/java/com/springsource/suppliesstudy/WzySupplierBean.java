package com.springsource.suppliesstudy;

import java.util.function.Supplier;

public class WzySupplierBean {
	public  static Person get() {
		return new Person("mysupplierPerson");
	}
}
