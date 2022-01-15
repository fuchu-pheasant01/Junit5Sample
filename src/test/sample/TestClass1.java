package test.sample;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TestClass1 {

	@Mock
	SampleClass sc;
	
	SampleClass sc2 = mock(SampleClass.class);
	
	@BeforeAll
	public static void beforeAll() {
	}
	@AfterAll
	public static void afterAll() {
	}
	@BeforeEach
	public void before() {
		
	}
	@AfterEach
	public void after() {
		
	}
	
	@Test
	@Cate1
	public void testMockDoReturn() {
		doReturn(500).when(sc).kingaku(1);
		assertEquals(500, sc.kingaku(1), () -> "��v���܂���ł���");
	}
	
	@Test
	@Cate1
	public void testMockWhen() {
		when(sc.kingaku(1)).thenReturn(500);
		assertTrue(500 == sc.kingaku(1), () -> "��v���܂���ł���");
	}
	
	@Test
	@Cate1
	public void testMockFalse() {
		doReturn(500).when(sc).kingaku(1);
		assertFalse(400 == sc.kingaku(1));
		assertFalse(500 == sc.kingaku(1));
	}
	
	@Test
	@Cate1
	public void testMockNull() {
		String str = null;
		assertNull(str);
		assertNotNull(str);
	}
	
	@Test
	@Cate1
	@DisplayName("RuntimeException�����e�X�g")
	public void testMockThrows() {
		doThrow(RuntimeException.class).when(sc).kingaku(1);
		assertThrows(RuntimeException.class, () -> sc.kingaku(1));
	}
	
	@Test
	@Cate1
	@DisplayName("�e�X�g�P")
	void test() {
		var sc = new SampleClass();
		int kei = sc.kingaku(5);
		assertEquals(500, kei,() -> "��r�ł�");
	}

	@Test
	@Tag("category2")
	void test2() {
		System.out.println("�e�X�g�Q�����s���܂����B");
		var i = 2;
		assertTrue(2 == i,() -> "���b�Z�[�W");
	}
	
	@Test
	@Tag("category2")
	@Tag("category3")
	void kyotsuTest() {
		System.out.println("���ʃ��\�b�h�e�X�g");
		var i = 4;
		assertFalse(2 == i,"��r���܂�");
		String str = "d";//null;
		assertNull(str, () -> "�i���ł͂���܂���ł����B");
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void paramTest(int i) {
		assertEquals(3, i);
	}
	
	@Test
	@Tag("category2")
	public void mockTest() {
		//var sc = mock(SampleClass.class); //���S�Ȃ�mock�ŋ^���I�Ȍ��ʂ��쐬���Ă��Ȃ����̂̓f�[�^�^�̏����l�ƂȂ�B
		when(sc.kingaku(2)).thenReturn(400);
		System.out.println("kingaku(2)���\�b�h�����s������" + sc.kingaku(2) + "��Ԃ��܂��B");
		System.out.println("kingaku(1)���\�b�h�����s������" + sc.kingaku(1) + "���Ԃ�܂��B");
	}
	
	@Test
	@Tag("category2")
	public void spyTest() {
		var sc = spy(new SampleClass()); //when��doReturn�ŋ^���I�Ȍ��ʂ��쐬�������̂���mock���ꑼ��mock����Ȃ��B
		when(sc.kingaku(2)).thenReturn(400);
		System.out.println("kingaku(2)���\�b�h�����s������" + sc.kingaku(2) + "��Ԃ��܂��B");
		System.out.println("kingaku(1)���\�b�h�����s������" + sc.kingaku(1) + "���Ԃ�܂��B");
	}
}
