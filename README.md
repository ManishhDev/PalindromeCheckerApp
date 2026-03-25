# PalindromeCheckerApp

## Project Description
A Java application that checks if a word or phrase is a palindrome.

## Author
Roll No: RA2411030010099

## Project Structure
```
PalindromeCheckerApp/
├── App/
│   └── src/
│       └── PalindromeCheckerApp.java
└── README.md
```

## Use Cases Implemented

### UC1: Application Entry & Welcome Message
- Displays a welcome message when the application starts
- Shows the purpose of the application

### UC2: Hardcoded Palindrome Check
- Implements palindrome checking logic
- Tests with hardcoded sample words: radar, hello, level, world, madam
- Removes spaces and handles case-insensitive comparison

### UC3: User Input Palindrome Check
- Accepts user input from console
- Validates that input is not empty
- Checks if the user-provided word or phrase is a palindrome
- Provides interactive feedback to the user

### UC4: Multiple Palindrome Checks
- Allows users to check multiple words/phrases in a loop
- Tracks the number of checks performed
- User can continue checking or exit anytime
- Displays check counter and final summary
- Enhanced user experience with checkmark symbols

### UC5: Stack-Based Palindrome Checker
- Uses Stack data structure (LIFO - Last In First Out)
- Demonstrates Push operation to insert characters
- Demonstrates Pop operation to remove characters in reverse order
- Shows step-by-step stack operations
- Compares original text with reversed text from stack
- Visualizes the reversal logic using stack
- Key concepts: Stack, Push, Pop, LIFO principle

### UC6: Queue + Stack Based Palindrome Check
- Uses both Queue (FIFO) and Stack (LIFO) data structures simultaneously
- Demonstrates Enqueue operation (adding to queue)
- Demonstrates Dequeue operation (removing from queue - FIFO)
- Compares Queue output (original order) with Stack output (reversed order)
- Shows behavioral difference between FIFO and LIFO structures
- Logical comparison of dequeue vs pop to validate palindrome
- Visualizes dual data structure operations side-by-side
- Key concepts: Queue, Stack, FIFO vs LIFO, Enqueue, Dequeue, Comparison Logic

### UC12: Strategy Pattern for Palindrome Algorithms (Advanced)
- Defines a `PalindromeStrategy` interface
- Implements `StackStrategy` and `DequeStrategy`
- Selects algorithm dynamically at runtime
- Demonstrates interface-based polymorphism
- Applies Strategy Pattern to swap palindrome algorithms without changing client code
- Data structure used depends on selected strategy

### UC13: Performance Comparison
- Runs multiple palindrome algorithms on the same normalized input
- Captures execution time using `System.nanoTime()`
- Compares total execution time and average time per run
- Includes correctness validation across all algorithms before reporting
- Highlights the fastest algorithm for the current input

## How to Run
1. Open the project in IntelliJ IDEA
2. Navigate to `App/src/PalindromeCheckerApp.java`
3. Run the main method

## Technologies Used
- Java
- IntelliJ IDEA
