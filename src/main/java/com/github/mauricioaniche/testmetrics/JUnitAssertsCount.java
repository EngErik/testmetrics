package com.github.mauricioaniche.testmetrics;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodInvocation;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;
import com.github.mauricioaniche.ck.metric.Metric;

public class JUnitAssertsCount extends ASTVisitor implements Metric {

	private int totalNumberOfAsserts;
	
	public boolean visit(MethodInvocation node) {
		
		if(node.getName()==null) return true;
		
		String methodName = node.getName().toString();
		
		if((ClassUtils.isAssertMethod(methodName) || ClassUtils.isFailMethod(methodName)))
			totalNumberOfAsserts++;
		
		return true;
	}
	
	@Override
	public void execute(CompilationUnit cu, CKNumber result, CKReport report) {
		
		if(result.getSpecific("isTest") == 1) {
			cu.accept(this);
		}
	}

	@Override
	public void setResult(CKNumber result) {
		result.addSpecific("asserts", totalNumberOfAsserts);
	}

}
