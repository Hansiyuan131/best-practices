package com.yuanstack.bp.core.structure.linked;

import org.w3c.dom.Node;

import java.util.List;

/**
 * @description: 链表相关算法
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 * @author: hansiyuan
 * @date: 2022/4/1 2:41 PM
 */
public class LinkedListAlgo {

    public static void main(String[] args) {
        Node node = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
        printAll(node);
        Node node1 = reverseBetween(node,2,4);
        printAll(node1);
    }

    /**
     * 单链表反转
     *
     * @param list 链表
     * @return 反转链表
     */
    public static Node reverse(Node list) {
        Node curr = list, pre = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static Node reverseBetween(Node head, int m, int n) {
        Node res = new Node(-1, null);
        res.next = head;
        Node pre = res;
        Node cur = head;
        for (int i = 1; i < m; i++) {
            pre = cur;
            cur = cur.next;
        }
        for (int i = m; i < n; i++) {
            Node temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return res.next;
    }

    /**
     * 检测环
     *
     * @param list 链表
     * @return True 存在环 False 不存在环
     */
    public static boolean checkCircle(Node list) {
        if (list == null) {
            return false;
        }

        Node fast = list.next;
        Node slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    // 有序链表合并
    // public static Node mergeSortedLists(Node la, Node lb) {
    // if (la == null) return lb;
    // if (lb == null) return la;

    // Node p = la;
    // Node q = lb;
    // Node head;
    // if (p.data < q.data) {
    //   head = p;
    //   p = p.next;
    // } else {
    //   head = q;
    //   q = q.next;
    // }
    // Node r = head;

    // while (p != null && q != null) {
    //   if (p.data < q.data) {
    //     r.next = p;
    //     p = p.next;
    //   } else {
    //     r.next = q;
    //     q = q.next;
    //   }
    //   r = r.next;
    // }

    // if (p != null) {
    //   r.next = p;
    // } else {
    //   r.next = q;
    // }

    // return head;
    //}

    //-----------------------------------------

    // 有序链表合并 Leetcode 21

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //利用哨兵结点简化实现难度 技巧三
        ListNode soldier = new ListNode(0);
        ListNode p = soldier;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return soldier.next;
    }


    // 删除倒数第K个结点
    public static Node deleteLastKth(Node list, int k) {
        Node fast = list;
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.next;
            ++i;
        }

        if (fast == null) {
            return list;
        }

        Node slow = list;
        Node prev = null;
        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        if (prev == null) {
            list = list.next;
        } else {
            prev.next = prev.next.next;
        }
        return list;
    }

    // 求中间结点
    public static Node findMiddleNode(Node list) {
        if (list == null) {
            return null;
        }

        Node fast = list;
        Node slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void printAll(Node list) {
        Node p = list;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
