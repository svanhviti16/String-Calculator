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
  @Test
  public void testTenNumbers() {
    assertEquals(15, Calculator.add("2,2,2,2,2,1,1,1,1,1"));
  }
  @Test
  public void testNewLineDelim() {
    assertEquals(5, Calculator.add("2\n2,1"));
  }
  @Test
  public void testNewLineOnly() {
    assertEquals(4, Calculator.add("2\n2"));
  }
  @Test
  public void testDifferentDelimOrder() {
    assertEquals(12, Calculator.add("2,6,1\n1\n1,1"));
  }
}
