package overview;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class Beans {

  public static void main(String[] args) {
    BeanInfo info;
    try {
      info = Introspector.getBeanInfo(Person1.class);
      for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
        System.out.println(pd.getName());
        System.out.println("  " + pd.getReadMethod());
        System.out.println("  " + pd.getWriteMethod());
    }
    } catch (IntrospectionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    

  }

}
class Person {
  public String name;
  private int age;

  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public int getAge() {
      return age;
  }

  public void setAge(int age) {
      this.age = age;
  }
}