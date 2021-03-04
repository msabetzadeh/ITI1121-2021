public class LinkedStack<E> implements Stack<E> {

    private static class Elem<T> {
        private T value;
        private Elem<T> next;

        private Elem(T value, Elem<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Elem<E> top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(E value) {
        top = new Elem<E>(value, top);
    }

    public E peek() {
        return top.value;
    }

    public E pop() {
        E saved = top.value;
        top = top.next;
        return saved;
    }
}
