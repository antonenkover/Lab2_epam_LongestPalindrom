package laba2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserInputService {

    public static void initInputService() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write a path to the file in which you want to find the longest palindrome : ");
        String input = scanner.nextLine();
        try (BufferedReader buffer = new BufferedReader(new FileReader(input))) {
            String text = buffer.lines().collect(Collectors.joining("\n"));
            if (text == null || text.isEmpty()) {
                System.out.println("File is empty. Try another file.\n");
                initInputService();
            }
            buffer.close();
            Text inputText = new Text(text);
            initPalindromSearch(inputText);
        } catch (IOException e) {
            System.out.println("Invalid file path.\n");
            initInputService();
        }
    }

    public static void initPalindromSearch(Text text) {
        Text textWithNoSpaces = TextSeparator.removeTabsAndExtraSpaces(text);
        List<Sentence> sentencesToBeModified = TextSeparator.splitTextIntoSentences(textWithNoSpaces);
        List<Sentence> sentencesUnchanged = TextSeparator.splitTextIntoSentences(textWithNoSpaces);
        List<Sentence> modifiedSentences = TextSeparator.removeExcessTokensInSentences(sentencesToBeModified);
        int index = TextSeparator.findIndexOfSentenceWithPal(modifiedSentences);
        OutputService.initOutput(index, sentencesUnchanged, modifiedSentences);
    }
}