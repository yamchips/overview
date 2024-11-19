package overview;

public class ParameterBinding {
  
  /*
   * https://liaoxuefeng.com/books/java/oop/basic/method/index.html#0
   */
  public static void main(String[] args) {
    Person1 p = new Person1();
    String[] fullname = new String[] { "Homer", "Simpson" };
    p.setName(fullname); // 传入fullname数组
    System.out.println(p.getName()); // "Homer Simpson"
    fullname[0] = "Bart"; // fullname数组的第一个元素修改为"Bart"
    System.out.println(p.getName()); // "Homer Simpson"还是"Bart Simpson"?
    
    Person2 p2 = new Person2();
    String bob = "Bob";
    p2.setName(bob); // 传入bob变量
    System.out.println(p.getName()); // "Bob"
    bob = "Alice"; // bob改名为Alice
    System.out.println(p.getName()); // "Bob"还是"Alice"?
  }
}

class Person2 {
  private String name;

  public String getName() {
      return this.name;
  }

  public void setName(String name) {
      this.name = name;
  }
}

class Person1 {
  private String[] name;

  public String getName() {
      return this.name[0] + " " + this.name[1];
  }

  public void setName(String[] name) {
      this.name = name;
  }
}
