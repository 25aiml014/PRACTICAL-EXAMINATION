import java.util.*;

class NoticeCleaner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        String keyword = sc.nextLine();

        String cleaned = cleanSentence(sentence);
        String[] words = cleaned.split("\\s+");
        int wordCount = words.length;

        String shortestWord = words[0].toLowerCase();
        for (String w : words) {
            String low = w.toLowerCase();
            if (low.length() < shortestWord.length()) {
                shortestWord = low;
            }
        }

        int keywordCount = 0;
        for (String w : words) {
            if (w.equalsIgnoreCase(keyword)) {
                keywordCount++;
            }
        }

        int vowelCount = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                vowelCount++;
            }
        }

        System.out.println("Sentence: " + cleaned);
        System.out.println("Words: " + wordCount);
        System.out.println("Shortest word: " + shortestWord);
        System.out.println("Keyword count: " + keywordCount);
        System.out.println("Vowels: " + vowelCount);
    }

    static String cleanSentence(String sentence) {
        String trimmed = sentence.trim();
        String[] tokens = trimmed.split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tokens.length; i++) {
            String word = tokens[i].toLowerCase();
            if (i == 0) {
                word = Character.toUpperCase(word.charAt(0)) + word.substring(1);
            }
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(word);
        }

        return sb.toString();
    }
}
