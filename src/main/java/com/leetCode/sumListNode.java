package com.leetCode;

import org.w3c.dom.NodeList;

import java.math.BigDecimal;

public class sumListNode {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigDecimal num1 = BigDecimal.valueOf(0);
        BigDecimal num2 = BigDecimal.valueOf(0);
        int mod = 1;
        BigDecimal sum = BigDecimal.valueOf(0);

        while(l1.next != null){
            num1 = num1.add(BigDecimal.valueOf((long) l1.val * mod));
            mod *= 10;
            l1 = l1.next;
        }
        mod = 1;
        while(l2.next != null){
            num2 = num2.add(BigDecimal.valueOf((long) l2.val * mod));
            mod *= 10;
            l2 = l2.next;
        }
        sum = num1.add(num2);


        char[] chars = sum.toString().toCharArray();
        ListNode head = new ListNode();
        ListNode node = head;

        for (char c: chars) {
            node.next = new ListNode();
            node.val = (int)c;
            node= node.next;
        }

        return  head;
    }

     static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode node = head;

        for (int i = 0;i <= 3 ;i ++) {
            node.next = new ListNode();
            node.val = i;
            node= node.next;
        }
        BigDecimal num1 = BigDecimal.valueOf(0);
        int mod = 1;
        while(head.next != null){
            num1 = num1.add(BigDecimal.valueOf((long) head.val * mod));
            mod *= 10;
            head = head.next;
        }
        System.out.println(num1);

    }

}
