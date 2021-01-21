public class TestIntegers {
	// Example for interning of small numeric values (does not apply to Float and Double)

	public static void main (String[] args) {
		
		// Try with 200 and see what happens!
		
		Long l1 =  128l;
		Long l2 =  128l;
		
		if (l1 == l2) {
			System.out.println("l1 == l2");
		} else {
			System.out.println("l1 != l2");
			System.out.println("Yet, l1=" + l1 + " and l2=" + l2);	
		}
	}
}
