package com.jsm.datastructuresandalgorithms.linkedlist;

import java.util.NoSuchElementException;

public class CircularSinglyLinkedList {

    private ListNode last;
    private int length;

    private static class ListNode {
        private ListNode next;
        private int data;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public CircularSinglyLinkedList() {
        last = null;
        length = 0;
    }

    private int length() {
        return length;
    }

    private boolean isEmpty() {
        return length == 0;
    }

    private void createCircularLinkedList() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(10);
        ListNode fourth = new ListNode(15);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;

        last = fourth;
    }

    private void display() {
        if (last == null) return;

        ListNode first = last.next;
        while (first != last) {
            System.out.print(first.data + " ");
            first = first.next;
        }
        System.out.println(first.data);
    }

    private void insertFirst(int data) {
        ListNode temp = new ListNode(data);
        if (last == null) {
            last = temp;
        } else {
            temp.next = last.next;
        }
        last.next = temp;
        length++;
    }

    private void insertLast(int data) {
        ListNode temp = new ListNode(data);
        if (last == null) {
            last = temp;
            last.next = last;
        } else {
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
        length++;
    }

/*
    private ListNode removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Circular Singly Linked List is already empty");
        }

        ListNode temp = last.next;
        if (last.next == last) {
            last = null;
        } else {
            last.next = temp.next;
        }
        temp.next = null;
        length--;
        return temp;
    }
*/

    private int removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Circular Singly Linked List is already empty");
        }

        ListNode temp = last.next;
        int result = temp.data;
        if (last.next == last) {
            last = null;
        } else {
            last.next = temp.next;
        }
        // temp.next = null;
        length--;
        return result;
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
//        csll.createCircularLinkedList();

        /*csll.insertFirst(10);
        csll.insertFirst(15);
        csll.insertFirst(25);
        csll.display();*/

        csll.insertLast(1);
        csll.insertLast(8);
        csll.insertLast(10);

        csll.display();

        /*csll.removeFirst();
        csll.removeFirst();
        csll.removeFirst();
        csll.removeFirst();*/

        System.out.println(csll.removeFirst());

        csll.display();
    }
}
