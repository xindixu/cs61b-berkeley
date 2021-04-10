public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> queue = new LinkedListDeque<>();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            queue.addLast(c);
        }

        return queue;
    }


    private boolean isPalindrome(Deque<Character> queue) {
        int size = queue.size();
        if (size == 0 || size == 1) {
            return true;
        }

        char first = queue.removeFirst();
        char last = queue.removeLast();
        if (first == last) {
            return isPalindrome(queue);
        }
        return false;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> queue = wordToDeque(word);
        return isPalindrome(queue);
    }

    private boolean isPalindrome(Deque<Character> queue, CharacterComparator cc) {
        int size = queue.size();
        if (size == 0 || size == 1) {
            return true;
        }

        char first = queue.removeFirst();
        char last = queue.removeLast();
        if (cc.equalChars(first, last)) {
            return isPalindrome(queue, cc);
        }
        return false;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> queue = wordToDeque(word);
        return isPalindrome(queue, cc);
    }

}
