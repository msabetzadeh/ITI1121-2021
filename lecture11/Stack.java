public interface Stack<E> {
    public abstract boolean isEmpty();
    public abstract E push( E elem );
    public abstract E pop();
    public abstract E peek();
}

/*
public interface Stack {
    public abstract boolean isEmpty();
    public abstract Object push( Object elem );
    public abstract Object pop();
    public abstract Object peek();
}
*/
