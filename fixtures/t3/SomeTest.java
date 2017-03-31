package t3;

import org.junit.Assert;
import org.junit.Test;

class SomeTest {
	
	@Test
	public void test1() {
		int a = 1;
		int b = 2;

		a = a + 2;

		Assert.fail();
	}



}