package is.ru.hugb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class CalculatorTest {
  @Test
  public void testEmptyString() throws IllegalArgumentException {
    assertEquals(0, Calculator.add(""));
  }
  @Test
  public void testOneNumber() throws IllegalArgumentException {
    assertEquals(77, Calculator.add("77"));
  }
  @Test
  public void testTwoNumbers() throws IllegalArgumentException {
    assertEquals(5, Calculator.add("2,3"));
  }
  @Test
  public void testMoreNumbers()  throws IllegalArgumentException {
    assertEquals(5, Calculator.add("2,2,1"));
  }
  @Test
  public void testTenNumbers() throws IllegalArgumentException {
    assertEquals(15, Calculator.add("2,2,2,2,2,1,1,1,1,1"));
  }
  @Test
  public void testNewLineDelim() throws IllegalArgumentException {
    assertEquals(5, Calculator.add("2\n2,1"));
  }
  @Test
  public void testNewLineOnly() throws IllegalArgumentException {
    assertEquals(4, Calculator.add("2\n2"));
  }
  @Test
  public void testDifferentDelimOrder() throws IllegalArgumentException {
    assertEquals(12, Calculator.add("2,6,1\n1\n1,1"));
  }
  @Test()
  public void testNegativeNum() {
    boolean thrown = false;
    try {
      Calculator.add("-1");
    }
    catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      thrown = true;
    }
    assertTrue(thrown);
  }
}
