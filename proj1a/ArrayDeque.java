import javax.swing.*;

public class ArrayDeque<Type> {
    private final int INITIAL_SIZE = 8;
    private final double USAGE_FACTOR = 0.25;
    private Type[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (Type[]) new Object[INITIAL_SIZE];
        size = 0;
        nextFirst = INITIAL_SIZE / 2;
        nextLast = nextFirst + 1;
    }

    private void resize(int newSize) {
        Type[] newItems = (Type[]) new Object[newSize];
        int newNextFirst = newSize / 2;
        int newNextLast = newNextFirst + 1;

        int startIndex = getNextIndex(nextFirst);
        int endIndex = nextLast;
        int count = 0;
        do {
            newItems[newNextLast] = items[startIndex];
            count++;
            startIndex = getNextIndex(startIndex);
            newNextLast = getNextIndex(newNextLast, newItems.length);
        } while (startIndex != endIndex && count <= size);

        items = newItems;
        nextFirst = newNextFirst;
        nextLast = newNextLast;
    }

    private int getNextIndex(int index, int length) {
        int lastIndex = length - 1;
        return index + 1 > lastIndex ? 0 : index + 1;
    }

    private int getPrevIndex(int index, int length) {
        int lastIndex = length - 1;
        return index - 1 < 0 ? lastIndex : index - 1;
    }

    private int getNextIndex(int index){
        return getNextIndex(index, items.length);
    }

    private int getPrevIndex(int index){
        return getPrevIndex(index, items.length);
    }

    public void addFirst(Type item) {
        if (size + 1 > items.length) {
            resize(size * 2);
        }

        items[nextFirst] = item;
        nextFirst = getPrevIndex(nextFirst);
        size++;
    }

    public void addLast(Type item) {
        if (size + 1 > items.length) {
            resize(size * 2);
        }

        items[nextLast] = item;
        nextLast = getNextIndex(nextLast);
        size++;
    }

    public Type removeFirst() {
        if (size - 1 < items.length * USAGE_FACTOR && items.length > INITIAL_SIZE * 2) {
            resize(items.length / 2);
        }

        Type itemToRemove = items[0];
        System.arraycopy(items, 1, items, 0, size);
        size--;
        return itemToRemove;
    }

    public void printDeque() {
        int startIndex = getNextIndex(nextFirst);
        int endIndex = nextLast;
        int count = 0;
        do {
            System.out.println(items[startIndex]);
            count++;
            startIndex = getNextIndex(startIndex);
        } while (startIndex != endIndex && count <= size);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size(){
        return size;
    }
}
