public class LinkedList {

    //  ----------------------------------------------------------

    private static class Node {
        private Object value;
        private Node next;
        private Node( Object value, Node next ) {
            this.value = value;
            this.next = next;
        }
    }

    //  ----------------------------------------------------------

    private Node first;

    public LinkedList () {
        first = null;
    }

    public boolean isEmpty() {
	return first == null;
    }

    public LinkedList filter( Predicate pred ) {

	LinkedList result = new LinkedList();

	filter( pred, first, result );

	return result;
    }

    private static void filter( Predicate pred, Node p,  LinkedList result ) {

	if ( p == null ) {
	    return;
	}

	filter( pred, p.next, result );

	if ( pred.test( p.value ) ) {
	    result.addFirst( p.value );
	}
    }


//    public LinkedList filterLessThan( Comparable c ) {
//
//	LinkedList result;
//
//	result = new LinkedList();
//
//	result.first = filterLessThan( first, c );
//
//	return result;
//    }
//
//    private static Node filterLessThan( Node p, 
//                                        Comparable c ) {
//
//	if ( p == null )
//	    return null;
//
//	Node res = filterLessThan( p.next, c );
//
//	if ( p.value.compareTo( c ) < 0 )
//	    return new Node( p.value, res );
//	else
//	    return res;
//    }


    public void addFirst( Object o ) {
	first = new Node( o, first );
    }

    //  ----------------------------------------------------------

    public int size() {
	return size(first);
    }

    private int size(Node p) {
	if (p == null)
	    return 0;
	else
	    return 1 + size(p.next);
    }

    //  ----------------------------------------------------------

    public boolean contains(Comparable obj) {
	return contains(first, obj);
    }

    private boolean contains(Node p, Comparable obj) {
	if (p == null)
	    return false;
	else if (p.value.equals(obj))
	    return true;
	else
	    return contains(p.next, obj);
    }

    //  ----------------------------------------------------------

//    public Object findMax() {
//	return findMax(first);
//    }
//
//    private Object findMax(Node p) {
//
//	if (p.next == null)
//	    return p.value;
//
//	Comparable result = (Comparable) findMax(p.next);
//
//	if (result.compareTo(p.value) > 0)
//	    return result;
//	else
//	    return p.value;
//
//    }

    //  ----------------------------------------------------------

    public int indexOf(Object obj) {
        return indexOf(first, obj);
    }

    private int indexOf(Node p, Object obj) {

        if (p == null)
            return -1;

        if (p.value.equals(obj))
            return 0;

        int result = indexOf(p.next, obj);

        if (result == -1)
            return result;
        else
            return result + 1;
    }

    //  ----------------------------------------------------------

    public int indexOfLast(Object obj) {
        return indexOfLast(first, obj);
    }

    private int indexOfLast(Node p, Object obj) {

        if (p == null)
            return -1;

        int result = indexOfLast(p.next, obj);

        if (result > -1)
            return result + 1;
        else if (obj.equals(p.value))
	    return 0;
        else
            return -1;
    }

    //  ----------------------------------------------------------

    public boolean remove(Object obj) {

	boolean result;

	if ( first == null )
	    result = false;
	else if ( first.value.equals( obj ) ) {
	    first = first.next;
	    result = true;
	} else
	    result = remove( first, obj );

	return result;
    }

    private boolean remove( Node p, Object obj ) {
	boolean result;

	if ( p.next == null )

	    result = false; // end of the list

	else if ( obj.equals( p.next.value ) ) {

	    p.next = p.next.next;
	    result = true;

	} else

	    result = remove(p.next, obj);

	return result;
    }

    //  ----------------------------------------------------------

    public boolean addLast(Comparable obj) {

	if (obj == null)
	    return false;

	if (first == null)
	    first = new Node(obj, null);
	else
	    addLast(first, obj);

	return true;
    }

    private void addLast(Node p, Comparable obj) {
	if (p.next == null)
	    p.next = new Node(obj, null);
	else
	    addLast(p.next, obj);
    }


    //  ----------------------------------------------------------

    public void reverse() {
	if (first != null) {
	    Node second = first.next; // first.next == null is ok
	    first.next = null;        // new tail node
	    first = reverse(first, second);
	}
    }

    private Node reverse(Node previous, Node current) {

	if (current == null)
	    return previous;

	Node next = current.next;
	current.next = previous;

	return reverse(current, next);
    }

    //  ----------------------------------------------------------
    //  non-recursive toString
    
    public String toString() {

	String result = "[";
	Node p = first;
	while (p != null) {
	    if (p == first)
		result = result + p.value;
	    else
		result = result + ", " + p.value;
	    p = p.next;
	}
	result = result + "]";

	return result;
    }

}
