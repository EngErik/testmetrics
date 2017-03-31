package t1;

import org.junit.Assert;
import org.junit.Test;

class SomeTest {
	
	@Test
	public void test1() {
		int a = 1;
		int b = 2;

		a = a + 2;

		Assert.assertEquals(2, a);
		Assert.assertFalse(false);
		Assert.assertNotEquals(2, a);
		Assert.assertNotNull(a);
		Assert.assertNotSame(a,b);
		Assert.assertNull(a);
		Assert.assertSame(a,b);
		Assert.assertThat(a == 1);
		Assert.assertFalse(true);
	}


}