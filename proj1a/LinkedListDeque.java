import java.util.List;

public class LinkedListDeque<Type> {

    private class ListNode {
        Type item;
        ListNode next;
        ListNode prev;

        ListNode(Type item, ListNode prev, ListNode next) {
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

    public void addFirst(Type item) {
        size++;

        ListNode prevFirst = sentinel.next;
        ListNode nodeToAdd = new ListNode(item, sentinel, prevFirst);

        prevFirst.prev = nodeToAdd;
        sentinel.next = nodeToAdd;
    }

    public void addLast(Type item) {
        size++;

        ListNode prevLast = sentinel.prev;
        ListNode nodeToAdd = new ListNode(item, prevLast, sentinel);

        prevLast.next = nodeToAdd;
        sentinel.prev = nodeToAdd;
    }

    public Type removeFirst() {
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

    public Type removeLast() {
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


    public void printDeque() {
        ListNode cur = sentinel;

        do {
            System.out.println(cur);
            cur = cur.next;
        } while (!cur.equals(sentinel));
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
