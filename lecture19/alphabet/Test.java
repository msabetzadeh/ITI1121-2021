public class Test {

    public static void main( String[] args ) {

        String[] series = new String[]{"0","1"};
        Queue<String> queue = new LinkedQueue<String>();

        queue.enqueue("");
        int j =0;
        while(j++ < 255) {
//        while(true) {
            String s = queue.dequeue();
            System.out.println(s);
            for(int i =0; i< series.length; i++){
                queue.enqueue(s+series[i]);
            }
        }
    }
}
