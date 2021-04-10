public class OffByN implements CharacterComparator {

    private static int offset;

    public OffByN(int N) {
        offset = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        return diff == offset || diff == -offset;
    }
}
