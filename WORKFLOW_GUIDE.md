# Quick Reference Guide for PalindromeCheckerApp Workflow

## Current Status (As of March 2, 2026)
- ✅ Repository: PalindromeCheckerApp
- ✅ Main branch has: UC1 only
- ⚠️ UC2 code exists on remote branch but not merged to main

---

## Workflow for Future Use Cases

### For Next Use Case (UC2 or UC3):

1. **Make sure you're on main branch and it's up to date:**
   ```bash
   git checkout main
   git pull origin main
   ```

2. **Create a new branch for the use case:**
   ```bash
   git checkout -b UC2-HardCodePalindrome
   # Or for UC3: git checkout -b UC3-UserInputPalindrome
   ```

3. **Verify your branch:**
   ```bash
   git branch
   ```

4. **Write your code in PalindromeCheckerApp.java**
   - Open App/src/PalindromeCheckerApp.java
   - Add your use case logic

5. **Check status:**
   ```bash
   git status
   ```

6. **Add the modified file:**
   ```bash
   git add App/src/PalindromeCheckerApp.java
   # Also update README if needed:
   git add README.md
   ```

7. **Commit your changes:**
   ```bash
   git commit -m "UC2: Hardcoded Palindrome Check"
   # Or: git commit -m "UC3: User Input Palindrome Check"
   ```

8. **Push to GitHub:**
   ```bash
   git push origin UC2-HardCodePalindrome
   # Or: git push origin UC3-UserInputPalindrome
   ```

9. **Go to GitHub in browser:**
   - Click "Compare & pull request"
   - Click "Create pull request"
   - Click "Merge pull request"
   - Click "Confirm merge"

10. **Switch back to main and pull:**
    ```bash
    git checkout main
    git pull origin main
    ```

11. **For next use case, repeat from step 2**

---

## Important Git Commands

### Check current status:
```bash
git status
```

### Check current branch:
```bash
git branch
```

### View commit history:
```bash
git log --oneline
```

### View all branches (local and remote):
```bash
git branch -a
```

---

## Notes:
- Never commit .idea/ or .iml files (they're in .gitignore)
- Always work on feature branches, never directly on main
- Always pull main before creating a new branch
- Keep branch names descriptive: UC1-WelComePage, UC2-HardCodePalindrome, etc.
