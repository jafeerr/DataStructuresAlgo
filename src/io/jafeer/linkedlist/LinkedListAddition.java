package io.jafeer.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListAddition {
public static void main(String[] args){

    ListNode head=new ListNode(1);
    ListNode two=new ListNode(2);
    head.next=two;
    ListNode three=new ListNode(3);
    two.next=three;
    ListNode four=new ListNode(4);
    three.next=four;
    ListNode five=new ListNode(5);
    four.next=five;
    ListNode six=new ListNode(6);
    five.next=six;

    ListNode p1=head;
    ListNode p2=four;
    while(p2!=null&&p1!=null)
    {
        ListNode temp=new ListNode(p2.val);
        if(p2.next!=null)
        temp.next=p1.next;
        p1.next=temp;

        p1=p1.next.next;
        p2=p2.next;


    }

while(head!=null)
{
    System.out.println(head.val);
    head=head.next;
}
}
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head  = null;
        int remainder = 0;
        ListNode temp = null;
        ListNode list1 = l1;
        ListNode list2 = l2;

        while (list1 != null || list2 != null) {
            int sum =  ((list1 == null)? 0 : list1.val) + ((list2 == null)?0:list2.val) + remainder;
            remainder = sum / 10;
            ListNode node = new ListNode(sum % 10);

            if (head == null) {
                head = node;
            }
            else
                temp.next = node;

            temp = node;
            if(list1 != null)
                list1 = list1.next;
            if(list2 != null)
                list2 = list2.next;

        }
        if (remainder > 0) {
            ListNode rem = new ListNode(remainder);
            temp.next = rem;
        }

        return head;

    }
}