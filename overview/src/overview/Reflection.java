package overview;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Reflection {
  public static void main(String[] args) throws Exception {
    Class cls = "".getClass();
    
//    printClassInfo(cls);
//    printClassInfo(Runnable.class);
//    printClassInfo(java.time.Month.class);
//    printClassInfo(String[].class);
//    printClassInfo(int.class);
    
    String s = (String) cls.newInstance();
    System.out.println(s.length());
    
    Class stdClass = Student.class;
    // 获取public字段"score":
    System.out.println(stdClass.getField("score"));
    // 获取继承的public字段"name":
    Field[] fields = stdClass.getFields();
    Arrays.stream(fields)
          .map(Field::getName)
          .forEach(System.out::println);
    
    // 获取private字段"grade":
    System.out.println(stdClass.getDeclaredField("grade"));
    
  }

  static void printClassInfo(Class<?> cls) {
    System.out.println("Class name: " + cls.getName());
    System.out.println("Simple name: " + cls.getSimpleName());
    if (cls.getPackage() != null) {
      System.out.println("Package name: " + cls.getPackage().getName());
    }
    System.out.println("is interface: " + cls.isInterface());
    System.out.println("is enum: " + cls.isEnum());
    System.out.println("is array: " + cls.isArray());
    System.out.println("is primitive: " + cls.isPrimitive());
  }
}


class Student extends Person {
  public int score;
  private int grade;
  private String name;
}