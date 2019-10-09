package laba2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TextSeparator {
    private static final String paragraphSeparator = "\\n+";
    private static final String beginSentenceSeparator = "([^.!?]+)";
    private static final String endSentenceSeparator = "([.!?]+)";
    private static final String excessTokens = "\\p{Punct}";
    private static final String excessSpaces = "\\s+";


    public static Text removeTabsAndExtraSpaces(Text text) {
        String str2 = text.getText().replaceAll(paragraphSeparator, "").replaceAll(excessSpaces, " ");
        text.setText(str2);
        return text;
    }


    public static List<Sentence> splitTextIntoSentences(Text text) {
        List<Sentence> sentences = new ArrayList<>();
        Matcher beginSentenceMatcher = Pattern.compile(beginSentenceSeparator).matcher(text.getText());
        Matcher endSentenceMatcher = Pattern.compile(endSentenceSeparator).matcher(text.getText());
        while (beginSentenceMatcher.find() & endSentenceMatcher.find()) {
            Sentence newSentence = new Sentence();
            newSentence.setSentence(beginSentenceMatcher.group() + endSentenceMatcher.group());
            sentences.add(newSentence);
        }
        return sentences;
    }


    public static List<Sentence> removeExcessTokensInSentences(List<Sentence> sentences) {
        for (Sentence sentence : sentences) {
            sentence.setSentence(removeExcessTokensInASentence(sentence.getSentence()).toLowerCase());
        }
        return sentences;
    }

    public static String removeExcessTokensInASentence(String sentence) {
        String temp = sentence.replaceAll(excessTokens, "");
        return temp.replaceAll(excessSpaces, "");
    }


    public static int findIndexOfSentenceWithPal(List<Sentence> list) {
        List<Integer> intList = new ArrayList<>();

        for (Sentence sentence : list) {
            intList.add(Palindrom.getLongestPalindrome(sentence.getSentence()).length());
        }
        int max = intList.stream()
                .max(Integer::compare)
                .get();
        return intList.indexOf(max);
    }


}
