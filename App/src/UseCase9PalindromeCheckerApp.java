import java.util.Scanner;

public class UseCase9PalindromeCheckerApp {

    private static String normalizeInput(String text) {
        return text.replaceAll("\\s+", "").toLowerCase();
    }

    private static boolean recursiveCheck(String text, int start, int end, int depth) {
        String indent = "  ".repeat(depth);
        System.out.println(indent + "Call -> start=" + start + ", end=" + end);

        // Base condition: all character pairs are checked.
        if (start >= end) {
            System.out.println(indent + "Base condition met (start >= end). Return true");
            return true;
        }

        char left = text.charAt(start);
        char right = text.charAt(end);
        System.out.println(indent + "Compare '" + left + "' and '" + right + "'");

        if (left != right) {
            System.out.println(indent + "Mismatch found. Return false");
            return false;
        }

        System.out.println(indent + "Match found. Recurse inward");
        return recursiveCheck(text, start + 1, end - 1, depth + 1);
    }

    // UC9: Recursion-based palindrome check.
    public static boolean isPalindromeUsingRecursion(String text) {
        String cleanText = normalizeInput(text);
        return recursiveCheck(cleanText, 0, cleanText.length() - 1, 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("UC9: Recursive Palindrome Checker");
        System.out.println("==================================================");
        System.out.print("Enter a word or phrase to check: ");
        String userInput = scanner.nextLine();

        if (userInput.trim().isEmpty()) {
            System.out.println("Error: Input cannot be empty!");
            scanner.close();
            return;
        }

        System.out.println("\nInput: \"" + userInput + "\"");
        System.out.println("\n--- Recursive Call Stack Trace ---");
        boolean result = isPalindromeUsingRecursion(userInput);

        System.out.println("\n==================================================");
        System.out.println("Result: \"" + userInput + "\" is "
            + (result ? "a PALINDROME!" : "NOT a palindrome."));
        System.out.println("==================================================");

        scanner.close();
    }
}