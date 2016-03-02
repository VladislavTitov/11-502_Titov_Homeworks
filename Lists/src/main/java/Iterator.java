public interface Iterator<E> {

    boolean hasNext();

    boolean hasPrevious();

    void next();

    void previous();

    E getNext();

    E getPrevious();
}
