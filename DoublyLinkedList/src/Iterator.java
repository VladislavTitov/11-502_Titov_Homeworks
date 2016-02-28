public interface Iterator<T> {

    boolean hasNext();

    boolean hasPrevious();

    void next();

    void previous();

    T getNext();

    T getPrevious();
}
