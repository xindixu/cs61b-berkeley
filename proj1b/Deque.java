public interface Deque<T> {

    void addFirst(T item);

    void addLast(T item);

    T removeFirst();

    T removeLast();

    T get(int i);

    void printDeque();

    boolean isEmpty();

    int size();
}
