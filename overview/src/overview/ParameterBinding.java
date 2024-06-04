package overview;

public class ParameterBinding {

  public static void main(String[] args) {
    Person p = new Person();
    int[] fullname = new int[] { 1, 2 };
    p.setName(fullname); // 传入fullname数组
    System.out.println(p.getName()); // "Homer Simpson"
    fullname[0] = 3; // fullname数组的第一个元素修改为"Bart"
    System.out.println(p.getName()); // "Homer Simpson"还是"Bart Simpson"?
    

  }
  

}

class Person {
  private int[] name;

  public String getName() {
      return this.name[0] + " " + this.name[1];
  }

  public void setName(int[] name) {
      this.name = name;
  }
}
