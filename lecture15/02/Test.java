public class Test {
    public static void c() {
	System.out.println( "c() :: about to throw exception" );
	throw new RuntimeException( "from c()" );
    }
    public static void b() {
	System.out.println( "b() :: pre-" );
	c();
	System.out.println( "b() :: post-" );
    }
    public static void a() {
	System.out.println( "a() :: pre-" );
	try {
	    b();
	} catch ( RuntimeException e ) {
	    System.out.println( "a() :: caught exception" );
	}
	System.out.println( "a() :: calling b, no try block" );
	b();
	System.out.println( "a() :: post-" );
    }
    public static void main( String[] args ) {
	System.out.println( "main( ... ) :: pre-" );
	a();
	System.out.println( "main( ... ) :: post-" );
    }
}
// main( ... ) :: pre-
// a() :: pre-
// b() :: pre-
// c() :: about to throw exception
// a() :: caught exception
// a() :: calling b, no try block
// b() :: pre-
// c() :: about to throw exception
// Exception in thread "main" java.lang.RuntimeException: from c
// 	at Test.c(Test.java:4)
// 	at Test.b(Test.java:8)
// 	at Test.a(Test.java:19)
// 	at Test.main(Test.java:24)
