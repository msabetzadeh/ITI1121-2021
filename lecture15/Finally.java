public class Finally {

	public static void d() {
		System.out.println( "d() :: just executing, no exception");
	}

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
		System.out.println( "a() :: try without exception thrown" );
		try {
			d();
		} catch ( RuntimeException e ) {
			System.out.println( "a() :: caught RuntimeException exception" );
		} finally {
			System.out.println( "finally when no exception is thrown" );
		}

		System.out.println( "a() :: try with a caught exception" );
		try {
			b();
		} catch ( RuntimeException e ) {
			System.out.println( "a() :: caught RuntimeException exception" );
		} finally {
			System.out.println( "finally when an exception is caught" );
		}

		System.out.println( "a() :: try without exception thrown" );
		try {
			b();
		} catch ( NumberFormatException e ) {
			System.out.println( "a() :: caught exception" );
		} finally {
			System.out.println( "finally when an exception is uncaught" );
		}
		System.out.println( "a() :: post-" );
	}
	public static void main( String[] args ) {
		System.out.println( "main( ... ) :: pre-" );
		a();
		System.out.println( "main( ... ) :: post-" );
	}
}
