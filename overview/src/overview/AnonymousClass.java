package overview;

public class AnonymousClass {

  public static void main(String[] args) {
    Greeting gr = new Greeting() {

      @Override
      public void greeting() {
        System.out.println();
        
      }
      
      
    };

  }

}
