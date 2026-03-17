import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class UseCase7PalindromeCheckerApp {

    private static String normalizeInput(String text) {
        return text.replaceAll("\\s+", "").toLowerCase();
    }

    // UC7: Deque-based palindrome check using front and rear comparison.
    public static boolean isPalindromeUsingDeque(String text) {
        String cleanText = normalizeInput(text);
        Deque<Character> deque = new ArrayDeque<>();

        System.out.println("\n--- Inserting Characters Into Deque ---");
        for (int i = 0; i < cleanText.length(); i++) {
            char ch = cleanText.charAt(i);
            deque.addLast(ch);
            System.out.println("Inserted '" + ch + "' at rear -> Deque: " + deque);
        }

        System.out.println("\n--- Comparing Front and Rear ---");
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            System.out.printf("Front='%c' | Rear='%c' -> %s%n",
                front,
                rear,
                (front == rear ? "MATCH" : "MISMATCH"));

            if (front != rear) {
                return false;
            }
        }

        if (!deque.isEmpty()) {
            System.out.println("Middle character remains: '" + deque.peekFirst() + "' (ignored)");
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("UC7: Deque-Based Optimized Palindrome Checker");
        System.out.println("==================================================");
        System.out.print("Enter a word or phrase to check: ");
        String userInput = scanner.nextLine();

        if (userInput.trim().isEmpty()) {
            System.out.println("Error: Input cannot be empty!");
            scanner.close();
            return;
        }

        System.out.println("\nInput: \"" + userInput + "\"");
        boolean result = isPalindromeUsingDeque(userInput);

        System.out.println("\n==================================================");
        System.out.println("Result: \"" + userInput + "\" is "
            + (result ? "a PALINDROME!" : "NOT a palindrome."));
        System.out.println("==================================================");

        scanner.close();
    }
}