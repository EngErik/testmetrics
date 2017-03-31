package com.github.mauricioaniche.testmetrics;

import com.github.mauricioaniche.ck.CK;
import com.github.mauricioaniche.ck.CKReport;

public class Runner {

	public static void main(String[] args) {
		
		String path = "/Users/mauricioaniche/Documents/untestable/commons-collections";
		
		CKReport report = buildCK()
				.calculate(path);
	}

	private static CK buildCK() {
		return new TestMetricFactory().build();
	}
}
