import java.util.Arrays;

public class Palindromes {
    public static void main(String[] args) {

        System.out.println("Is palindrome? " + isPalindrome("foo"));
        System.out.println("Is palindrome? " + isPalindrome2("foo"));
        System.out.println("Is palindrome? " + isPalindrome("radar"));
        System.out.println("Is palindrome? " + isPalindrome2("radar"));
        System.out.println("Is palindrome? " + isPalindrome("hooh"));
        System.out.println("Is palindrome? " + isPalindrome2("hooh"));
    }

    /**
     * Pros: Very easy to read.
     * <br/><br/>
     * Cons:
     * <ul>
     * <li>Allocates a new {@code StringBuilder}</li>
     * <li>Reverses the new {@code String} <b><i>(O(n) work)<i/></b></li>
     * <li>Calls {@code toString()} which allocates another new {@code String} <b><i>(O(n) copy)</i></b></li>
     * <li>Does a full {@code equals()} comparison <b><i>(O(n) pass)<i/></b> in the worst case</li>
     * <li>No early exit: even if the first and last characters mismatch, it still builds the entire reversed string
     * before comparing</li>
     * </ul>
     */
    public static boolean isPalindrome(String str) {
        if (str == null) return false;
        return new StringBuilder(str).reverse().toString().equals(str);
    }

    /**
     * Not as readable as the other method, but it's more memory-efficient (no auxiliary objects), and time-efficient on
     * average due to early termination on mismatches.
     * <ul>
     * <li>No extra object allocation — just two {@code int} pointers.</li>
     * <li>Only needs to compare half the string {@code (ptr < ptr2)}, and only once per character pair.</li>
     * <li>Early exit: Returns {@code false} immediately on the first mismatch, rather than doing the full amount of work
     * regardless.</li>
     * <li>Still <b><i>O(n)</i></b> time in the worst case, but <b><i>O(1)</i></b> extra space, versus <b><i>O(n)</i></b>
     * extra space for the other method.</li>
     * </ul>
     *
     */
    public static boolean isPalindrome2(String str) {
        if(str == null) return false;
        int ptr = 0;
        int ptr2 = str.length() - 1;

        while (ptr < ptr2) {
            char c1 = str.charAt(ptr);
            char c2 = str.charAt(ptr2);
            if (c1 != c2) return false;
            ptr++;
            ptr2--;
        }
        return true;
    }
}
