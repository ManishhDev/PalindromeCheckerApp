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
    
    // UC4: Character Array Based Palindrome Check
    public boolean isPalindromeUsingCharArray(String text) {
        // Remove spaces and convert to lowercase
        String cleanText = text.replaceAll("\\s+", "").toLowerCase();
        
        // Convert string to character array
        char[] charArray = cleanText.toCharArray();
        
        // Use two-pointer technique
        int start = 0;
        int end = charArray.length - 1;
        
        System.out.println("\nArray Analysis:");
        System.out.println("Character Array: " + java.util.Arrays.toString(charArray));
        System.out.println("Array Length: " + charArray.length);
        
        // Compare characters from start and end
        while (start < end) {
            System.out.println("Comparing charArray[" + start + "] = '" + charArray[start] + 
                             "' with charArray[" + end + "] = '" + charArray[end] + "'");
            
            if (charArray[start] != charArray[end]) {
                System.out.println("Mismatch found! Not a palindrome.");
                return false;
            }
            
            start++;
            end--;
        }
        
        System.out.println("All characters matched!");
        return true;
    }
    
    public void checkCharArrayPalindrome() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n========================================");
        System.out.println("--- UC4: Character Array Based Check ---");
        System.out.println("========================================");
        System.out.print("Enter a word or phrase to check: ");
        String userInput = scanner.nextLine();
        
        if (userInput.trim().isEmpty()) {
            System.out.println("Error: Input cannot be empty!");
        } else {
            System.out.println("\nInput: \"" + userInput + "\"");
            boolean result = isPalindromeUsingCharArray(userInput);
            
            System.out.println("\nResult: \"" + userInput + "\" is " + 
                             (result ? "a PALINDROME!" : "NOT a palindrome."));
        }
        System.out.println("========================================");
        
        scanner.close();
    }
    
    public static void main(String[] args) {
        PalindromeCheckerApp app = new PalindromeCheckerApp();
        app.displayWelcomeMessage();
        app.checkHardcodedPalindromes();
        // app.checkUserInputPalindrome();  // UC3
        app.checkCharArrayPalindrome();     // UC4: Character Array Based
    }
}
