package is.ru.hugb;

import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Calculator {

  //adds the numbers of a given string and returns the sum
  public static int add(String text) throws IllegalArgumentException {
    if(text.equals("")) {
      return 0;
    }
    String delim = ",|\\n";

    if (text.startsWith("//")) {
      delim = text.substring(2, text.indexOf("\n"));
      //escaping a possible regex character
      delim = Pattern.quote(delim);
      text = text.substring(text.indexOf("\n")+1);
    }
    String numbers[] = text.split(delim);

    checkNegatives(numbers);

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
      //numbers over 1000 are ignored
      if(toInt(n) < 1000) {
        total += toInt(n);
      }
    }
    return total;
  }

  private static void checkNegatives(String[] numbersArr) throws IllegalArgumentException {
    StringBuilder negativeNumbers = new StringBuilder();
    for (String n : numbersArr) {
      if (toInt(n) < 0) {
        negativeNumbers.append(n + ", ");
      }
    }
    if (negativeNumbers.length() != 0) {
      negativeNumbers.deleteCharAt(negativeNumbers.length() - 2);
      throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers);
    }
  }
}
