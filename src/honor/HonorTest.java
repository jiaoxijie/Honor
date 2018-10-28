package honor;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;
import org.junit.jupiter.api.Test;

class HonorTest {
	
	@Test
	void test_Mp() {
		typeone A = new typeone();
		A.skill(1, 's');
		assertEquals(90,A.ret_Mp());
	}
	
	@Test
	void test_Hp() {
		typeone A = new typeone();
		A.skill(1, 's');
		assertEquals(100,A.ret_Hp());
	}
	
	@Test
	void test_Boundary() {
		Random rand = new Random();
		typeone A = new typeone();
		int i, j;
		char c;
		for(i = 0; i < 10; i++)
		{
			c = (char)(rand.nextInt(10)+64);
			A.skill(i+1, 's');
			assertEquals(true,(A.ret_x() < 20));
			assertEquals(true,(A.ret_y() < 20));
		}
	}

}
