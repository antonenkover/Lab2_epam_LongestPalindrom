package laba2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static laba2.TextSeparator.removeExcessTokensInASentence;

public class OutputService {

    public static void initOutput(int index, List<Sentence> inputClean, List<Sentence> input) {
        System.out.println(String.format("The longest palindrom was found in a sentence:\n%s\nPalindrom is:\n%s",
                returnSentenceWithPal(index, inputClean),
                findOriginalStringWithPal(index, inputClean, input)));
    }

    public static String returnSentenceWithPal(int index, List<Sentence> inputClean) {
        String sentence = inputClean.get(index).getSentence();
        return sentence.trim();
    }


    public static String findOriginalStringWithPal(int index, List<Sentence> inputClean, List<Sentence> input) {
        String sentenceWithPal = inputClean.get(index).getSentence().trim();
        String sentenceWithPalInLowCase = inputClean.get(index).getSentence().toLowerCase().trim();
        String palString = Palindrom.getLongestPalindrome(input.get(index).getSentence());

        Matcher matcher = Pattern.compile("" + palString.charAt(0)).matcher(sentenceWithPalInLowCase);
        List<Integer> posOfPalFirstLetterEnter = new ArrayList<>();
        while (matcher.find()) {
            posOfPalFirstLetterEnter.add(matcher.start());
        }

        List<Integer> posOfPalEnter = new ArrayList<>();
        for (int position : posOfPalFirstLetterEnter) {
            String str = removeExcessTokensInASentence(sentenceWithPalInLowCase.substring(position));
            if (str.contains(palString))
                posOfPalEnter.add(position);
        }

        int size = posOfPalEnter.size();
        int indexOfEntry = posOfPalFirstLetterEnter.get(size - 1);
        String resultString = "";
        List<Integer> newList = new ArrayList<>(posOfPalFirstLetterEnter.subList(posOfPalFirstLetterEnter.indexOf(indexOfEntry), posOfPalFirstLetterEnter.size()));
        for (int i : newList) {
            String str = removeExcessTokensInASentence(sentenceWithPalInLowCase.substring(indexOfEntry, i + 1));
            if (str.contains(palString)) {
                resultString = sentenceWithPal.substring(indexOfEntry, i + 1);
                break;
            }
        }
        return resultString;
    }
}
