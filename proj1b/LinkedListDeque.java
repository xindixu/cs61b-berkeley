public class LinkedListDeque<T> implements Deque<T>  {

    private class ListNode {
        T item;
        ListNode next;
        ListNode prev;

        ListNode(T item, ListNode prev, ListNode next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

        public String toString() {
            return item == null ? "null" : item.toString();
        }
    }

    private int size;
    private ListNode sentinel;

    public LinkedListDeque() {
        size = 0;
        sentinel = new ListNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    @Override
    public void addFirst(T item) {
        size++;

        ListNode prevFirst = sentinel.next;
        ListNode nodeToAdd = new ListNode(item, sentinel, prevFirst);

        prevFirst.prev = nodeToAdd;
        sentinel.next = nodeToAdd;
    }

    @Override
    public void addLast(T item) {
        size++;

        ListNode prevLast = sentinel.prev;
        ListNode nodeToAdd = new ListNode(item, prevLast, sentinel);

        prevLast.next = nodeToAdd;
        sentinel.prev = nodeToAdd;
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        size--;

        ListNode nodeToRemove = sentinel.next;
        ListNode newFirst = nodeToRemove.next;
        sentinel.next = newFirst;
        newFirst.prev = sentinel;

        return nodeToRemove.item;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }

        size--;

        ListNode nodeToRemove = sentinel.prev;
        ListNode newLast = nodeToRemove.prev;

        sentinel.prev = newLast;
        newLast.next = sentinel;

        return nodeToRemove.item;
    }

    @Override
    public T get(int i) {
        if (i > size || i < 0) {
            return null;
        }

        ListNode cur = sentinel.next;
        for (int j = 0; j < i; j++) {
            cur = cur.next;
        }
        return cur.item;
    }

    private T getRecursiveHelper(int i, ListNode cur) {
        if (i == 0) {
            return cur.item;
        }
        return getRecursiveHelper(i - 1, cur.next);
    }

    public T getRecursive(int i) {
        if (i > size || i < 0) {
            return null;
        }

        return getRecursiveHelper(i, sentinel.next);
    }

    @Override
    public void printDeque() {
        ListNode cur = sentinel;

        for (int i = 0; i < size; i++) {
            cur = cur.next;
            System.out.println(cur);
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
