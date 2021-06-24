package io.jafeer.stack;


public class Stack {
    Node current;
    int min;

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(3);
        stack.push(5);
        stack.printMinimum();
        stack.push(2);
        stack.printMinimum();
        stack.push(4);
        stack.push(1);
        stack.printMinimum();
        System.out.println("popped element" + stack.pop());
        stack.printMinimum();
        System.out.println("popped element" + stack.pop());
        stack.printMinimum();
        System.out.println("popped element" + stack.pop());
        System.out.println("popped element" + stack.pop());
        stack.printMinimum();
    }

    public void push(int no) {
        if (current == null) {
            current = new Node(no);
            min = no;
        } else {
            int number;
            if (no > min)
                number = no;
            else {
                number = 2 * no - min;
                min = no;
            }
            //System.out.println("Actual:" + no + " Final:" + number);
            Node node = new Node(number);
            node.prev = current;
            current.next = node;
            current = current.next;
        }
    }

    public int pop() {
        if (current == null) {
            return -1;
        } else {
            int result = current.element;
            if (result < min) {
                result = min;
                min = (2 * min) - current.element;

            }
            //System.out.println("Actual:" + current.element + " Final:" + result);
            current = current.prev;

            return result;
        }
    }

    public int getMinimum() {
        return min;
    }

    public void printMinimum() {
        System.out.println(min);
    }
}

class Node {
    int element;
    Node prev;
    Node next;

    Node(int x) {
        element = x;
        prev = null;
        next = null;
    }
}
