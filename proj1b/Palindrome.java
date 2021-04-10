public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> queue = new LinkedListDeque<>();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            queue.addLast(c);
        }

        return queue;
    }
}
