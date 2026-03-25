import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class UseCase13PalindromeCheckerApp {

    private static String normalizeInput(String text) {
        return text.replaceAll("\\s+", "").toLowerCase();
    }

    // Algorithm 1: Two-pointer character array comparison.
    private static boolean isPalindromeTwoPointer(String text) {
        char[] chars = text.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    // Algorithm 2: Stack-based reverse comparison.
    private static boolean isPalindromeUsingStack(String text) {
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

    // Algorithm 3: Deque two-end comparison.
    private static boolean isPalindromeUsingDeque(String text) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : text.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }

    private static long benchmarkTwoPointer(String text, int iterations) {
        long startTime = System.nanoTime();

        for (int i = 0; i < iterations; i++) {
            isPalindromeTwoPointer(text);
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long benchmarkStack(String text, int iterations) {
        long startTime = System.nanoTime();

        for (int i = 0; i < iterations; i++) {
            isPalindromeUsingStack(text);
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long benchmarkDeque(String text, int iterations) {
        long startTime = System.nanoTime();

        for (int i = 0; i < iterations; i++) {
            isPalindromeUsingDeque(text);
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static void printPerformanceTable(long twoPointerNs, long stackNs, long dequeNs, int iterations) {
        System.out.println("\n============================================================");
        System.out.println("UC13: Performance Comparison (System.nanoTime)");
        System.out.println("============================================================");
        System.out.println("Iterations per algorithm: " + iterations);
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-25s %15s %15s%n", "Algorithm", "Total (ns)", "Avg/Run (ns)");
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-25s %15d %15.2f%n", "Two Pointer", twoPointerNs, (double) twoPointerNs / iterations);
        System.out.printf("%-25s %15d %15.2f%n", "Stack", stackNs, (double) stackNs / iterations);
        System.out.printf("%-25s %15d %15.2f%n", "Deque", dequeNs, (double) dequeNs / iterations);
        System.out.println("------------------------------------------------------------");

        String fastest = "Two Pointer";
        long bestTime = twoPointerNs;

        if (stackNs < bestTime) {
            fastest = "Stack";
            bestTime = stackNs;
        }

        if (dequeNs < bestTime) {
            fastest = "Deque";
            bestTime = dequeNs;
        }

        System.out.println("Fastest (for this input/run): " + fastest);
        System.out.println("============================================================");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("============================================================");
        System.out.println("Palindrome Checker App - UC13: Performance Comparison");
        System.out.println("============================================================");
        System.out.print("Enter a word or phrase to check: ");
        String userInput = scanner.nextLine();

        if (userInput.trim().isEmpty()) {
            System.out.println("Error: Input cannot be empty!");
            scanner.close();
            return;
        }

        String normalizedInput = normalizeInput(userInput);
        int iterations = 200000;

        // Warm-up run to reduce one-time JIT impact.
        benchmarkTwoPointer(normalizedInput, 1000);
        benchmarkStack(normalizedInput, 1000);
        benchmarkDeque(normalizedInput, 1000);

        boolean resultTwoPointer = isPalindromeTwoPointer(normalizedInput);
        boolean resultStack = isPalindromeUsingStack(normalizedInput);
        boolean resultDeque = isPalindromeUsingDeque(normalizedInput);

        long twoPointerTime = benchmarkTwoPointer(normalizedInput, iterations);
        long stackTime = benchmarkStack(normalizedInput, iterations);
        long dequeTime = benchmarkDeque(normalizedInput, iterations);

        System.out.println("\n--- Input Details ---");
        System.out.println("Original Input: \"" + userInput + "\"");
        System.out.println("Normalized Input: \"" + normalizedInput + "\"");

        System.out.println("\n--- Correctness Check ---");
        System.out.println("Two Pointer Result: " + resultTwoPointer);
        System.out.println("Stack Result:       " + resultStack);
        System.out.println("Deque Result:       " + resultDeque);

        if (resultTwoPointer != resultStack || resultStack != resultDeque) {
            System.out.println("Warning: Algorithm results do not match. Please review implementation.");
        }

        printPerformanceTable(twoPointerTime, stackTime, dequeTime, iterations);

        System.out.println("Final Verdict: \"" + userInput + "\" is "
            + (resultTwoPointer ? "a PALINDROME!" : "NOT a palindrome."));

        scanner.close();
    }
}
