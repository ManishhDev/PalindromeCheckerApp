import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {
    
    // UC1: Application Entry & Welcome Message
    public void displayWelcomeMessage() {
        System.out.println("========================================");
        System.out.println("   WELCOME TO PALINDROME CHECKER APP   ");
        System.out.println("========================================");
        System.out.println("This application checks if a word or");
        System.out.println("phrase is a palindrome.");
        System.out.println("========================================");
    }
    
    // UC2: Hardcoded Palindrome Check
    public boolean isPalindrome(String text) {
        // Remove spaces and convert to lowercase for comparison
        String cleanText = text.replaceAll("\\s+", "").toLowerCase();
        
        int left = 0;
        int right = cleanText.length() - 1;
        
        while (left < right) {
            if (cleanText.charAt(left) != cleanText.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    public void checkHardcodedPalindromes() {
        System.out.println("\n--- UC2: Hardcoded Palindrome Check ---");
        
        String[] testWords = {"radar", "hello", "level", "world", "madam"};
        
        for (String word : testWords) {
            boolean result = isPalindrome(word);
            System.out.println("\"" + word + "\" is " + 
                             (result ? "a palindrome" : "not a palindrome"));
        }
        System.out.println("========================================");
    }
    
    // UC3: User Input Palindrome Check
    public void checkUserInputPalindrome() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n--- UC3: User Input Palindrome Check ---");
        System.out.print("Enter a word or phrase to check: ");
        String userInput = scanner.nextLine();
        
        if (userInput.trim().isEmpty()) {
            System.out.println("Error: Input cannot be empty!");
        } else {
            boolean result = isPalindrome(userInput);
            System.out.println("\"" + userInput + "\" is " + 
                             (result ? "a palindrome!" : "not a palindrome."));
        }
        System.out.println("========================================");
        
        scanner.close();
    }
    
    // UC4: Multiple Palindrome Checks
    public void checkMultiplePalindromes() {
        Scanner scanner = new Scanner(System.in);
        String continueChoice;
        int checkCount = 0;
        
        System.out.println("\n--- UC4: Multiple Palindrome Checks ---");
        
        do {
            checkCount++;
            System.out.print("\nCheck #" + checkCount + " - Enter a word or phrase: ");
            String userInput = scanner.nextLine();
            
            if (userInput.trim().isEmpty()) {
                System.out.println("Error: Input cannot be empty!");
                checkCount--; // Don't count empty inputs
            } else {
                boolean result = isPalindrome(userInput);
                
                if (result) {
                    System.out.println("✓ \"" + userInput + "\" is a palindrome!");
                } else {
                    System.out.println("✗ \"" + userInput + "\" is not a palindrome.");
                }
            }
            
            System.out.print("\nDo you want to check another? (yes/no): ");
            continueChoice = scanner.nextLine().trim().toLowerCase();
            
        } while (continueChoice.equals("yes") || continueChoice.equals("y"));
        
        System.out.println("\nTotal palindromes checked: " + checkCount);
        System.out.println("Thank you for using Palindrome Checker!");
        System.out.println("========================================");
        
        scanner.close();
    }
    
    // UC5: Stack-Based Palindrome Checker
    public boolean isPalindromeUsingStack(String text) {
        // Remove spaces and convert to lowercase
        String cleanText = text.replaceAll("\\s+", "").toLowerCase();
        
        // Create a Stack to store characters
        Stack<Character> stack = new Stack<>();
        
        System.out.println("\nStack Operations:");
        System.out.println("Original Text: " + cleanText);
        System.out.println("\nPush Operations (adding to stack):");
        
        // Push all characters onto the stack
        for (int i = 0; i < cleanText.length(); i++) {
            char ch = cleanText.charAt(i);
            stack.push(ch);
            System.out.println("Pushed: '" + ch + "' -> Stack: " + stack);
        }
        
        System.out.println("\nStack is full. Size: " + stack.size());
        System.out.println("\nPop Operations (removing from stack - LIFO):");
        
        // Build reversed string by popping from stack
        StringBuilder reversed = new StringBuilder();
        Stack<Character> tempStack = (Stack<Character>) stack.clone();
        
        while (!tempStack.isEmpty()) {
            char ch = tempStack.pop();
            reversed.append(ch);
            System.out.println("Popped: '" + ch + "' -> Reversed so far: " + reversed);
        }
        
        String reversedText = reversed.toString();
        System.out.println("\nComparison:");
        System.out.println("Original:  " + cleanText);
        System.out.println("Reversed:  " + reversedText);
        
        // Compare original with reversed
        boolean isPalindrome = cleanText.equals(reversedText);
        System.out.println("Match: " + (isPalindrome ? "YES" : "NO"));
        
        return isPalindrome;
    }
    
    public void checkStackBasedPalindrome() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n========================================");
        System.out.println("--- UC5: Stack-Based Palindrome Check ---");
        System.out.println("========================================");
        System.out.println("Using Stack (LIFO - Last In First Out)");
        System.out.print("\nEnter a word or phrase to check: ");
        String userInput = scanner.nextLine();
        
        if (userInput.trim().isEmpty()) {
            System.out.println("Error: Input cannot be empty!");
        } else {
            System.out.println("\nInput: \"" + userInput + "\"");
            boolean result = isPalindromeUsingStack(userInput);
            
            System.out.println("\n" + "=".repeat(40));
            System.out.println("Result: \"" + userInput + "\" is " + 
                             (result ? "a PALINDROME!" : "NOT a palindrome."));
            System.out.println("=".repeat(40));
        }
        
        scanner.close();
    }
    
    public static void main(String[] args) {
        PalindromeCheckerApp app = new PalindromeCheckerApp();
        app.displayWelcomeMessage();
        app.checkHardcodedPalindromes();
        // Uncomment one of the following based on use case:
        // app.checkUserInputPalindrome();     // UC3: Single check
        // app.checkMultiplePalindromes();     // UC4: Multiple checks
        app.checkStackBasedPalindrome();       // UC5: Stack-Based
    }
}
