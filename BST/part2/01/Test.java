public class Test {

    public static void displayStudentInfo( ) {

        System.out.println( "************************************************************" );
        System.out.println( "*                                                          *" );
        System.out.println( "*                                                          *" );
        System.out.println( "*                                                          *" );
        System.out.println( "*                                                          *" );
        System.out.println( "************************************************************" );
        System.out.println();

    }

    public static void main( String[] args ) {

        displayStudentInfo();

	BinarySearchTree t;
	t = new BinarySearchTree();

	String[] animals = { "Lion", "Fox", "Rat", "Cat", "Pig", "Dog", "Tiger" };

	for ( int i=0; i<animals.length; i++ ) {
	    System.out.println( "Adding " + animals[ i ] );
	    if ( t.add( animals[ i ] ) ) {

		System.out.println( t );
		System.out.println( "t.min() -> " + t.min() );
		System.out.println( "t.max() -> " + t.max() );
		System.out.println( "t.depth() -> " + t.depth() );
		System.out.println( "t.isTwoTree() -> " + t.isTwoTree() );

	    } else {

		System.out.println( "failure" );

	    }
	}

	for ( int i=0; i<animals.length; i++ ) {

	    if ( t.contains( animals[ i ] ) ) {

		System.out.println( t );
		System.out.println( "t.min() -> " + t.min() );
		System.out.println( "t.max() -> " + t.max() );
		System.out.println( "t.depth() -> " + t.depth() );
		System.out.println( "t.isTwoTree() -> " + t.isTwoTree() );

	    } else {

		System.out.println( "failure" );

	    }
	}

	String[] pets = { "Lion", "Wolf", "Rat", "Chimp", "Pig", "Horse", "Tiger" };

	for ( int i=0; i<pets.length; i++ ) {
	    System.out.println( "t.contains( " + pets[ i ] + ") is " + t.contains( pets[ i ] ) );
	    System.out.println( "t.contains2( " + pets[ i ] + ") is " + t.contains2( pets[ i ] ) );
	}

	for ( int i=0; i<pets.length; i++ ) {
	    System.out.println( "Adding " + pets[ i ] );
	    if ( t.add( pets[ i ] ) ) {

		System.out.println( t );
		System.out.println( "t.min() -> " + t.min() );
		System.out.println( "t.max() -> " + t.max() );
		System.out.println( "t.depth() -> " + t.depth() );
		System.out.println( "t.isTwoTree() -> " + t.isTwoTree() );

	    } else {

		System.out.println( "failure" );

	    }
	}



    }
}

// > java L13P2
// ************************************************************
// *                                                          *
// *                                                          *
// *                                                          *
// *                                                          *
// ************************************************************
// 
// Adding Lion
//   null
// Lion
//   null
// 
// t.min() -> Lion
// t.max() -> Lion
// t.depth() -> 0
// t.isTwoTree() -> true
// Adding Fox
//   null
// Lion
//     null
//   Fox
//     null
// 
// t.min() -> Fox
// t.max() -> Lion
// t.depth() -> 1
// t.isTwoTree() -> false
// Adding Rat
//     null
//   Rat
//     null
// Lion
//     null
//   Fox
//     null
// 
// t.min() -> Fox
// t.max() -> Rat
// t.depth() -> 1
// t.isTwoTree() -> true
// Adding Cat
//     null
//   Rat
//     null
// Lion
//     null
//   Fox
//       null
//     Cat
//       null
// 
// t.min() -> Cat
// t.max() -> Rat
// t.depth() -> 2
// t.isTwoTree() -> false
// Adding Pig
//     null
//   Rat
//       null
//     Pig
//       null
// Lion
//     null
//   Fox
//       null
//     Cat
//       null
// 
// t.min() -> Cat
// t.max() -> Rat
// t.depth() -> 2
// t.isTwoTree() -> false
// Adding Dog
//     null
//   Rat
//       null
//     Pig
//       null
// Lion
//     null
//   Fox
//         null
//       Dog
//         null
//     Cat
//       null
// 
// t.min() -> Cat
// t.max() -> Rat
// t.depth() -> 3
// t.isTwoTree() -> false
// Adding Tiger
//       null
//     Tiger
//       null
//   Rat
//       null
//     Pig
//       null
// Lion
//     null
//   Fox
//         null
//       Dog
//         null
//     Cat
//       null
// 
// t.min() -> Cat
// t.max() -> Tiger
// t.depth() -> 3
// t.isTwoTree() -> false
// Adding Lion
// failure
// Adding Fox
// failure
// Adding Rat
// failure
// Adding Cat
// failure
// Adding Pig
// failure
// Adding Dog
// failure
// Adding Tiger
// failure
// t.contains( Lion) is true
// t.contains( Wolf) is false
// t.contains( Rat) is true
// t.contains( Chimp) is false
// t.contains( Pig) is true
// t.contains( Horse) is false
// t.contains( Tiger) is true
// Adding Lion
// failure
// Adding Wolf
//         null
//       Wolf
//         null
//     Tiger
//       null
//   Rat
//       null
//     Pig
//       null
// Lion
//     null
//   Fox
//         null
//       Dog
//         null
//     Cat
//       null
// 
// t.min() -> Cat
// t.max() -> Wolf
// t.depth() -> 3
// t.isTwoTree() -> false
// Adding Rat
// failure
// Adding Chimp
//         null
//       Wolf
//         null
//     Tiger
//       null
//   Rat
//       null
//     Pig
//       null
// Lion
//     null
//   Fox
//         null
//       Dog
//           null
//         Chimp
//           null
//     Cat
//       null
// 
// t.min() -> Cat
// t.max() -> Wolf
// t.depth() -> 4
// t.isTwoTree() -> false
// Adding Pig
// failure
// Adding Horse
//         null
//       Wolf
//         null
//     Tiger
//       null
//   Rat
//       null
//     Pig
//       null
// Lion
//       null
//     Horse
//       null
//   Fox
//         null
//       Dog
//           null
//         Chimp
//           null
//     Cat
//       null
// 
// t.min() -> Cat
// t.max() -> Wolf
// t.depth() -> 4
// t.isTwoTree() -> false
// Adding Tiger
// failure
