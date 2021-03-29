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
        System.out.println("addFirst " + item);
        ListNode prevFirst = sentinel.next;
        ListNode newListNode = new ListNode(item, sentinel, prevFirst);

        if (sentinel.prev == null) {
            sentinel.prev = newListNode;
        }

        sentinel.next = newListNode;
        size++;
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
