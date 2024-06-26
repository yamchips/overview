package overview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Basics {

  public static void main(String[] args) {
    // stream
    ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    Stream<Integer> numStream = numbers.stream();
    
    
    
    // array copy
    int[] array1 = {2};
    int[] res = Arrays.copyOfRange(array1, 1, 1);
    System.out.println(Arrays.toString(res));
    
    // int calculation, only returns the integer part
    System.out.println(9/2);
    
    // x ? a : b
    int x = -100;
    int y = x > 0 ? x : -x;
    System.out.println(y);
    
    // text block using """
    String s = """
        SELECT * FROM 
        users
        WHERE id > 100""";
    System.out.println(s);
    
    // array in java
    int[] nums1 = new int[5];
    int[] nums2 = {1, 2, 3, 4, 5};
    int a = nums2.length;
    System.out.println(Arrays.toString(nums2));
    
    // output, println means print something then change a line
    System.out.print("A,");
    System.out.print("B,");
    System.out.print("C.");
    System.out.println();
    System.out.println("END");
    System.out.print("dd\n");
    
    // printf, print using certain format
    double d = 3.1415926;
    System.out.printf("%.2f\n", d);
    System.out.printf("%.3e\n", d);
    
    // printf can combine multiple data types
    String name = "Alice";
    int age = 30;
    double height = 5.7;
    System.out.printf("%s is %d years old and %.1f feet tall.\n", name, age, height);

    // printf can achieve alignment and padding
    int number = 123;
    System.out.printf("%5d\n", number);  // Output: "  123" (right-aligned within 5 spaces)
    System.out.printf("%-5d\n", number); // Output: "123  " (left-aligned within 5 spaces)
    System.out.printf("%05d\n", number); // Output: "00123"
    int num1 = 5, num2 = 123, num3 = 12345;
    System.out.printf("%-10d %-10d %-10d\n", num1, num2, num3);
    
    // input
//    Scanner scanner = new Scanner(System.in);
//    System.out.print("Input your name:");
//    String inputName = scanner.nextLine();
//    System.out.print("Input your age:");
//    int inputAge = scanner.nextInt();
//    System.out.printf("Hi, %s, you are %d years old \n", inputName, inputAge);
//    scanner.close();
    
    
    // switch, if one case is using {}, then we don't need ;
    // we use yield to return value
    String fruit = "apple";
    int opt = switch (fruit) {
      case "apple" -> 1;
      case "pear", "mango" -> 2;
      default -> {
        int code = fruit.hashCode();
        yield code;
      }
    };
    
    // for each loop can iterate any iterable data type
    int[] nums = {6,1,2,3,4,5};
    for (int num : nums) {
      System.out.println(num);
    }
    // Arrays.sort changes array in place
    System.out.println(Arrays.toString(nums));
    Arrays.sort(nums);
    System.out.println(Arrays.toString(nums));
    
    // 2-dimension array, use deepToString to print out
    int[][] ns = {
        { 1, 2, 3, 4 },
        { 5, 6, 7, 8 },
        { 9, 10, 11, 12 }
    };
    System.out.println(Arrays.deepToString(ns));
    
    String str = "apple";
    char[] strArray = str.toCharArray();
    System.out.println(strArray);
    
    
  }
  

}
