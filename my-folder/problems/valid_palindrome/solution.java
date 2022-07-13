class Solution {
    // Convert to lowercase, remove non alphanumeric
    // iterative solution
    
    // racecar 7 letters, stop at index 2 (len/2) - 1
    //   * *
    // raceecar 8 letters, stop at index 3 (len/2) - 1
    
    public boolean isPalindrome(String s) {
        // Loop through string, remove non-alphanumeric
        // characters, and convert upper to lowercase
        s = s.toLowerCase();
        s = s.replaceAll("[^A-Za-z0-9]", "");
        
        // Empty string
        if (s.equals("")) {
            return true;
        }
        
        // Check if modified string is palindromic
        // loop through string halfway and check
        // if corresponding letters match.
        int mid = s.length() / 2 - 1;
        int len = s.length();
        for (int i = 0; i <= mid; i++) {
            int j = len - i - 1;
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}