package regex;

public class Regex {
  final static String regularExpression = "^(.).*\\1$";

  public static void main(String[] args) {
    System.out.println("a".matches(regularExpression));
  }

}
