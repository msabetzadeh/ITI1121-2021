public class TestRemove {

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

	t.add( new Integer(  6 ) );
	t.add( new Integer(  4 ) );
	t.add( new Integer(  2 ) );
	t.add( new Integer(  5 ) );
	t.add( new Integer(  1 ) );
	t.add( new Integer(  3 ) );
	t.add( new Integer(  9 ) );
	t.add( new Integer(  7 ) );
	t.add( new Integer(  8 ) );
	t.add( new Integer( 11 ) );
	t.add( new Integer( 10 ) );
	t.add( new Integer( 12 ) );

	System.out.println( t );

	System.out.println( "t.remove( " + args[ 0 ] + " )" );

	t.remove( new Integer( args[ 0 ] ) );

	System.out.println( t );


    }

}

