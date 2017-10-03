package is.ru.hugb;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {
  @Test
  public void testEmptyString() {
    assertEquals(0, Calculator.add(""));
  }
  @Test
  public void testOneNumber() {
    assertEquals(1, Calculator.add("5"));
  }
  /*@Test
  public void testTwoNumbers() {
    assertEquals(5, Calculator.add("2,3"));
  }*/
}
