package main.java.test;

public class sum2 {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l11 = new ListNode(8);
		l1.next = l11;
		l11.next = null;
		

		ListNode l2 = new ListNode(0);
		l2.next = null;

		ListNode ans = addTwoNumbers2(l1, l2);
		while (ans.next != null) {
			System.out.print(ans.val + " ");
			ans = ans.next;
		}
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode curr = new ListNode(0);
		curr = head;
		boolean flag = false;
		int sum = 0;

		while ((l1 != null) || (l2 != null)) {
			int x = (l1 != null) ? l1.val : 0;
	        int y = (l2 != null) ? l2.val : 0;

			if ((x + y) >= 10) {
				if (flag) {
					sum = ( (x + y) % 10) + 1;
					flag = true;
				}else {
					sum = (x + y) % 10;
					flag = true;
				}
			} else {
				if (flag) {
					sum = x + y + 1;
					if (sum == 10) {
						sum = sum % 10;
						flag = true;
						
					}else if(sum > 10) {
						sum = sum % 10 + 1;
						flag = true;
					}else{
						flag = false;
					}
				} else {
					sum = x + y;
					flag = false;
				}
			}
			
			curr.next = new ListNode(sum);
			curr = curr.next;
			
			if(l1 != null) l1 = l1.next;
			if(l2 != null) l2 = l2.next;

		}
		if (flag) {
			curr.next = new ListNode(1);
		}

		return head.next;
	}

	public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
	    ListNode p = l1, q = l2, curr = dummyHead;
	    int carry = 0;
	    while (p != null || q != null) {
	        int x = (p != null) ? p.val : 0;
	        int y = (q != null) ? q.val : 0;
	        int sum = carry + x + y;
	        carry = sum / 10;
	        curr.next = new ListNode(sum % 10);
	        curr = curr.next;
	        if (p != null) p = p.next;
	        if (q != null) q = q.next;
	    }
	    if (carry > 0) {
	        curr.next = new ListNode(carry);
	    }
	    return dummyHead.next;

	}
}
