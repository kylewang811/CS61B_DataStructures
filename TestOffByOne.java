import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testOffByOne() {
        char one = 'A';
        char two = 'a';
        char three = 'c';
        char four = 'z';
        char five = 'B';
        char six = ' ';
        char seven = 'A';
        char eight = '&';
        char nine = '%';
        char ten = 'b';
        assertTrue(offByOne.equalChars(one, five));
        assertFalse(offByOne.equalChars(one, two));
        assertFalse(offByOne.equalChars(one, three));
        assertFalse(offByOne.equalChars(one, four));
        assertFalse(offByOne.equalChars(one, six));
        assertFalse(offByOne.equalChars(one, seven));
        assertTrue(offByOne.equalChars(eight, nine));
        assertFalse(offByOne.equalChars(two, five));
        assertFalse(offByOne.equalChars(seven, ten));
        assertFalse(offByOne.equalChars(five, ten));
    }
}
