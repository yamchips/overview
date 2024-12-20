package overview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Basics {
  
  public static void main(String[] args) {
    // variable
    int[] numsArray = new int[] {1, 2, 3, 4};
//    int[] tempNums = numsArray;
    numsArray[0] = 9;
//    System.out.println(Arrays.toString(tempNums));
    
    //Arrays.sort(numsArray, Collections.reverseOrder());
    
    
    String temp = "abcdefg";
    System.out.println(temp.substring(0, 0));
    
    System.out.println('A' - 'a');
    
    // lambda expression
    List<String> list = Arrays.asList("apple", "banana", "cherry");

    // Using lambda expression to print each element
    Consumer<String> exp1 = (s) -> System.out.println("test");
    list.forEach(exp1);

    // Using lambda expression with a custom functional interface
    Consumer<String> print = (s) -> System.out.println("Fruit: " + s);
    list.forEach(print);
    
    // stream, eg: get the sum of an ArrayList
    ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    numbers.remove(Integer.valueOf(2));
    // in separate ways:
    Stream<Integer> numStream = numbers.stream();
    IntStream intStream = numStream.mapToInt(i -> i.intValue());
    int summation = intStream.sum();
    // in consecutive ways:
    int summation2 = numbers.stream().mapToInt(Integer::intValue).sum();
       
    // create a map
    Map<Character, String> map = Map.of('2', "abc", '3', "def");
    // traverse map
    for (char c : map.keySet()) {
      // do something
    }
    for (Map.Entry<Character, String> entry : map.entrySet()) {
      // do something
      
    }
    
    // array copy
    int[] array1 = {2};
    int[] res = Arrays.copyOfRange(array1, 1, 1);
    int[] res2 = array1.clone();
    int[] res3 = Arrays.copyOf(array1, 1);
    
    System.out.println(Arrays.toString(res));
    System.out.println(Arrays.toString(res3));
    
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
    int[][] nums3 = { { 1, 2, 3 }, { 3, 4, 5 }, { 4, 5, 6 } };
    nums3[0][1] = 9;
    
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
    System.arraycopy(s, num2, res, num3, opt);
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
