import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class PalindromeChecker {

    private String normalizeInput(String text) {
        return text.replaceAll("\\s+", "").toLowerCase();
    }

    public boolean checkPalindrome(String text) {
        String normalized = normalizeInput(text);
        char[] chars = normalized.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : chars) {
            stack.push(ch);
        }

        for (char ch : chars) {
            if (stack.pop() != ch) {
                return false;
            }
        }

        return true;
    }

    public String getNormalizedText(String text) {
        return normalizeInput(text);
    }
}

public class UseCase11PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PalindromeChecker palindromeChecker = new PalindromeChecker();

        System.out.println("==================================================");
        System.out.println("UC11: Object-Oriented Palindrome Service");
        System.out.println("==================================================");
        System.out.print("Enter a word or phrase to check: ");

        String userInput = scanner.nextLine();

        if (userInput.trim().isEmpty()) {
            System.out.println("Error: Input cannot be empty!");
            scanner.close();
            return;
        }

        String normalized = palindromeChecker.getNormalizedText(userInput);
        boolean isPalindrome = palindromeChecker.checkPalindrome(userInput);

        System.out.println("\n--- Normalized Input ---");
        System.out.println("Original: \"" + userInput + "\"");
        System.out.println("Normalized (no spaces, lowercase): \"" + normalized + "\"");

        System.out.println("\n==================================================");
        System.out.println("Result: \"" + userInput + "\" is "
            + (isPalindrome ? "a PALINDROME!" : "NOT a palindrome."));
        System.out.println("==================================================");

        scanner.close();
    }
}
