public class Test  {
    public static void main(String[] args){
        Shape shape1 = new Shape();
        Shape shape2 = new Shape(3,5);
        Circle circle1 = new Circle();
        Circle circle2 = new Circle(5,6,7);
        Circle circle3 = new Circle(7);
        
        System.out.println(shape1.toString());
        System.out.println(shape2);
        
        System.out.println(circle1+ " and " + circle2 + " and " + circle3);
        shape1.moveTo(10,11);
        System.out.println(shape1);
        circle2.moveTo(20,21);
        System.out.println(circle2);
    }
}


