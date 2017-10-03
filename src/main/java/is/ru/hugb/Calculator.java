package is.ru.hugb;

public class Calculator {

  //adds the numbers of a given string
  public static int add(String text) {
    if(text.equals("")) {
      return 0;
    }
    else if(text.contains(",") || text.contains("\n")) {
      String numbers[] = text.split(",|\\n");
      return sum(numbers);
    }
    else {
      return toInt(text);
    }
  }

  //returns the string as an integer
  private static int toInt(String text) {
    return Integer.parseInt(text);
  }

  //adds the numbers given to an array
  private static int sum(String[] numbers) {
    int total = 0;
    for (String n : numbers) {
      total += toInt(n);
    }
    return total;
  }
}
