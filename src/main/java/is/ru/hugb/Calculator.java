package is.ru.hugb;

public class Calculator {

  //adds the numbers of a given string
  public static int add(String text) {
    if(text.equals("")) {
      return 0;
    }
    else if(text.contains(",")) {
      String numbers[] = text.split(",");
      return sum(numbers);
    }
    return 1;
  }

  //returns the string as an integer
  private static int parse(String text) {
    return Integer.parseInt(text);
  }

  //adds the numbers given to an array
  private static int sum(String[] numbers) {
    int total = 0;
    for (String n : numbers) {
      total += parse(n);
    }
    return total;
  }
}
