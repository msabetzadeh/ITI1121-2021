public class Test extends Object {
    public static boolean error() {
        if ( true ) {
            throw new RuntimeException( "an Exception" );
}
        return true;
    }
    public static boolean display() {
        System.out.println( "-2-" );
        return true;
    }
    public static void main( String[] args ) {
        System.out.println( "-1-" );
        if ( error() || display() ) {
            System.out.println( "-3-" );
        }
        System.out.println( "-4-" );
    }
}