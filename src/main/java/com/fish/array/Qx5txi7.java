package com.fish.array;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * https://leetcode.cn/leetbook/read/tencent/x5txi7/
 * <p>
 * 官方题解：
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/307351/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode-/
 */
public class Qx5txi7 {
    // 自己的方法，优先队列实现，时间复杂度为nlogn级别
    class Solution1 {
        public int findKthLargest(int[] nums, int k) {
            Queue<Integer> q = new PriorityQueue<Integer>((a, b) -> b - a);
            for (int num : nums) {
                q.add(num);
            }
            for (int i = 0; i < k - 1; i++) {
                q.remove();
            }
            return q.remove();
        }
    }

    // todo 快排
    class Solution2 {
        public int findKthLargest(int[] nums, int k) {
            return -2;
        }
    }

    //  todo 手动实现优先队列
    class Solution3 {
        public int findKthLargest(int[] nums, int k) {
            return 0;
        }
    }

    @Test
    public void test() {
        System.out.println("111");
    }
}
