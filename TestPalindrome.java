import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator offtest = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        String one = "racecar";
        String two = "a";
        String three = "";
        String four = "hello";
        String five = "hug";
        String six = "tellet";
        String seven = "racecaR";
        String eight = "aa";
        String nine = "Racecar";
        assertTrue(palindrome.isPalindrome(one));
        assertTrue(palindrome.isPalindrome(two));
        assertTrue(palindrome.isPalindrome(three));
        assertFalse(palindrome.isPalindrome(four));
        assertFalse(palindrome.isPalindrome(five));
        assertTrue(palindrome.isPalindrome(six));
        assertFalse(palindrome.isPalindrome(seven));
        assertTrue(palindrome.isPalindrome(eight));
        assertFalse(palindrome.isPalindrome(nine));
    }

    @Test
    public void testIsOffPalindrome() {
        String one = "stust";
        String two = "racecar";
        String three = "";
        String four = "hello";
        String five = "abcdcb";
        String six = "BtlikSa";
        String seven = "vvvv";
        String eight = "abcba";
        String nine = "ABCDDCB";
        String ten = "dertrude";
        String eleven = "FLAKE";
        String twelve = "%&";
        String thirteen = "Flake";
        String fourteen = "ba";
        String fifteen = "a";
        String sixteen = "flake";
        String seventeen = "Ab";
        String eighteen = "abctsdab";
        String nineteen = "aBctsdab";
        assertTrue(palindrome.isPalindrome(one, offtest));
        assertTrue(palindrome.isPalindrome(three, offtest));
        assertTrue(palindrome.isPalindrome(five, offtest));
        assertFalse(palindrome.isPalindrome(two, offtest));
        assertFalse(palindrome.isPalindrome(four, offtest));
        assertFalse(palindrome.isPalindrome(six, offtest));
        assertFalse(palindrome.isPalindrome(seven, offtest));
        assertFalse(palindrome.isPalindrome(eight, offtest));
        assertTrue(palindrome.isPalindrome(nine, offtest));
        assertFalse(palindrome.isPalindrome(ten, offtest));
        assertTrue(palindrome.isPalindrome(eleven, offtest));
        assertTrue(palindrome.isPalindrome(twelve, offtest));
        assertFalse(palindrome.isPalindrome(thirteen, offtest));
        assertTrue(palindrome.isPalindrome(fourteen, offtest));
        assertTrue(palindrome.isPalindrome(fifteen, offtest));
        assertTrue(palindrome.isPalindrome(sixteen, offtest));
        assertFalse(palindrome.isPalindrome(seventeen, offtest));
        assertTrue(palindrome.isPalindrome(eighteen, offtest));
        assertFalse(palindrome.isPalindrome(nineteen, offtest));
    }
}
