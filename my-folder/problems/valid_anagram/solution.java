class Solution {
    // must use original letters exactly once
    // store first strings characters in hashmap, 
    // incrementing the count on first pass,
    // and decrementing on second pass
    // perform a third pass with the characters
    // of the first string if we find that no invalid
    // characters were hit on second pass
    // s anagram ->  a->
    // t nagaram -> 
    public boolean isAnagram(String s, String t) {
        // Exit early if lengths don't match
        if (s.length() != t.length()) return false;
        // First pass, store characters of 's' in 
        // hashmap
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            if (map.get(ch) == null) {
                map.put(ch, 1);
            } else {
            int count = map.get(ch); // previous count
            map.put(ch, count + 1); // increment
            }
        }
        // Second pass, cross reference 's' with 't'
        for (Character ch : t.toCharArray()) {
            if (map.get(ch) == null) {
                return false; // letter not in s
            }
            int count = map.get(ch);
            map.put(ch, count - 1);
        }
        // Check to ensure that all counts are zero
        for (Character ch : s.toCharArray()) {
            // Check in case of mapping error
            if (map.get(ch) == null) {
                return false;
            }
            // Ensure equal counts
            if (map.get(ch) != 0) {
                return false;
            }
        }
        return true; // strings match
    }
}