public class SimpleList {

    //  ----------------------------------------------------------

    private class Node {
        private Comparable value;
        private Node next;
        Node (Comparable value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    //  ----------------------------------------------------------

    private Node first;

    public SimpleList () {
        first = null;
    }

    public boolean isEmpty() {
	return first == null;
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

    public Object get( int pos ) {
	if ( pos < 0 ) {
	    throw new IndexOutOfBoundsException( Integer.toString( pos ) );
	}
	return get( first, pos );
    }

    private Object get( Node p, int pos ) {
	Object obj;

	if ( p == null ) {
	    throw new IndexOutOfBoundsException( Integer.toString( pos ) );
	}

	if ( pos == 0 ) {
	    obj = p.value;
	} else {
	    obj =  get( p.next, pos-1 );
	}

	return obj;
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

    public boolean isIncreasing() {
	return isIncreasing(first);
    }

    private boolean isIncreasing(Node p) {
	if ((p == null) || (p.next == null))
	    return true;

	if (p.value.compareTo(p.next.value) > 0)
	    return false;
	else
	    return isIncreasing(p.next);
    }

    //  ----------------------------------------------------------

    public Object findMax() {
	return findMax(first);
    }

    private Object findMax(Node p) {

	if (p.next == null)
	    return p.value;

	Comparable result = (Comparable) findMax(p.next);

	if (result.compareTo(p.value) > 0)
	    return result;
	else
	    return p.value;

    }

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

	if (first == null)
	    result = false;
	else if (first.value.equals(obj)) {
	    first = first.next;
	    result = true;
	} else
	    result = remove(first, obj);

	return result;
    }

    private boolean remove(Node p, Object obj) {
	boolean result;

	if (p.next == null)
	    result = false; // reached the end of the list
	else if (obj.equals(p.next.value)) {
	    p.next = p.next.next;
	    result = true;
	} else
	    result = remove(p.next, obj);

	return result;
    }

    //  ----------------------------------------------------------

    public boolean removeLast( Object obj ) {

	boolean removed;

	if ( first == null ) {
	    removed = false;
	} else {
	    removed = removeLast( first, obj );
	    if ( ! removed ) {
		if ( first.value.equals( obj ) ) {
		    first = first.next;
		    removed = true;
		}
	    }
	}

	return removed;
    }

    private boolean removeLast( Node p, Object obj ) {

	boolean removed;

	if ( p.next == null ) {

	    removed = false; // reached the end of the list

	} else {

	    removed = removeLast( p.next, obj );

	    if ( (! removed ) && obj.equals( p.next.value ) ) {
		p.next = p.next.next;
		removed = true;
	    }

	}

	return removed;
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
