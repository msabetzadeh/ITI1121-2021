// Largely based on Lewis & Chase

// Under Java 1.5 use the argument -source 1.4 to avoid warnings
//
// > javac -source 1.4 BinarySearchTree.java

import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTree {

    // A static nested class used to store the elements of this tree

    private static class Node {
        private Comparable value;
        private Node left;
        private Node right;
        private Node( Comparable value ) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root = null;
    
    /**
     * Inserts an object into this BinarySearchTree.
     *
     * @param obj item to be added
     * @return true if the object has been added and false otherwise
     */

    public boolean add( Comparable obj ) {

        // pre-condtion:

        if ( obj == null ) {
            throw new IllegalArgumentException( "null" );
        }

        // special case:

        if ( root == null ) {
            root = new Node( obj );
            return true;
        }

        // general case:

        return add( obj, root );
    }

    private boolean add( Comparable obj, Node current ) {

        boolean result;
        int test = obj.compareTo( current.value );

        if ( test == 0 ) {
            result = false;
        } else if ( test < 0 ) {
            if ( current.left == null ) {
                current.left = new Node( obj );
                result = true;
            } else {
                result = add( obj, current.left );
            }
        } else {
            if ( current.right == null ) {
                current.right = new Node( obj );
                result = true;
            } else {
                result = add( obj, current.right );
            }
        }
        return result;
    }

    public boolean add2( Comparable obj ) {

	Node current = root;
	boolean added = false;

	if ( current == null ) {
	    root = new Node( obj );
	    added = true;
	} else {
	    boolean done = false;
	    while ( ! done ) {
		int test = obj.compareTo( current.value );
		if ( test == 0 ) {
		    done = true;
		    added = false;
		} else if ( test < 0 ) {
		    if ( current.left == null ) {
			current.left = new Node( obj );
			done = added = true;
		    } else {
			current = current.left;
		    }
		} else {
		    if ( current.right == null ) {
			current.right = new Node( obj );
			done = added = true;
		    } else {
			current = current.right;
		    }
		}
	    }
	}

        return added;
    }

    /**
     * Remove an object from a BinarySearchTree.
     *
     * @param obj item to be removed.
     */


public void remove( Comparable obj ) {

    // pre-condtion:
    if ( obj == null ) {
        throw new IllegalArgumentException( "null" );
    }
    if ( root == null ) {
        throw new NoSuchElementException( );
    }

    if ( obj.compareTo( root.value ) == 0 ) {
        root = removeTopMost( root );
    } else {

        Node current, parent = root;

        if ( obj.compareTo( root.value ) < 0 ) {
            current = root.left;
        } else {
            current = root.right;
        }

        while ( current != null ) {

            int test = obj.compareTo( current.value );

            if ( test == 0 ) {

                if ( current == parent.left ) {
                    parent.left = removeTopMost( current );
                } else {
                    parent.right = removeTopMost( current );
                }
                current = null; // stopping criteria

            } else {

                parent = current;
                if ( test < 0 ) {
                    current = parent.left;
                } else {
                    current = parent.right;
                }

            }
        }
    }
}


private Node removeTopMost( Node current ) {

    if ( current == null ) {
        throw new IllegalArgumentException( "null" );
    }

    Node answer;

    if ( current.left == null ) {

        answer = current.right;

    } else if ( current.right == null ) {

        answer = current.left;

    } else {

        current.value = getLeftMost( current.right );
        current.right = removeLeftMost( current.right );
        answer = current;

    }

    return answer;
}


private static Comparable getLeftMost( Node current ) {

    if ( current == null ) {
        throw new IllegalArgumentException( "null" );
    }

    if ( current.left == null ) {
        return current.value;
    }

    return getLeftMost( current.left );
}


private static Node removeLeftMost( Node current ) {

    if ( current == null ) {
        throw new IllegalArgumentException( "null" );
    }

    if ( current.left == null ) {
        return current.right;
    }

    Node top = current, parent = current;

    current = current.left;

    while ( current.left != null ) {
        parent = current;
        current = current.left;
    }

    parent.left = current.right;

    return top;
}


    /**
     * Looks up for obj in this BinarySearchTree, returns true
     * if obj is found and false otherwise.
     *
     * @param obj value to look for
     * @return true if the object has been found and false otherwise
     */

    public boolean contains( Comparable obj ) {

        // pre-condtion:

        if ( obj == null ) {
            throw new IllegalArgumentException( "null" );
        }

        return contains( obj, root );
    }

    private static boolean contains( Comparable obj, Node current ) {

        boolean result;

        if ( current == null ) {
            result = false;
        } else {

            int test = obj.compareTo( current.value );
            if ( test == 0 ) {
                result = true;
            } else if ( test < 0 ) {
                result = contains( obj, current.left );
            } else {
                result = contains( obj, current.right );
            }
        }
        return result;
    }

    public boolean contains2( Comparable obj ) {
        // pre-condtion:
        if ( obj == null ) {
            throw new IllegalArgumentException( "null" );
        }

        boolean found = false;
        Node current = root;

        while ( ! found && current != null ) {

            int test = obj.compareTo( current.value );

            if ( test == 0 ) {
                found = true;
            } else if ( test < 0 ) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return found;
    }

    // dumb: compares the structures only

    public boolean equals( Object obj ) {

        if ( ! ( obj instanceof BinarySearchTree ) ) {
            return false;
        }

        return equals( root, ( (BinarySearchTree) obj ).root );
    }

    private static boolean equals( Node a, Node b ) {

        if ( a == null || b == null ) {
            return ( a == null && b == null );
        }

        if ( a.value.compareTo( b.value ) != 0 ) {
            return false;
        }

        return equals( a.left, b.left ) && equals( a.right, b.right );

    }

    public Object max() {

        if ( root == null ) {
            throw new NoSuchElementException();
        }
        return max( root );
    }

    private static Object max( Node current ) {

        if ( current.right == null ) {
            return current.value;
        } else {
            return max( current.right );
        }

    }

    public Object min() {

        if ( root == null ) {
            throw new NoSuchElementException();
        }
        return min( root );
    }

    private static Object min( Node current ) {

        if ( current.left == null ) {
            return current.value;
        } else {
            return min( current.left );
        }

    }

    public boolean isTwoTree() {

        return isTwoTree( root );
    }

    private static boolean isTwoTree( Node current ) {

        boolean answer;

        if ( current == null ) {

            answer = true;

        } else {

            if ( current.left == null || current.right == null ) {

                answer = current.left == null && current.right == null;

            } else {

                answer = isTwoTree( current.left ) && isTwoTree( current.right );

            }

        }

        return answer;
    }

    public int depth() {
        return depth( root );
    }

    private static int depth( Node current ) {

        if ( current == null ) {

            return -1;

        } else {

            int dleft, dright;

            dleft = depth( current.left ); 
            dright = depth( current.right ); 

            return Math.max( dleft, dright ) + 1;
        }

    }

    public Iterator iterator() {
        return new PreOrderIterator();
    }

    private class PreOrderIterator implements Iterator {

        private Stack trail;

        private PreOrderIterator() {
            trail = new Stack();
            if ( root != null ) {
                trail.push( root );
            }
        }

        public boolean hasNext() {
            return ! trail.isEmpty();
        }

        public Object next() {

            if ( trail.isEmpty() ) {
                throw new NoSuchElementException();
            }

            Node current = (Node) trail.pop();
            
            if ( current.right != null ) {
                trail.push( current.right );
            }
            if ( current.left != null ) {
                trail.push( current.left );
            }
            return current.value;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

    }




    private static String NL = System.getProperty( "line.separator" );
        
    public String toString() {
        return toString( root, "" );
    }

    private String toString( Node current, String padding ) {

        String result;

        if ( current == null ) {
            
            result = padding + "null" + NL;

        } else {

            result = toString( current.right, padding + "  " );
            result += padding + current.value + NL;
            result += toString( current.left, padding + "  " );
        }

        return result;
    }

    private void process( Node current ) {
	System.out.print( " " + current.value );
    }

    public void preOrder() {
        preOrder( root );
	System.out.println();
    }

    private void preOrder( Node current ) {

        if ( current != null ) {

	    process( current );
            preOrder( current.left );
            preOrder( current.right );
        }

    }

    public void inOrder() {
        inOrder( root );
	System.out.println();
    }

    private void inOrder( Node current ) {

        if ( current != null ) {

            inOrder( current.left );
	    process( current );
            inOrder( current.right );
        }

    }

    public void postOrder() {
        postOrder( root );
	System.out.println();
    }

    private void postOrder( Node current ) {

        if ( current != null ) {

            postOrder( current.left );
            postOrder( current.right );
	    process( current );
        }

    }

}
