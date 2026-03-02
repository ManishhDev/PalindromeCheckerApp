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
    
    public static void main(String[] args) {
        PalindromeCheckerApp app = new PalindromeCheckerApp();
        app.displayWelcomeMessage();
    }
}
