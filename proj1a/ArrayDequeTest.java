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
        ad1.addFirst("first 3");
        ad1.addFirst("first 2");
        ad1.addFirst("first 1");

        passed = checkSize(3, ad1.size()) && passed;

        System.out.println("Printing out deque: ");
        ad1.printDeque();

        printTestStatus(passed);
    }


    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        constructorTest();
//        deepCopyConstructorTest();
        addFirstTest();
//        addLastTest();
//        removeFirstTest();
//        removeLastTest();
//        getTest();
//        getRecursiveTest();
    }
}
