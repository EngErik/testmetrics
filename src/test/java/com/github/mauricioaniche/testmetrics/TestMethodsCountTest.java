package com.github.mauricioaniche.testmetrics;

import org.junit.Assert;
import org.junit.Test;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

public class TestMethodsCountTest extends BaseTest {

	@Test
	public void countNumberOfMethodsWithTestAnnotation() {

		CKReport report = ck().calculate(fixturesDir() + "/t6");

		CKNumber a = report.getByClassName("t6.SomeTest");
		Assert.assertEquals(2, a.getSpecific("test-methods"));

	}

	@Test
	public void understandParametersInTestAnnotation() {
		
		CKReport report = ck().calculate(fixturesDir() + "/t7");
		
		CKNumber a = report.getByClassName("t7.SomeTest");
		Assert.assertEquals(1, a.getSpecific("test-methods"));
		
	}
	
	@Test
	public void ignoreNonTestFile() {
		
		CKReport report = ck().calculate(fixturesDir() + "/t5");
		
		CKNumber a = report.getByClassName("t5.Anything");
		Assert.assertEquals(0, a.getSpecific("test-methods"));
		
	}

}
