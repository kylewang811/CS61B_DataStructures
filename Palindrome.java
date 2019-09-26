public class Palindrome {

    public Deque<Character> wordToDeque(String word) {

        Deque<Character> letters = new ArrayDeque<Character>();

        for (int i = 0; i < word.length(); i++) {
            letters.addLast(word.charAt(i));
        }

        return letters;
    }

    public boolean isPalindrome(String word) {

        if (word.length() <= 1) {
            return true;
        }

        for (int i = 0; i < word.length(); i++) {
            int j = word.length() - 1 - i;
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {

        if (word.length() <= 1) {
            return true;
        }

        for (int i = 0; i < (word.length() / 2); i++) {
            int j = word.length() - 1 - i;
            if (!cc.equalChars(word.charAt(i), word.charAt(j))) {
                return false;
            }
        }
        return true;
    }
}
