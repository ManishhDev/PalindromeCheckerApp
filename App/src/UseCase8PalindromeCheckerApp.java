import java.util.Scanner;

public class UseCase8PalindromeCheckerApp {

    private static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
        }
    }

    private static String normalizeInput(String text) {
        return text.replaceAll("\\s+", "").toLowerCase();
    }

    private static Node buildLinkedList(String text) {
        Node head = null;
        Node tail = null;

        for (int i = 0; i < text.length(); i++) {
            Node newNode = new Node(text.charAt(i));
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        return head;
    }

    private static Node reverse(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    private static String linkedListToString(Node head) {
        StringBuilder sb = new StringBuilder();
        Node current = head;

        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }

        return sb.toString();
    }

    // UC8: Linked List based palindrome check.
    public static boolean isPalindromeUsingLinkedList(String text) {
        String cleanText = normalizeInput(text);

        Node head = buildLinkedList(cleanText);

        System.out.println("\n--- Linked List Representation ---");
        System.out.println("List: " + linkedListToString(head));

        if (head == null || head.next == null) {
            return true;
        }

        Node slow = head;
        Node fast = head;

        // Fast/slow pointers find midpoint.
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("\nMiddle found at node: '" + slow.data + "'");

        Node secondHalfStart = reverse(slow.next);
        slow.next = secondHalfStart;

        System.out.println("--- After Reversing Second Half ---");
        System.out.println("List: " + linkedListToString(head));

        Node left = head;
        Node right = secondHalfStart;
        boolean isPalindrome = true;

        System.out.println("\n--- Comparing Halves ---");
        while (right != null) {
            System.out.printf("Left='%c' | Right='%c' -> %s%n",
                left.data,
                right.data,
                (left.data == right.data ? "MATCH" : "MISMATCH"));

            if (left.data != right.data) {
                isPalindrome = false;
            }

            left = left.next;
            right = right.next;
        }

        return isPalindrome;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("UC8: Linked List Based Palindrome Checker");
        System.out.println("==================================================");
        System.out.print("Enter a word or phrase to check: ");
        String userInput = scanner.nextLine();

        if (userInput.trim().isEmpty()) {
            System.out.println("Error: Input cannot be empty!");
            scanner.close();
            return;
        }

        System.out.println("\nInput: \"" + userInput + "\"");
        boolean result = isPalindromeUsingLinkedList(userInput);

        System.out.println("\n==================================================");
        System.out.println("Result: \"" + userInput + "\" is "
            + (result ? "a PALINDROME!" : "NOT a palindrome."));
        System.out.println("==================================================");

        scanner.close();
    }
}