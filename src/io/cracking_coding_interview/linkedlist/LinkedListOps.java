package io.cracking_coding_interview.linkedlist;

import io.cracking_coding_interview.common.PrintOut;
import io.cracking_coding_interview.linkedlist.ListNode;
import io.jafeer.stack.Stack;

public class LinkedListOps extends PrintOut {
    public static ListNode head = null;

    public static void main(String[] ars) {
        head = new ListNode(1);
        ListNode two = new ListNode(2);
        head.next = two;
        ListNode three = new ListNode(3);
        two.next = three;
        ListNode four = new ListNode(4);
        three.next = four;
        ListNode five = new ListNode(5);
        four.next = five;
        ListNode six = new ListNode(6);
        five.next = six;
        ListNode three2 = new ListNode(3);
        six.next = three2;
        //2.1
        print("2.1");
        removeDuplicates();
        display("After Removing duplicates", clone(head));
        //2.2
        print("\n\n2.2");
        findKthElement(clone(head), 2);
        //2.3
        print("\n\n2.3");
        display("Before Removing middle node", clone(head));
        deleteMiddleNode(head);
        display("After removing middle node", clone(head));

        //2.5
        print("\n\n2.5");
        ListNode no1_1 = new ListNode(9);
        ListNode no1 = new ListNode(9, no1_1);
        display("List1", no1);
        ListNode no2_2 = new ListNode(8);
        ListNode no2 = new ListNode(8, no2_2);
        display("List2", no2);
        display("Sum of two lists", addTwoNumbers(no1, no2));

        //2.6
        ListNode palOne = new ListNode(1);
        ListNode palTwo = new ListNode(2);
        palOne.next = palTwo;
        ListNode palThree = new ListNode(3);
        palTwo.next = palThree;
        ListNode palFour = new ListNode(2);
        palTwo.next = palFour;
        ListNode palFive = new ListNode(1);
        palFour.next = palFive;
        display("\n\n2.6\nPalidrome Input",palOne);
        palidromeOrNot(palOne);

    }

    //common ops
    public static void display(ListNode node) {
        display(EMPTY_STRING, node);
    }

    public static void display(String printStr, ListNode node) {
        System.out.print(printStr + ": ");
        while (node != null) {
            System.out.print(node.val + "\t");
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode clone(ListNode node) {
        return new ListNode(node.val, node.next);
    }

    public static int getSize(ListNode current) {
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    //2.1
    public static void removeDuplicates() {
        ListNode ptr1 = new ListNode(head.val, head.next);
        ListNode ptr2 = null;

        while (ptr1 != null) {
            ptr2 = ptr1;
            while (ptr2.next != null) {
                if (ptr1.val == ptr2.next.val) {
                    ptr2.next = ptr2.next.next;
                } else
                    ptr2 = ptr2.next;
            }
            ptr1 = ptr1.next;
        }
    }

    public static void findKthElement(ListNode node, int k) {

        int size = getSize(clone(node));
        int count = 0;
        while (node != null) {
            if (count == size - k) {
                print("\n" + k + "th element to last:" + node.val);
                break;
            }
            count++;
            node = node.next;
        }

    }

    public static void deleteMiddleNode(ListNode node) {
        ListNode slowPointer = node;
        ListNode fastPointer = slowPointer.next;

        while (fastPointer != null) {
            if (fastPointer.next != null)
                fastPointer = fastPointer.next.next;
            else
                fastPointer = null;
            if (fastPointer != null)
                slowPointer = slowPointer.next;
        }
        slowPointer.next = slowPointer.next.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        int remainder = 0;
        ListNode temp = null;
        ListNode list1 = l1;
        ListNode list2 = l2;

        while (list1 != null || list2 != null) {
            int sum = ((list1 == null) ? 0 : list1.val) + ((list2 == null) ? 0 : list2.val) + remainder;
            remainder = sum / 10;
            ListNode node = new ListNode(sum % 10);

            if (head == null) {
                head = node;
            } else
                temp.next = node;

            temp = node;
            if (list1 != null)
                list1 = list1.next;
            if (list2 != null)
                list2 = list2.next;

        }
        if (remainder > 0) {
            ListNode rem = new ListNode(remainder);
            temp.next = rem;
        }

        return head;

    }

    public static void palidromeOrNot(ListNode node) {
        int count = 0;
        ListNode last = node;
        Stack stack=new Stack();

        while (last != null) {
            count++;
            stack.push(last.val);
            last = last.next;
        }
        int mid = (int) Math.floor(count / 2);
        while (mid > 0) {
            if (node.val != stack.pop()) {
                print("No! its not palindrome.");
                return;
            } else {
                node = node.next;
                mid--;
            }
        }
        print("Yes! its palindrome.");
    }
}
