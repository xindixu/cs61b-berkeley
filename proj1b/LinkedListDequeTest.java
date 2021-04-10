/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkEqual(String expected, String actual) {
        if (!expected.equals(actual)) {
            System.out.println("returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }


    /* Prints a nice message based on whether a test passed.
     * The \n means newline. */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    public static void constructorTest() {
        LinkedListDeque<String> l = new LinkedListDeque<>();
        System.out.println(l.size());
    }

//    public static void deepCopyConstructorTest() {
//        LinkedListDeque<String> lld1 = new LinkedListDeque<>();
//        lld1.addFirst("first 3");
//        lld1.addFirst("first 2");
//        lld1.addFirst("first 1");
//
//        LinkedListDeque<String> lld2 = new LinkedListDeque<>(lld1);
//        System.out.println("Printing out deque: ");
//        lld2.printDeque();
//    }

    public static void addFirstTest() {
        System.out.println("Running addFirstTest.");
        LinkedListDeque<String> lld1 = new LinkedListDeque<>();

        boolean passed = checkEmpty(true, lld1.isEmpty());
        lld1.addFirst("first 3");
        lld1.addFirst("first 2");
        lld1.addFirst("first 1");

        passed = checkSize(3, lld1.size()) && passed;

        System.out.println("Printing out deque: ");
        lld1.printDeque();

        printTestStatus(passed);
    }

    public static void addLastTest() {
        System.out.println("Running addLastTest.");
        LinkedListDeque<String> lld1 = new LinkedListDeque<>();

        boolean passed = checkEmpty(true, lld1.isEmpty());
        lld1.addLast("last 1");
        lld1.addLast("last 2");
        lld1.addLast("last 3");

        passed = checkSize(3, lld1.size()) && passed;

        System.out.println("Printing out deque: ");
        lld1.printDeque();

        printTestStatus(passed);
    }

    public static void removeFirstTest() {
        System.out.println("Running removeFirstTest.");
        LinkedListDeque<String> lld1 = new LinkedListDeque<>();

        boolean passed = checkEmpty(true, lld1.isEmpty());
        lld1.addLast("last 1");
        lld1.addLast("last 2");
        lld1.addLast("last 3");

        passed = checkSize(3, lld1.size()) && passed;

        lld1.removeFirst();
        lld1.removeFirst();
        lld1.removeFirst();

        passed = checkSize(0, lld1.size()) && passed;
        System.out.println("Printing out deque: ");
        lld1.printDeque();

        printTestStatus(passed);
    }

    public static void removeLastTest() {
        System.out.println("Running removeLastTest.");
        LinkedListDeque<String> lld1 = new LinkedListDeque<>();

        boolean passed = checkEmpty(true, lld1.isEmpty());
        lld1.addLast("last 1");
        lld1.addLast("last 2");
        lld1.addLast("last 3");

        passed = checkSize(3, lld1.size()) && passed;

        lld1.removeLast();
        lld1.removeLast();
        lld1.removeLast();

        passed = checkSize(0, lld1.size()) && passed;
        System.out.println("Printing out deque: ");
        lld1.printDeque();

        printTestStatus(passed);
    }

    public static void getTest() {
        System.out.println("Running getTest.");
        LinkedListDeque<String> lld1 = new LinkedListDeque<>();

        boolean passed = checkEmpty(true, lld1.isEmpty());
        lld1.addLast("last 1");
        lld1.addLast("last 2");
        lld1.addLast("last 3");

        passed = checkEqual("last 3", lld1.get(2)) && passed;
        passed = lld1.get(3) == null && passed;
        passed = lld1.get(-1) == null && passed;

        printTestStatus(passed);
    }

    public static void getRecursiveTest() {
        System.out.println("Running getRecursiveTest.");
        LinkedListDeque<String> lld1 = new LinkedListDeque<>();

        boolean passed = checkEmpty(true, lld1.isEmpty());
        lld1.addLast("last 1");
        lld1.addLast("last 2");
        lld1.addLast("last 3");

        passed = checkEqual("last 2", lld1.getRecursive(1)) && passed;
        passed = lld1.get(3) == null && passed;
        passed = lld1.get(-1) == null && passed;

        printTestStatus(passed);
    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        constructorTest();
//        deepCopyConstructorTest();
        addFirstTest();
        addLastTest();
        removeFirstTest();
        removeLastTest();
        getTest();
        getRecursiveTest();
    }
}
