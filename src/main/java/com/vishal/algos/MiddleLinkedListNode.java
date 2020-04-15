package com.vishal.algos;

import java.util.HashMap;
import java.util.Map;

public class MiddleLinkedListNode {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        System.out.println(slow);
    }

    private void old() {
        ListNode head = new ListNode(1);
        Map<Integer, ListNode> value = new HashMap<>();
        Integer i = 0;
        while(head != null) {
            value.put(i++, head);
            head = head.next;
        }

        System.out.println(value.get(i/2));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}