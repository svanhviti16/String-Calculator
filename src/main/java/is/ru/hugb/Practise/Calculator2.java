package is.ru.hugb;

import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Calculator2 {
  public static int add(String text) throws IllegalArgumentException {
    if (text == "") {
      return 0;
    }
    String delim = ",|\\n";
    if (text.startsWith("//")) {
      delim = text.substring(2,3);
      delim = Pattern.quote(delim);
      text = text.substring(4);
    }
    String[] numbers = text.split(delim);
    checkNegatives(numbers);
    return sum(numbers);
  }

  public static int sum(String[] numbers) {
    int total = 0;
    for (String n : numbers) {
      if(toInt(n) < 1000) {
        total += toInt(n);
      }
    }
    return total;
  }
  public static int toInt(String num) {
    return Integer.parseInt(num);
  }

  private static void checkNegatives(String[] numbers) throws IllegalArgumentException {
    StringBuilder negatives = new StringBuilder();
    for (String n : numbers) {
      if(toInt(n) < 0) {
        negatives.append(toInt(n) + " ");
      }
    }
    if(negatives.length() != 0) {
      throw new IllegalArgumentException("Negatives not allowed: " + negatives);
    }
  }
}
