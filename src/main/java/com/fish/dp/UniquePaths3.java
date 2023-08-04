package com.fish.dp;

/**
 * @author liuqi
 * @date 2023/8/4
 * https://leetcode.cn/problems/unique-paths-iii/description/
 */
public class UniquePaths3 {
    // 暴力解法，深搜，从起点开始，如果搜到终点，判断是否经过所有的节点
    class Solution {
        /**
         * 1表示开始方格，2表示结束方格，0表示空格，-1表示障碍
         */
        int startX, startY;// 起点
        int endX, endY;// 终点
        int pathNodeCnt;// 空节点数
        int m, n;// 矩阵大小
        int result; // 结果

        private boolean[][] visited;

        /**
         * 从节点(x,y)开始深搜
         *
         * @param x
         * @param y
         */
        private void dfs(int x, int y) {
            
        }

        public int uniquePathsIII(int[][] grid) {
            m = grid.length;
            n = grid[0].length;
            visited = new boolean[m][n];
            // 遍历矩阵，找到开始节点，终点，所有空节点数
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        startX = i;
                        startY = j;
                    } else if (grid[i][j] == 2) {
                        endX = i;
                        endY = j;
                    } else if (grid[i][j] == 0) {
                        pathNodeCnt++;
                    }
                }
            }
            // 开始深搜
            dfs(startX, startY);
            return result;
        }
    }
}