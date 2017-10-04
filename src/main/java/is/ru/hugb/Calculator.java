package is.ru.hugb;

import java.util.ArrayList;
import java.lang.StringBuilder;

public class Calculator {

  //adds the numbers of a given string
  public static int add(String text) throws IllegalArgumentException {
    if(text.equals("")) {
      return 0;
    }
    String numbers[] = text.split(",|\\n");

    StringBuilder result = new StringBuilder();
    for (String n : numbers) {
      if(toInt(n) < 1000) {
        if (toInt(n) < 0) {
          result.append(n + ", ");
        }
      }
    }
    if (result.length() != 0) {
      throwNegativeException(result);
    }
    //this works for 1 numbers and up
    return sum(numbers);
  }

  //returns the string as an integer
  private static int toInt(String text) {
    return Integer.parseInt(text);
  }

  //adds the numbers given to an array
  private static int sum(String[] numbers) {
    int total = 0;
    for (String n : numbers) {
      if(toInt(n) < 1000) {
        total += toInt(n);
      }
    }
    return total;
  }

  private static void throwNegativeException(StringBuilder result) throws IllegalArgumentException {
    result.deleteCharAt(result.length() - 2);
    throw new IllegalArgumentException("Negatives not allowed: " + result);
  }

}
