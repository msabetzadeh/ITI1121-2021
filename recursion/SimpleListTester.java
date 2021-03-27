public class SimpleListTester {

    public static void main(String[] args) {

	SimpleList l = new SimpleList();

	System.out.println("length = " + l.size());
	System.out.println("l -> " + l);

	for (int i=0; i<5 ; i++) {
	    l.addLast("elem-" + i);
	    System.out.println("length = " + l.size());
	}
	System.out.println("l -> " + l);

	for (int i=-1; i<6 ; i++) {
	    System.out.println("l.contains(" + "elem-" + i +  ") -> " + l.contains("elem-" + i));
	}

	l = new SimpleList();
	for (int i=1; i<5 ; i++)
	    l.addLast(new Time(i,i,i));
	System.out.println("l -> " + l);

	System.out.println("l.isIncreasing() -> " + l.isIncreasing());

	l.addLast(new Time(0,0,0));
	System.out.println("l -> " + l);

	System.out.println("l.isIncreasing() -> " + l.isIncreasing());

	System.out.println("l.findMax() -> " + l.findMax());

	for (int i=1; i<5 ; i++)
	    l.addLast(new Time(i,i,i));
	System.out.println("l -> " + l);

	Time t;
	for (int i=1; i<5 ; i++) {
	    t = new Time(i,i,i);
	    System.out.println("l.indexOf(" + t + ") -> " + l.indexOf(t));
	    System.out.println("l.indexOfLast(" + t + ") -> " + l.indexOfLast(t));
	}

	t = new Time(3,3,3);
	System.out.println("l -> " + l);
	System.out.println("l.removeLast(" + t + ") -> " + l.removeLast(t));
	System.out.println("l -> " + l);

	t = new Time(10,10,10);
	System.out.println("l -> " + l);
	System.out.println("l.removeLast(" + t + ") -> " + l.removeLast(t));
	System.out.println("l -> " + l);

	for ( int i=0; i<l.size() ; i++) {
	    System.out.println( "get(" + i + ") -> " + l.get( i ) );
	}
    }

}
