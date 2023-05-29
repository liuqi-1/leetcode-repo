package com.fish.list;

/**
 * @author liuqi
 * @date 2023/5/29
 */
public class CycleList2 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    ListNode ptr = head;
                    while (ptr != slow) {
                        ptr = ptr.next;
                        slow = slow.next;
                    }
                    return ptr;
                }
            }
            return null;
        }
    }

//    常规解法，O(n)空间
/*    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }
            Set<ListNode> set = new HashSet<>();
            set.add(head);
            while (head.next != null) {
                if (set.contains(head.next)) {
                    return head.next;
                }
                head = head.next;
                set.add(head);
            }
            return null;
        }
    }*/
}
