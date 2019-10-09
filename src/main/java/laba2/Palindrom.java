package laba2;

public class Palindrom {
    public static String getLongestPalindrome(String inputString) {
        if (inputString.length() == 0)
            return "";
        int palindromeStart = -1;
        int palindromeEnd = -2;
        for (int i = 0; i < inputString.length(); i++) {
            for (int palindromType = 0; palindromType <= 1; palindromType++) {
                int start;
                int end;
                if (palindromType == 0) {
                    start = i;
                    end = i;
                } else if (i < inputString.length() - 1) {
                    start = i + 1;
                    end = i;
                } else
                    break;
                while ((start - 1 >= 0) && (end + 1 < inputString.length())) {
                    if (inputString.charAt(start - 1) == inputString.charAt(end + 1)) {
                        start--;
                        end++;
                    } else
                        break;
                }
                if (end - start > palindromeEnd - palindromeStart) {
                    palindromeStart = start;
                    palindromeEnd = end;
                }
            }
        }
        return inputString.substring(palindromeStart, palindromeEnd + 1);
    }
}
