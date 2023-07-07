package com.fish.simulate;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

/**
 * @author liuqi
 * @date 2023/7/7
 * https://leetcode.cn/problems/time-to-cross-a-bridge/
 */
public class Q2532 {
    class Solution {
        PriorityQueue<Worker> left = new PriorityQueue<>();
        PriorityQueue<Worker> right = new PriorityQueue<>();
        PriorityQueue<Worker> pick = new PriorityQueue<>((w1, w2) -> w1.time[1] - w2.time[1]);
        PriorityQueue<Worker> put = new PriorityQueue<>((w1, w2) -> w1.time[3] - w2.time[3]);
        int timeNow = 0;

        public int findCrossingTime(int n, int k, int[][] time) {
            // 初始化创建左岸的worker队列
            for (int i = 0; i < k; i++) {
                left.add(new Worker(i, time[i]));
            }
            // 开始搬运东西
            while (true) {
                // 将put队列中已完成工作的放进left队列
                // while
                // 将pick队列中已完成工作的放进right队列

                // 选人过桥
                if (right.isEmpty()) {// 左边的人过桥拿东西
                    n--;

                } else if (right.size() == 1 && n == 0) {// 结束条件，右边只剩一个人，且当前没有东西可以拿
                    return timeNow + right.poll().time[2];
                } else {// 右边队列中选择一个人放进put队列

                }
            }
        }

        class Worker implements Comparable {
            int idx;// worker的单位
            int[] time;// worker的四个时间单位
            int effective = 0;

            public Worker(int idx, int[] time) {
                this.idx = idx;
                this.time = time;
                effective = time[0] + time[1];
            }

            public void toLeft() {

            }

            public void toRight() {

            }

            public void pickOld() {

            }

            public void putNew() {

            }

            // 比谁效率高，效率高的在最小优先队列中优先级低
            @Override
            public int compareTo(Object o) {
                Worker worker = (Worker) o;
                if (effective != worker.effective) {
                    return worker.effective - effective;
                } else {
                    return worker.idx - idx;
                }
            }
        }
    }

    @Test
    public void test() {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        q.add(3);
        q.add(2);
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }
}
