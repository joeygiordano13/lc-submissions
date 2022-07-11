/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// two pointers, one for each list
// loop through both lists, making a new 
// one as we go through
// A - 1 3 4
// B - 1 2 4
// C - 1 1
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Start at beggining of both lists
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode newList = new ListNode(); // new list
        ListNode newCur = newList; // new list pointer
        // If there are more nodes to count, keep going.
        while (cur1 != null || cur2 != null) {
            // Node is present at both pointers
            if (cur1 != null && cur2 != null) {
                if (cur1.val <= cur2.val) {
                    newCur.next = new ListNode(cur1.val);
                    cur1 = cur1.next;
                    newCur = newCur.next;
                } else {
                    newCur.next = new ListNode(cur2.val);
                    cur2 = cur2.next;
                    newCur = newCur.next;
                }
            // Nodes only left on the first pointer.
            } else if (cur1 != null) {
                newCur.next = new ListNode(cur1.val);
                cur1 = cur1.next;
                newCur = newCur.next;
            // Nodes only left on the second pointer.
            } else {
                newCur.next = new ListNode(cur2.val);
                cur2 = cur2.next;
                newCur = newCur.next;
            }    
        }
        // Return new list of merged lists, 
        // skip the first node (sentinel).
        return newList.next;
    }
}