package com.github.mauricioaniche.testmetrics;

import java.io.File;
import java.io.IOException;

import com.github.mauricioaniche.ck.CK;

public class BaseTest {

	protected CK ck() {
		return new TestMetricFactory().build();
	}
	
	protected static String fixturesDir() {
		try {
			String cfgFile = new File(BaseTest.class.getResource("/").getPath() + "../../fixtures/").getCanonicalPath();
			System.out.println(cfgFile);
			return cfgFile;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
