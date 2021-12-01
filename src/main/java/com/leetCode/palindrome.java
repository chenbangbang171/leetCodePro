package main.java.test;


public class palindrome {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {

	}

	/**
	 * 判断一个单链表是不是回文串
	 * */
	public static boolean isPalindrome(ListNode head) {
		ListNode curr = head;
		if (curr == null || curr.next == null) {
			return true;
		}

		ListNode fast = head;
		ListNode slow = head;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		slow = reverseList(slow);

		while (slow != null && head != null) {

			if (slow.val != head.val) {
				return false;
			}

			slow = slow.next;
			head = head.next;
		}

		return true;

	}

	public static ListNode reverseList(ListNode head) {
		ListNode curr = head;
		if (curr == null) {
			return null;
		}

		ListNode prev = null;
		ListNode temp = null;
		while (curr != null) {
			temp = curr.next; // 保存当前Node的下一个Node
			curr.next = prev; // 将当前Node的next指向前一个，若当前Node是第一个，则next指向空
			prev = curr; // 将当前Node赋为prev， 即下次循环的curr节点的next就会指向prev，实现反转
			curr = temp; // 反转后，将下一个Node设为当前节点，下次循环将从下一个开始
		}
		return prev;
	}

}
