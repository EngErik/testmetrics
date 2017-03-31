package com.github.mauricioaniche.testmetrics;

import org.junit.Assert;
import org.junit.Test;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

public class JUnitAssertsCountTest extends BaseTest {

	@Test
	public void countNumberOfAsserts() {

		CKReport report = ck().calculate(fixturesDir() + "/t1");

		CKNumber a = report.getByClassName("t1.SomeTest");
		Assert.assertEquals(9, a.getSpecific("asserts"));

	}

	@Test
	public void countNumberOfAssertsInAllTestMethods() {
		
		CKReport report = ck().calculate(fixturesDir() + "/t2");
		
		CKNumber a = report.getByClassName("t2.SomeTest");
		Assert.assertEquals(9, a.getSpecific("asserts"));
	}

	@Test
	public void countFailAsAssert() {
		
		CKReport report = ck().calculate(fixturesDir() + "/t3");
		
		CKNumber a = report.getByClassName("t3.SomeTest");
		Assert.assertEquals(1, a.getSpecific("asserts"));
	}
	

	@Test
	public void shouldUnderstandStaticImportsOfAsserts() {

		CKReport report = ck().calculate(fixturesDir() + "/t4");

		CKNumber a = report.getByClassName("t4.SomeTest");
		Assert.assertEquals(9, a.getSpecific("asserts"));

	}

	@Test
	public void ignoreNonTestFile() {
		
		CKReport report = ck().calculate(fixturesDir() + "/t5");
		
		CKNumber a = report.getByClassName("t5.Anything");
		Assert.assertEquals(0, a.getSpecific("asserts"));
		
	}

}
