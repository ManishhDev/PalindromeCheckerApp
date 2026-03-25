import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

interface PalindromeStrategy {
    String getStrategyName();
    boolean isPalindrome(String text);
}

class StackStrategy implements PalindromeStrategy {

    @Override
    public String getStrategyName() {
        return "Stack Strategy (LIFO)";
    }

    @Override
    public boolean isPalindrome(String text) {
        Stack<Character> stack = new Stack<>();

        for (char ch : text.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : text.toCharArray()) {
            if (stack.pop() != ch) {
                return false;
            }
        }

        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {

    @Override
    public String getStrategyName() {
        return "Deque Strategy (Two-End Comparison)";
    }

    @Override
    public boolean isPalindrome(String text) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : text.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            char left = deque.removeFirst();
            char right = deque.removeLast();

            if (left != right) {
                return false;
            }
        }

        return true;
    }
}

public class UseCase12PalindromeCheckerApp {

    private static String normalizeInput(String input) {
        return input.replaceAll("\\s+", "").toLowerCase();
    }

    private static PalindromeStrategy chooseStrategy(int option) {
        if (option == 1) {
            return new StackStrategy();
        }
        return new DequeStrategy();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("UC12: Strategy Pattern for Palindrome Algorithms");
        System.out.println("==================================================");
        System.out.println("Choose algorithm strategy:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.print("Enter your choice (1 or 2): ");

        int choice;
        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
            scanner.nextLine();
        } else {
            System.out.println("Invalid choice. Defaulting to Deque Strategy.");
            choice = 2;
            scanner.nextLine();
        }

        if (choice != 1 && choice != 2) {
            System.out.println("Invalid choice. Defaulting to Deque Strategy.");
            choice = 2;
        }

        PalindromeStrategy strategy = chooseStrategy(choice);

        System.out.print("Enter a word or phrase to check: ");
        String userInput = scanner.nextLine();

        if (userInput.trim().isEmpty()) {
            System.out.println("Error: Input cannot be empty!");
            scanner.close();
            return;
        }

        String normalizedInput = normalizeInput(userInput);
        boolean result = strategy.isPalindrome(normalizedInput);

        System.out.println("\n--- Strategy Details ---");
        System.out.println("Selected Strategy: " + strategy.getStrategyName());
        System.out.println("Original Input: \"" + userInput + "\"");
        System.out.println("Normalized Input: \"" + normalizedInput + "\"");

        System.out.println("\n==================================================");
        System.out.println("Result: \"" + userInput + "\" is "
            + (result ? "a PALINDROME!" : "NOT a palindrome."));
        System.out.println("==================================================");

        scanner.close();
    }
}
