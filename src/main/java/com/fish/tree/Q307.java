package com.fish.tree;

/**
 * @author liuqi
 * @date 2023/11/13
 */
public class Q307 {
    class NumArray {

        int[] nums;
        int[] pre;
        int start;

        public NumArray(int[] nums) {
            this.nums = nums;
            this.pre = new int[nums.length];
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                pre[i] = sum;
            }
            start = nums.length;
        }

        public void update(int index, int val) {
            nums[index] = val;
            start = Math.min(start, index);
        }

        public int sumRange(int left, int right) {
            if (start == 0) {
                start = 1;
                pre[0] = nums[0];
            }
            for (int i = start; i < nums.length; i++) {
                pre[i] = pre[i - 1] + nums[i];
            }
            start = nums.length;
            return pre[right] - pre[left] + nums[left];
        }
    }


    /**
     * 暴力求解
     */
    class NumArray1 {

        int[] nums;

        public NumArray1(int[] nums) {
            this.nums = nums;
        }

        public void update(int index, int val) {
            nums[index] = val;
        }

        public int sumRange(int left, int right) {
            int sum = 0;
            while (left <= right) {
                sum += nums[left];
                left++;
            }
            return sum;
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
}
