package com.fish.datastructure;

/**
 * @author liuqi
 * @date 2023/11/13
 * 线段树
 */
public class SegmentTree {
    int[] a = new int[]{10, 11, 12, 13, 14};
    int[] d;

    public SegmentTree() {

    }


    /**
     * @param l 查询区间左端点
     * @param r 查询区间右端点
     * @param s 当前区间左端点
     * @param t 当前区间右端点
     * @param p 当前区间索引
     * @return
     */
    public int getSum(int l, int r, int s, int t, int p) {
        if (l <= s && t <= r) {
            return d[p];
        }
        int m = s + ((t - s) >> 1);
        int sum = 0;
        if (l <= m) {
            sum += getSum(l, r, s, m, p * 2);
        }
        if (r > m) {
            sum += getSum(l, r, m + 1, t, p * 2 + 1);
        }
        return sum;
    }

    /**
     * 建立线段树
     *
     * @param s 区间左端点
     * @param t 区间右端点
     * @param p 节点编号
     */
    void build(int s, int t, int p) {
        // 叶子节点，区间长度为1
        if (s == t) {
            d[p] = a[s];
            return;
        }
        // 计算区间中点
        int m = s + ((t - s) >> 1);
        // 递归创建左右子区间
        build(s, m, 2 * p);
        build(m + 1, t, 2 * p + 1);
        // 更新当前区间的值
        d[p] = d[2 * p] + d[2 * p + 1];
    }
}
