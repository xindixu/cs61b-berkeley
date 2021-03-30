import javax.swing.*;

public class ArrayDeque<Type> {
    private final int INITIAL_SIZE = 8;
    private Type[] items;
    private int size;

    public ArrayDeque() {
        items = (Type[]) new Object[INITIAL_SIZE];
        size = 0;
    }

    private void resize(int newSize) {
        Type[] newItems = (Type[]) new Object[newSize];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }

    public void addFirst(Type item) {
        if(size + 1 > items.length){
            resize(size * 2);
        }

        System.arraycopy(items, 0, items, 1, size - 1 + 1);
        items[0] = item;
        size++;
    }


    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.println(items[i]);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size(){
        return size;
    }
}
