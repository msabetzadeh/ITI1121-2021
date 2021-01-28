public class Shape {
    protected double x;
    protected double y;
    
    public Shape() {
        x = 0;
        y = 0;
    }
    
    public Shape(double x, double y) {
        this.x = x;
        this.y = y; 
    }
    
    final public double getX() {
        return x;
    }
    
    final public double getY() {
    	return y; 
    }

    final public void moveTo(double x, double y) {
        this.x = x;
        this.y = y; 
    }
    
    public String toString () {
    	return "Located at: (" + x + "," + y + ")";
	}
	
}










/*
	public boolean isLeftOf(Shape s) {
		return getX() < s.getX();
	}
*/