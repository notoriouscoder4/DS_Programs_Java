package com.jsm.datastructuresandalgorithms.linkedlist;

public class SinglyLinkedList {
    private ListNode head;

    private static class ListNode {
        private int data; //Could be Generic Type
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private void display() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    private int length() {
        if (head == null) {
            return 0;
        }
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    private void insertFirst(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    private void insert(int position, int value) {
        // 1 -> 4 -> 5
        // 1 -> 6 -> 4 -> 5  after inserting at position 2

        ListNode node = new ListNode(value);
        if (position == 1) {
            node.next = head;
            head = node;
        } else {
            ListNode previous = head;
            int count = 1;
            while (count < position - 1) {
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = node;
            node.next = current;
        }
    }

    private void insertLast(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode current = head;
        while (null != current.next) {
            current = current.next;
        }
        current.next = newNode;
    }

    private ListNode deleteFirst() {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    private void delete(int position) {
        // position is valid and starting from 1
        // 3 -> 4 -> 7 -> 8 -> 9 -> null
        if (position == 1) {
            head = head.next;
        } else {
            ListNode previous = head;
            int count = 1;
            while (count < position - 1) {
                previous = previous.next;
                count++;
            }

            ListNode current = previous.next;
            previous.next = current.next;
        }
    }

    private ListNode deleteLast() {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode previous = null;

        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null; //break the chain
        return current;
    }

    private boolean find(ListNode head, int searchKey) {
        if (head == null) {
            return false;
        }

        ListNode current = head;
        while (current != null) {
            if (current.data == searchKey) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    private ListNode getMiddleNode() {
        if (head == null) {
            return null;
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    private ListNode getNthNodeFromEnd(int n) {
        if (head == null) {
            return null;
        }

        if (n <= 0) {
            throw new IllegalArgumentException("Invalid value: n = " + n);
        }

        ListNode mainPtr = head;
        ListNode refPtr = head;

        int count = 0;

        while (count < n) {
            if (refPtr == null) {
                throw new IllegalArgumentException(n + " is greater than the number of nodes in list");
            }
            refPtr = refPtr.next;
            count++;
        }

        while (refPtr != null) {
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }

    private void removeDuplicates() {
        if (head == null) {
            return;
        }

        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    private ListNode insertInSortedList(int value) {
        ListNode newNode = new ListNode(value);

        if (head == null) {
            return newNode;
        }

        ListNode current = head;
        ListNode temp = null;

        while (current != null && current.data < newNode.data) {
            temp = current;
            current = current.next;
        }

        newNode.next = current;
        temp.next = newNode;
        return head;
    }

    private void deleteNode(int key) {
        ListNode current = head;
        ListNode temp = null;

        if (current != null && current.data == key) {
            head = current.next;
            return;
        }

        while (current != null && current.data != key) {
            temp = current;
            current = current.next;
        }

        if (current == null) {
            return;
        }

        temp.next = current.next;
    }

    private boolean containsLoop() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (slowPtr == fastPtr)
                return true;
        }
        return false;
    }

    private ListNode startNodeInALoop() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (slowPtr == fastPtr)
                return getStartingNode(slowPtr);
        }
        return null;
    }

    private ListNode getStartingNode(ListNode slowPtr) {
        ListNode temp = head;
        while (temp != slowPtr) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp; // starting node of the loop
    }

    private void removeLoopInANode() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (slowPtr == fastPtr) {
                removeLoop(slowPtr);
                return;
            }
        }
    }

    private void removeLoop(ListNode slowPtr) {
        ListNode temp = head;
        while (temp.next != slowPtr.next) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = null;
    }

    private void createALoopInLinkedList() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);

        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;

        sixth.next = third;
    }

    private static ListNode merge(ListNode a, ListNode b) {
        // a --> 1 --> 3 --> 5 --> null
        // b --> 2 --> 4 --> 6 --> null
        // result --> 1 --> 2 --> 3 --> 4 --> 5 --> 6 -->null
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        // a --> 1 --> 3 --> null
        // b --> 2 --> 4 --> 6 --> 7 --> 9 --> 10 --> null
        // result --> 1 --> 2 --> 3 --> 4 --> 6 --> 7 --> 9 --> 10 --> null
        if (a == null) {
            tail.next = b;
        } else {
            tail.next = a;
        }

        return dummy.next;
    }

    private static ListNode mergeWithoutVariable(ListNode a, ListNode b) {
        ListNode head = null;

        if (a.data <= b.data) {
            head = a;
            a = a.next;
        } else {
            head = b;
            b = b.next;
        }

        ListNode tail = head;
        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        if (a == null)
            tail.next = b;
        else
            tail.next = a;

        return head;
    }

    private static ListNode add(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        while (a != null || b != null) {
            int x = (a != null) ? a.data : 0;
            int y = (b != null) ? b.data : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            if (a != null) a = a.next;
            if (b != null) b = b.next;
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll1 = new SinglyLinkedList();
        sll1.insertLast(1);
        sll1.insertLast(4);
        sll1.insertLast(8);

        SinglyLinkedList sll2 = new SinglyLinkedList();
        sll2.insertLast(3);
        sll2.insertLast(5);
        sll2.insertLast(9);
        sll2.insertLast(14);
        sll2.insertLast(18);

        sll1.display();
        sll2.display();

        SinglyLinkedList result = new SinglyLinkedList();
        result.head = merge(sll1.head, sll2.head);

        result.display();

//        SinglyLinkedList sll = new SinglyLinkedList();
//
//        sll.createALoopInLinkedList();
//
//        System.out.println(sll.containsLoop());
//        System.out.println(sll.startNodeInALoop().data);
//
//        sll.removeLoopInANode();
//        sll.display();

//        sll.insertFirst(16);
//        sll.insertFirst(11);
//        sll.insertFirst(10);
//        sll.insertFirst(8);
//        sll.insertFirst(1);
//
//        sll.display();
//
//        sll.deleteNode(11);
//        sll.display();

//        sll.insertInSortedList(11);
//        sll.display();
//        sll.removeDuplicates();
//
//        sll.display();

//        ListNode nthNodeFromEnd = sll.getNthNodeFromEnd(2);
//        System.out.println("nth node from end is - " + nthNodeFromEnd.data);

//        sll.head = new ListNode(10);
//        ListNode second = new ListNode(1);
//        ListNode third = new ListNode(8);
//        ListNode fourth = new ListNode(11);
//
//        // Now we will connect them together to form a chain
//        sll.head.next = second; // 10 --> 1
//        second.next = third; // 10 --> 1 --> 8
//        third.next = fourth; // 10 --> 1 --> 8 --> 11 --> null
//
//        sll.display();
//
//        ListNode middleNode = sll.getMiddleNode();
//        System.out.println("Middle node is - " + middleNode.data);

//        if (sll.find(sll.head, 12)) {
//            System.out.println("Search Key found!!!");
//        } else {
//            System.out.println("Search Key not found!!!");
//        }

//        sll.insertFirst(11);
//        sll.insertFirst(8);
//        sll.insertFirst(1);

//        sll.insertLast(11);
//        sll.insertLast(8);
//        sll.insertLast(1);
//
//        sll.display();
//        System.out.println("Length is - " + sll.length());

//        sll.insert(1, 3);   // 3 --> null
//        sll.insert(2, 5);   // 3 --> 5 --> null
//        sll.insert(1, 2);   // 2 --> 3 --> 5 --> null
//        sll.insert(2, 4);   // 2 --> 4 --> 3 --> 5 --> null
//        sll.insert(5, 7);   // 2 --> 4 --> 3 --> 5 --> 7 --> null
//        sll.display();

//        sll.insertLast(11);
//        sll.insertLast(8);
//        sll.insertLast(1);
//        sll.insertLast(10);
//
//        sll.display();
//
//        //System.out.println(sll.deleteFirst().data);
//
//        System.out.println(sll.deleteLast().data);
//
//        sll.display();


    }
}
