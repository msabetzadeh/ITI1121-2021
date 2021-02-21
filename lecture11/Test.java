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
		num1 = new ArrayStack( 10 );

		num1.push( new Integer( 1 ) );
		num1.push( new Integer( 2 ) );
		num1.push( new Integer( 3 ) );

		while ( ! num1.isEmpty() ) {
		    Integer num;
		    num = (Integer) num1.pop();
		    System.out.println( num );
		}


		Stack op1;
		op1 = new ArrayStack( 10 );

		op1.push( "plus" );
		op1.push( "mult" );
		op1.push( "div" );

		while ( ! op1.isEmpty() ) {
		    String op;
		    op = (String) op1.pop();
		    System.out.println( op );
		}

		op1.push( new Integer( 4 ) ); 
		
		// Solving the same problem using GenericArrayStack

		// A stack called num2 to store operands (numbers)

		Stack<Integer> num2;
		num2 = new GenericArrayStack<Integer>( 10 );

		num2.push( new Integer( 1 ) );
		num2.push( new Integer( 2 ) );
		num2.push( new Integer( 3 ) );

		while ( ! num2.isEmpty() ) {
		    Integer num;
		    // No type cast!
		    num = num2.pop();
		    System.out.println( num );
		}

		// A stack called op2 to store operations (here Strings)

		Stack<String> op2;
		op2 = new GenericArrayStack<String>( 10 );

		op2.push( "plus" );
		op2.push( "mult" );
		op2.push( "div" );

		while ( ! op2.isEmpty() ) {
		    String op;
		    // No type cast!
		    op = op2.pop();
		    System.out.println( op );
		}

	 	// Uncomment the following line:

		// op2.push( new Integer( 4 ) ); 

		// Test.java:62: push(java.lang.String) in Stack<java.lang.String> 
		// cannot be applied to (java.lang.Integer)
		// 	op2.push( new Integer( 4 ) ); 
		//            ^

		// The two implementations achieve the same goal: a single
		// implementation of the interface Stack can be used to store
		// Integer or String objects.  However, in the case of the
		// second implementation, using Generics, we did not have to
		// override important compile-time type-checking mechanisms.
		// The compiler can assist the detection of errors with the
		// logic of your programs, here, adding a number to the
		// operations stack.

		for(int i = 0; i < 100; i++) {
			num2.push(Integer.valueOf(i));
		}
		while(!num2.isEmpty())
			System.out.println(num2.pop());
	}
    
}

// > java Test
// 3
// 2
// 1
// div
// mult
// plus
// 3
// 2
// 1
// div
// mult
// plus
