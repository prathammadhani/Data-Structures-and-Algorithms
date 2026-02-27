//Problem Name: Reverse Linked List
//Problem Link: https://leetcode.com/problems/reverse-linked-list/description/

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
class Solution {
    ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode nxt =  null;
        ListNode curr = head;
        while(curr!=null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        return reverseLL(head);
    }
}

