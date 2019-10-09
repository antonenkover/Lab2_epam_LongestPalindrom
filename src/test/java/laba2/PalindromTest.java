package laba2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PalindromTest {

    private Palindrom palindrom;

    @Before
    public void setUp() {
        this.palindrom = new Palindrom();
    }

    @Test
    public void shouldReturnLongestPalindrom() {
        String input = "baaac";
        String result = "aaa";
        assertEquals(result, Palindrom.getLongestPalindrome(input));
    }

    @Test
    public void shouldNotFindPalindromWhenSpacesArePresent() {
        String input = "b a a a c";
        String result = "aaa";
        assertNotEquals(result, Palindrom.getLongestPalindrome(input));
    }

    @Test
    public void shouldReturnEmptyStringWhenEmptyStringEntered() {
        String result = "";
        assertEquals(result, Palindrom.getLongestPalindrome(""));
    }

}
