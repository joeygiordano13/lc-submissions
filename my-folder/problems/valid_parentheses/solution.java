class Solution {
    // valid: 
    // () [] {}
    // good ({[]})
    // bad ({}[)]
    // could use stack
    // s: [
    // adding a left parent means we push onto
    // adding rp means we pop
    // s: ([])
    // stack: {
    // ([]){}
    // {}
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // Check to see if a brace can be popped
            // by being closed with right brace.
            // Note: Ascii codes for braces is c - 1 
            // for ( ) and c - 2 for [ ] & { }.
            if (!stack.empty() && (stack.peek() == c - 1 || 
                                   stack.peek() == c - 2))  { 
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        // If stack is empty, all braces were closed in order.
        return stack.empty();
    }
}