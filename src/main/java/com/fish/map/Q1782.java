package com.fish.map;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author liuqi
 * @date 2023/8/23
 * https://leetcode.cn/problems/count-pairs-of-nodes/
 */
public class Q1782 {
    class Solution {
        public int[] countPairs(int n, int[][] edges, int[] queries) {
            int[][] edgeCnt = new int[n + 1][n + 1]; // edgeCnt[a][b]，顶点a和b之间的边的数目
            Map<Integer, Integer> cntMap = new HashMap<>();// key:顶点id, value：边的数目
            for (int[] edge : edges) {
                edgeCnt[edge[0]][edge[1]]++;
                edgeCnt[edge[1]][edge[0]]++;
                cntMap.put(edge[0], cntMap.getOrDefault(edge[0], 0) + 1);
                cntMap.put(edge[1], cntMap.getOrDefault(edge[1], 0) + 1);
            }
            List<Integer> resultList = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    int cnt = cntMap.get(i) + cntMap.get(j) - edgeCnt[i][j];
                    if (cnt != 0) {
                        resultList.add(cnt);
                    }
                }
            }
            Collections.sort(resultList);
            for (int i = 0; i < queries.length; i++) {
                int left = 0;
                int right = resultList.size() - 1;
                int mid = 0;
                int query = queries[i];
                while (left <= right) {
                    mid = (left + right) / 2;
                    if (resultList.get(mid) > query) {
                        right = mid - 1;
                    } else if (resultList.get(mid) < query) {
                        left = mid + 1;
                    } else {
                        break;
                    }
                }
                queries[i] = resultList.size() - 1 - mid;
                if (query < resultList.get(mid)) {
                    left = mid - 1;
                    while (left >= 0 && resultList.get(left).equals(resultList.get(mid))) {
                        queries[i]++;
                        left--;
                    }
                    queries[i]++;
                } else {
                    int idx = mid + 1;
                    while (idx < resultList.size() && resultList.get(idx).equals(resultList.get(mid))) {
                        queries[i]--;
                        idx++;
                    }
                }
            }
            return queries;
        }
    }

    @Test
    public void test() {
        new Solution().countPairs(5,
                new int[][]{{1, 5}, {1, 5}, {3, 4}, {2, 5}, {1, 3}, {5, 1}, {2, 3}, {2, 5}},
                new int[]{1, 2, 3, 4, 5});
    }
}
