public class Test {

    public static void main( String[] args ) {

	LinkedList l = new LinkedList();

	l.addFirst( new Integer( 10 ) );
	l.addFirst( new Integer(  5 ) );
	l.addFirst( new Integer(  2 ) );
	l.addFirst( new Integer(  8 ) );
	l.addFirst( new Integer(  1 ) );
	l.addFirst( new Integer(  7 ) );

	System.out.println( l );

	for ( int i=0; i<12; i++ ) {
	    System.out.println( "test " + i ) ;

	    LinkedList res = l.filterLessThan( new Integer( i ) );
	    System.out.println( "(a) " + res );

	    res = l.filterLessThan2( new Integer( i ) );
	    System.out.println( "(b) " + res );
	}

    }

}
