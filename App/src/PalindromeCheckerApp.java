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
    
    public static void main(String[] args) {
        PalindromeCheckerApp app = new PalindromeCheckerApp();
        app.displayWelcomeMessage();
        app.checkHardcodedPalindromes();
    }
}
