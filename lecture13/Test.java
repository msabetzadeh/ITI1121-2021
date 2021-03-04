/** ITI 1121/1521 Introduction to computer science II
 *
 *  This test program illustrates some of the advantages of Generics
 *  over the traditional Java implementation of a Stack.
 *
 *  @author Marcel Turcotte (turcotte@site.uottawa.ca>
 */


@SuppressWarnings( "unchecked" )

public class Test {

    public static void main( String[] args ) {



		Stack num1;
		num1 = new LinkedStack();

		num1.push( new Integer( 1 ) );
		num1.push( new Integer( 2 ) );
		num1.push( new Integer( 3 ) );
		num1.push("stowaway!"); // I should not be here!


		System.out.println("========num1 with stowaway! ========");

		while ( ! num1.isEmpty() ) {
		    System.out.println(num1.pop());
		}
		
		Stack op1;
		op1 = new LinkedStack();

		op1.push( "plus" );
		op1.push( "mult" );
		op1.push( "div" );
		op1.push( "div" );
		op1.push(new Integer(5)); // I should not be here!

		
		System.out.println("========op1 with stowaway! ========");

		while ( ! op1.isEmpty() ) {
		    if (op1.peek() instanceof Integer)
		    	System.out.print("I'm a stowaway! --> ");
		    System.out.println(op1.pop());
		}
		
		// Solving the same problem using Generics

		// A stack called num2 to store operands (numbers)

		Stack<Integer> num2;
		num2 = new LinkedStack<Integer>();

		num2.push( new Integer( 1 ) );
		num2.push( new Integer( 2 ) );
		num2.push( new Integer( 3 ) );
		//num2.push("stowaway!"); 

		System.out.println("======== num2 (with generics) ========");

		while ( ! num2.isEmpty() ) {
		    Integer num;
		    // No type cast!
		    num = num2.pop();
		    System.out.println( num );
		}



		Stack<String> op2;
		op2 = new LinkedStack<String>();

		op2.push( "plus" );
		op2.push( "mult" );
		op2.push( "div" );
		// op2.push( new Integer( 4 ) ); 


		System.out.println("======== op2 (with generics) ========");

		while ( ! op2.isEmpty() ) {
		    System.out.println( op2.pop());
		}
	}
    
}