package laba2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextSeparatorTest {

    private TextSeparator textSeparator;

    @Before
    public void setUp() {
        this.textSeparator = new TextSeparator();
    }

    @Test
    public void shouldReplaceTabsAndExtraSpacesWithOneSpace() {
        String input = "h   e   l  \n   l        o \n";
        Text text = new Text(input);
        assertEquals("h e l l o ", TextSeparator.removeTabsAndExtraSpaces(text).getText());
    }

    @Test
    public void shouldRemoveAllExcessTokens() {
        String input = "h--- e, , , l:, +l o";
        assertEquals("hello", TextSeparator.removeExcessTokensInASentence(input));
    }
}
