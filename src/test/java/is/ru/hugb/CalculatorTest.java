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
  @Test()
  public void testMultipleNegativeNum() {
    boolean thrown = false;
    try {
      Calculator.add("-2,-2,-2");
    }
    catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      thrown = true;
    }
    assertTrue(thrown);
  }
  @Test()
  public void testBothPosAndNeg() {
    boolean thrown = false;
    try {
      Calculator.add("-2,2,-2,4");
    }
    catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      thrown = true;
    }
    assertTrue(thrown);
  }
  @Test
  public void testOverThousand() throws IllegalArgumentException {
    assertEquals(0, Calculator.add("2000"));
  }
  @Test
  public void testOverThousandAndLegalNumber() throws IllegalArgumentException {
    assertEquals(1, Calculator.add("1,2000"));
  }
  @Test
  public void testMultipleOverThousand() throws IllegalArgumentException {
    assertEquals(0, Calculator.add("1337,4444,2000"));
  }
  @Test
  public void testCustomDelim() throws IllegalArgumentException {
    assertEquals(5, Calculator.add("//;\n2;3"));
  }
  @Test
  public void testAnotherDelim() throws IllegalArgumentException {
    assertEquals(120, Calculator.add("//&\n90&30"));
  }
  @Test
  public void testPipeAsDelim() throws IllegalArgumentException {
    assertEquals(120, Calculator.add("//|\n90|30"));
  }
  @Test
  public void testPeriodAsDelim() throws IllegalArgumentException {
    assertEquals(120, Calculator.add("//.\n90.30"));
  }
  @Test
  public void testTwoSymbolsAsDelim() throws IllegalArgumentException {
    assertEquals(120, Calculator.add("//..\n90..30"));
  }
  @Test
  public void testThreeSymbolsAsDelim() throws IllegalArgumentException {
    assertEquals(120, Calculator.add("//!!!\n90!!!30"));
  }
}
