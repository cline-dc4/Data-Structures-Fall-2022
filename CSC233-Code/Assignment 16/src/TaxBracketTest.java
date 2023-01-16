import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaxBracketTest {

	@Test
	void test() 
	{
		TaxBracketFun testTax = new TaxBracketFun();
		assertTrue(testTax.getRate('s', 5295) == 10); //single, < 9950
		assertTrue(testTax.getRate('m', 19000) == 10); // married, < 19900
		assertTrue(testTax.getRate('h', 10920) == 10); // head, < 14200

		assertTrue(testTax.getRate('s', 30923) == 12); //single, > 9951 && < 40525
		assertTrue(testTax.getRate('m', 79304) == 12); //married, > 19901 && < 81050
		assertTrue(testTax.getRate('h', 49023) == 12); //head, > 14201 && < 54350
		
		assertTrue(testTax.getRate('s', 84312) == 22); //single, > 40526 && < 86375
		assertTrue(testTax.getRate('m', 159203) == 22); //married, > 81051 && < 172750
		assertTrue(testTax.getRate('h', 84203) == 22); //head, > 54201 && < 86350
		
		assertTrue(testTax.getRate('s', 153209) == 24); //single, > 86376 && < 164925
		assertTrue(testTax.getRate('m', 293840) == 24); //married, > 172751 && < 329850
		assertTrue(testTax.getRate('h', 149283) == 24); //head, > 86351 && < 164900

		assertTrue(testTax.getRate('s', 182039) == 32); //single, > 164926 && < 209425
		assertTrue(testTax.getRate('m', 399999) == 32); //married, > 329851 && < 418850
		assertTrue(testTax.getRate('h', 180293) == 32); //head, > 164901 && < 209400
		
		assertTrue(testTax.getRate('s', 408392) == 35); //single, > 209426 && < 523600
		assertTrue(testTax.getRate('m', 509394) == 35); //married, > 418851 && < 628300
		assertTrue(testTax.getRate('h', 408392) == 35); //head, > 209401 && < 523600
		
		assertTrue(testTax.getRate('s', 1029032) == 37); //single, > 523601
		assertTrue(testTax.getRate('m', 1023948) == 37); //married, > 628301
		assertTrue(testTax.getRate('h', 1029384) == 37); //head, > 523601
		
		
	}

}
