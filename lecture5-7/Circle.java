public class Circle extends Shape {

    // Instance variable
    private double radius;
    
    public Circle() {
        // super (...) can appear only in a constructor;
        // Can only be the first statement of the constructor
        // super() is inserted automatically unless you start with a super(...) yourself!
        super();
        
        radius = 0; 
    }

    public Circle(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }
    
    public Circle(double radius) {
        super(1,1);
        this.radius = radius;
    }

    
    // Getters
    public double getRadius() {
        return radius;
    }
    
    public String toString() {
       return "Located at: (" + x + "," + y + "), with radius " + radius;
    }
}
