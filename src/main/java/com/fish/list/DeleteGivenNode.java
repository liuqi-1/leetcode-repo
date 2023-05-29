package com.fish.list;

/**
 * @author liuqi
 * @date 2023/5/29
 */
public class DeleteGivenNode {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public void deleteNode(ListNode node) {
            while (node.next.next != null) {
                node.val = node.next.val;
                node = node.next;
            }
            node.val = node.next.val;
            node.next = null;
        }
    }
}
