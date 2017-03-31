package com.github.mauricioaniche.testmetrics;

import org.eclipse.jdt.core.dom.CompilationUnit;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;
import com.github.mauricioaniche.ck.metric.Metric;

public class IsTest implements Metric {

	private String currentClass;

	@Override
	public void execute(CompilationUnit cu, CKNumber result, CKReport report) {
		this.currentClass = ClassUtils.extractClassName(result.getClassName());
	}

	@Override
	public void setResult(CKNumber result) {
		result.addSpecific("isTest", ClassUtils.isTest(currentClass) ? 1 : 0);
	}

}
