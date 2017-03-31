package com.github.mauricioaniche.testmetrics;

import com.github.mauricioaniche.ck.CK;

public class TestMetricFactory {

	public CK build() {
		return new CK()
				.plug(() -> new IsTest())
				.plug(() -> new JUnitAssertsCount())
				.plug(() -> new TestMethodsCount());
	}
}
