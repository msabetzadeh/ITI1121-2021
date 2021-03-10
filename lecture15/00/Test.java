class Test {
    public static void main ( String[] args ) {
        System.out.println( "-1-" );
        if ( true ) {
            throw new RuntimeException( "Help!" );
        }
        System.out.println( "-2-" );
    }
}

