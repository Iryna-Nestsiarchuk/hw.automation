package example;

public class StringOperations {

    public int countWords(String line) {
        String[] words = line.split("\\W+");
        return words.length;
    }

    public String longestWord(String line) {
        String[] words = line.split("\\W+");
        String longestWord = words[0];
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > longestWord.length()) {
                longestWord = words[i];
            }
        }
        return longestWord;
    }

    public String reverse(String line) {
        String reversedString = "";
        for (int i = line.length() - 1; i >= 0; i--) {
            reversedString = reversedString + line.charAt(i);
        }
        return reversedString;
    }

    public boolean isFirstVowel(String line) {
        String firstSymbol = String.valueOf(line.charAt(0));
        return firstSymbol.matches("[eyuioaEYUIOA]");
    }

    public Integer convertToNumber(String line) {
        return Integer.parseInt(line);
    }
}
