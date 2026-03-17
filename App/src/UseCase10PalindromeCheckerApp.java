import java.util.Scanner;

public class UseCase10PalindromeCheckerApp {

    // UC10: Ignore spaces and case using regex preprocessing.
    private static String normalizeInput(String text) {
        return text.replaceAll("\\s+", "").toLowerCase();
    }

    // Reuses previous comparison logic with a char array.
    public static boolean isPalindromeIgnoreCaseAndSpaces(String text) {
        String cleanText = normalizeInput(text);
        char[] chars = cleanText.toCharArray();

        System.out.println("\n--- Normalized Input ---");
        System.out.println("Original: \"" + text + "\"");
        System.out.println("Normalized (no spaces, lowercase): \"" + cleanText + "\"");

        int left = 0;
        int right = chars.length - 1;

        System.out.println("\n--- Character Comparison ---");
        while (left < right) {
            System.out.printf("Compare '%c' and '%c' -> %s%n",
                chars[left],
                chars[right],
                (chars[left] == chars[right] ? "MATCH" : "MISMATCH"));

            if (chars[left] != chars[right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("UC10: Case-Insensitive & Space-Ignored Palindrome");
        System.out.println("==================================================");
        System.out.print("Enter a word or phrase to check: ");
        String userInput = scanner.nextLine();

        if (userInput.trim().isEmpty()) {
            System.out.println("Error: Input cannot be empty!");
            scanner.close();
            return;
        }

        boolean result = isPalindromeIgnoreCaseAndSpaces(userInput);

        System.out.println("\n==================================================");
        System.out.println("Result: \"" + userInput + "\" is "
            + (result ? "a PALINDROME!" : "NOT a palindrome."));
        System.out.println("==================================================");

        scanner.close();
    }
}
