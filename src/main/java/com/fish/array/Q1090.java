package com.fish.array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author liuqi
 * @date 2023/5/23
 * <p>
 * https://leetcode.cn/problems/largest-values-from-labels/
 */
public class Q1090 {
    class Solution {
        public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
            int[][] arr = new int[values.length][2];
            for (int i = 0; i < values.length; i++) {
                arr[i][0] = values[i];
                arr[i][1] = labels[i];
            }
            Arrays.sort(arr, (int[] a1, int[] a2) -> a2[0] - a1[0]);
            int result = 0;
            int numCnt = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int[] ints : arr) {
                if (numCnt >= numWanted) {
                    break;
                }
                int cnt = map.getOrDefault(ints[1], 0);
                if (cnt < useLimit) {
                    result += ints[0];
                    map.put(ints[1], ++cnt);
                    numCnt++;
                }
            }
            return result;
        }
    }
}
