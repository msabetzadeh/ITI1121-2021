public class ConcreteJollyObject extends JollyObject {
   public void p1Foo() {}
   public void p2Foo() {}

   public static void main (String[] args) {
     MyInterface i = new ConcreteJollyObject();
     System.out.println(i.toString());
   }

}