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
    assertEquals(77, Calculator.add("77"));
  }
  @Test
  public void testTwoNumbers() {
    assertEquals(5, Calculator.add("2,3"));
  }
  @Test
  public void testMoreNumbers() {
    assertEquals(5, Calculator.add("2,2,1"));
  }
}
