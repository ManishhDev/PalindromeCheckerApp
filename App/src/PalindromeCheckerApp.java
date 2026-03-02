import java.util.Scanner;

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
    
    public static void main(String[] args) {
        PalindromeCheckerApp app = new PalindromeCheckerApp();
        app.displayWelcomeMessage();
        app.checkHardcodedPalindromes();
        // Uncomment one of the following based on use case:
        // app.checkUserInputPalindrome();  // UC3: Single check
        app.checkMultiplePalindromes();     // UC4: Multiple checks
    }
}
