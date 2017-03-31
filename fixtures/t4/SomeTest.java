package t4;

import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

class SomeTest {
	
	@Test
	public void test1() {
		int a = 1;
		int b = 2;

		a = a + 2;

		assertEquals(2, a);
		Assert.assertFalse(false);
		Assert.assertNotEquals(2, a);
		Assert.assertNotNull(a);
		Assert.assertNotSame(a,b);
		Assert.assertNull(a);
	}

	@Test
	public void test2() {
		int a = 1;
		int b = 2;

		a = a + 2;
		
		Assert.assertSame(a,b);
		Assert.assertThat(a == 1);
		assertFalse(true);
	}


}