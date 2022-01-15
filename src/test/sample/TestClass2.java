package test.sample;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TestClass2 {

	@Spy
	SampleClass sc;
	
	private SampleClass sc2 = spy(new SampleClass());
	static final String ca = "category2";
	
	@Test
	@Tag(ca)
	public void testSpyDoReturen() {
		doReturn(500).when(sc).kingaku(1);
		assertEquals(500, sc.kingaku(1));
	}

	@Test
	@Tag(ca)
	public void testSpyWhen() {
		when(sc.kingaku(1)).thenReturn(500);
		assertTrue(500 == sc.kingaku(1));
	}
	
	@Test
	@Tag(ca)
	public void testSpyFalse() {
		doReturn(500).when(sc).kingaku(1);
		assertFalse(400 == sc.kingaku(1));
		assertFalse(500 == sc.kingaku(1));
	}
	
	@Test
	@Tag(ca)
	public void testSpyNull() {
		String str = null;
		assertNull(str);
		assertNotNull(str);
	}
	
	@Test
	@Tag(ca)
	@DisplayName("RuntimeException”­¶ƒeƒXƒg")
	public void testMockThrows() {
		doThrow(RuntimeException.class).when(sc).kingaku(1);
		assertThrows(RuntimeException.class, () -> sc.kingaku(1));
	}
}
