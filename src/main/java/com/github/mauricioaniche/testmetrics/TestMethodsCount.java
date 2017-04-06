package com.github.mauricioaniche.testmetrics;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Annotation;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MarkerAnnotation;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;
import com.github.mauricioaniche.ck.metric.Metric;

public class TestMethodsCount extends ASTVisitor implements Metric {

	private int totalNumberOfTestMethods;
	
	public boolean visit(MarkerAnnotation node) {
		checkAnnotation(node);
		return super.visit(node);	
	}

	public boolean visit(NormalAnnotation node) {
		checkAnnotation(node);
		return super.visit(node);	
	}

	public boolean visit(SingleMemberAnnotation node) {
		checkAnnotation(node);
		return super.visit(node);	
	}
	
	public boolean visit(MethodDeclaration node) {
		
		boolean startsWithTest = node.getName().toString().startsWith("test");
		// boolean fifthLetterIsCapitalized = node.getName().toString().length() > 4 && Character.isUpperCase(node.getName().toString().charAt(4));
		if(startsWithTest) {
			totalNumberOfTestMethods++;
			return false;
		}
		
		return super.visit(node);
	}
	
	private void checkAnnotation(Annotation o) {
		String annotation = o.getTypeName().toString();
		if(annotation.equals("Test")) {
			totalNumberOfTestMethods++;
		}
	}
	
	@Override
	public void execute(CompilationUnit cu, CKNumber result, CKReport report) {
		if(result.getSpecific("isTest") == 1) {
			cu.accept(this);
		}
	}

	@Override
	public void setResult(CKNumber result) {
		result.addSpecific("test-methods", totalNumberOfTestMethods);		
	}

}
