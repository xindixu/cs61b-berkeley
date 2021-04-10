public class ArrayDequeTest {
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
        ArrayDeque<String> l = new ArrayDeque<>();
        System.out.println(l.size());
    }

    public static void addFirstTest() {
        System.out.println("Running addFirstTest.");
        ArrayDeque<String> ad1 = new ArrayDeque<>();

        boolean passed = checkEmpty(true, ad1.isEmpty());

        for (int i = 0; i < 13; i++) {
            ad1.addFirst("first " + i);
        }

        passed = checkSize(13, ad1.size()) && passed;

        System.out.println("Printing out deque: ");
        ad1.printDeque();

        printTestStatus(passed);
    }

    public static void addLastTest() {
        System.out.println("Running addLastTest.");
        ArrayDeque<String> ad1 = new ArrayDeque<>();

        boolean passed = checkEmpty(true, ad1.isEmpty());

        for (int i = 0; i < 26; i++) {
            ad1.addLast("last " + i);
        }

        passed = checkSize(26, ad1.size()) && passed;


        System.out.println("Printing out deque: ");
        ad1.printDeque();

        printTestStatus(passed);
    }

    public static void removeFirstTest() {
        System.out.println("Running removeFirstTest.");
        ArrayDeque<String> ad1 = new ArrayDeque<>();

        boolean passed = checkEmpty(true, ad1.isEmpty());

        for (int i = 0; i < 90; i++) {
            ad1.addLast("last " + i);
        }

        passed = checkSize(90, ad1.size()) && passed;

        for (int i = 0; i < 80; i++) {
            ad1.removeFirst();
        }

        passed = checkSize(10, ad1.size()) && passed;

        for (int i = 0; i < 20; i++) {
            ad1.removeFirst();
        }

        passed = checkSize(0, ad1.size()) && passed;

        System.out.println("Printing out deque: ");
        ad1.printDeque();

        printTestStatus(passed);
    }

    public static void removeLastTest() {
        System.out.println("Running removeLastTest.");
        ArrayDeque<String> ad1 = new ArrayDeque<>();

        boolean passed = checkEmpty(true, ad1.isEmpty());

        for (int i = 0; i < 90; i++) {
            ad1.addLast("last " + i);
        }

        passed = checkSize(90, ad1.size()) && passed;


        for (int i = 0; i < 80; i++) {
            ad1.removeLast();
        }

        passed = checkSize(10, ad1.size()) && passed;

        System.out.println("Printing out deque: ");
        ad1.printDeque();

        printTestStatus(passed);
    }

    public static void getTest() {
        System.out.println("Running getTest.");
        ArrayDeque<String> ad1 = new ArrayDeque<>();

        boolean passed = checkEmpty(true, ad1.isEmpty());

        for (int i = 0; i < 10; i++) {
            ad1.addLast("last " + i);
        }

        passed = checkSize(10, ad1.size()) && passed;
        passed = checkEqual("last 2", ad1.get(2)) && passed;

        System.out.println("Printing out deque: ");
        ad1.printDeque();

        printTestStatus(passed);
    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        constructorTest();
        addFirstTest();
        addLastTest();
        removeFirstTest();
        removeLastTest();
        getTest();
    }
}
