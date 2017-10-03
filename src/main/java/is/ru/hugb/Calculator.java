package is.ru.hugb;

public class Calculator {

  //adds the numbers of a given string
  public static int add(String text) throws IllegalArgumentException {
    if(text.equals("")) {
      return 0;
    }
    //else if(text.contains(",") || text.contains("\n")) {
    String numbers[] = text.split(",|\\n");

    for (String n : numbers) {
      if (toInt(n) < 0) {

        throw new IllegalArgumentException("Negatives not allowed: " + n);
      }
    }

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
      total += toInt(n);
    }
    return total;
  }
}
