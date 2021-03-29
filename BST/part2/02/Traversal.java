public class Traversal {

    public static void main( String[] args ) {

	BinarySearchTree t;
	t = new BinarySearchTree();

	t.add( new Integer(  8 ) );
	t.add( new Integer(  5 ) );
	t.add( new Integer( 15 ) );
	t.add( new Integer(  9 ) );
	t.add( new Integer( 29 ) );
	t.add( new Integer( 11 ) );

	System.out.print( "preOrder ->" );
	t.preOrder();

	System.out.print( "inOrder ->" );
	t.inOrder();

	System.out.print( "postOrder ->" );
	t.postOrder();

    }

}
