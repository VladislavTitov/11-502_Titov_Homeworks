package ru.itis.inform;

public interface Iterator<T> {

    /**
     * Проверить, есть ли слеующий элемент
     * @return true - если есть, false - в противном случае
     */
    boolean hasNext();
    boolean hasPrevious();


    void next();

    void previous();

    T peekNext();

    T peekPrevious();

    void insert(T element);

    void back();
}
