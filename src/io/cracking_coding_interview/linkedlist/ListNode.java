package io.cracking_coding_interview.linkedlist;

public class ListNode extends Object{
    int val;
    ListNode next;
    ListNode(int _x) { val = _x;
        next=null;}
    ListNode(int _x, ListNode _next) { val = _x;
        next=_next;}
}