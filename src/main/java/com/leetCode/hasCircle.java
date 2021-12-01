package com.leetCode;

public class hasCircle {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean hasCycle(ListNode head) {
		if ( head == null || head.next == null ) {
			return false;
		}
		
		ListNode fast = head.next.next;
		ListNode  slow = head.next;
		
		while(fast != null && fast.next != null) {
			if (slow == fast) {
				return true;
			}
			
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return false;
		
	}

}
