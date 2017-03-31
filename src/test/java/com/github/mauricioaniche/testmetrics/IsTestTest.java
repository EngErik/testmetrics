package com.github.mauricioaniche.testmetrics;

import org.junit.Assert;
import org.junit.Test;

import com.github.mauricioaniche.ck.CKNumber;
import com.github.mauricioaniche.ck.CKReport;

public class IsTestTest extends BaseTest {

	@Test
	public void findsTestClasses() {

		CKReport report = ck().calculate(fixturesDir() + "/t1");

		CKNumber a = report.getByClassName("t1.SomeTest");
		Assert.assertEquals(1, a.getSpecific("isTest"));

	}


	@Test
	public void ignoreNonTestFile() {
		
		CKReport report = ck().calculate(fixturesDir() + "/t5");
		
		CKNumber a = report.getByClassName("t5.Anything");
		Assert.assertEquals(0, a.getSpecific("isTest"));
		
	}

}
