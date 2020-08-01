package main;

import java.util.LinkedList;

public class Solution {
    /**
     * 本题所使用到的双端队列结构与解决 生成窗口最大值数组 问题中的双端队列结构含义基本一致
     * <p>
     * 生成两个双端队列 qmax 和 qmin。当子数组为 arr[i..j]时， qmax 维护了窗口子数组 arr[i..j]
     * 的最大值更新的结构， qmin 维护了窗口子数组 arr[i..j]的最小值更新的结构。当子数组 arr[i..j]
     * 向右扩一个位置变成 arr[i..j+1]时， qmax 和 qmin 结构更新代价的平均时间复杂度为 O(1)，并且
     * 可以在 O(1)的时间内得到 arr[i..j+1]的最大值和最小值。当子数组 arr[i..j]向左缩一个位置变成
     * arr[i+1..j]时， qmax 和 qmin 结构更新代价的平均时间复杂度为 O(1)，并且在 O(1)的时间内得到
     * arr[i+1..j]的最大值和最小值
     * <p>
     * 通过分析题目满足的条件，可以得到如下两个结论。
     * 1. 如果子数组 arr[i..j]满足条件，即 max(arr[i..j])-min(arr[i..j])<=num，那么 arr[i..j]中的每一
     * 个子数组，即 arr[k..l] （ i≤ k≤ l≤ j）都满足条件。我们以子数组 arr[i..j-1]为例说明， arr[i..j-1]
     * 最大值只可能小于或等于 arr[i..j]的最大值， arr[i..j-1]最小值只可能大于或等于 arr[i..j]
     * 的最小值，所以 arr[i..j-1]必然满足条件。同理， arr[i..j]中的每一个子数组都满足条件。
     * 2. 如果子数组 arr[i..j]不满足条件，那么所有包含 arr[i..j]的子数组， 即 arr[k..l]（ k≤i≤j≤ l）
     * 都不满足条件。证明过程同第一个结论。
     * <p>
     * 根据双端队列 qmax 和 qmin 的结构性质，以及如上两个结论，设计整个过程如下：
     * 1. 生成两个双端队列 qmax 和 qmin，含义如上文所说。生成两个整型变量 i 和 j，表示子数组的范围，即 arr[i..j]。
     * 生成整型变量 res，表示所有满足条件的子数组数量。
     * 2. 令 j 不断向右移动（ j++），表示 arr[i..j]一直向右扩大，并不断更新 qmax 和 qmin 结构，
     * 保证 qmax 和 qmin 始终维持动态窗口最大值和最小值的更新结构。一旦出现 arr[i..j]不满足条件
     * 的情况， j 向右扩的过程停止，此时 arr[i..j-1]、 arr[i..j-2]、 arr[i..j-3]...arr[i..i]一定都是满足条件的。
     * 也就是说，所有必须以 arr[i]作为第一个元素的子数组，满足条件的数量为 j-i 个。于是令 res+=j-i。
     * 3. 当进行完步骤 2，令 i 向右移动一个位置，并对 qmax 和 qmin 做出相应的更新， qmax
     * 和 qmin 从原来的 arr[i..j]窗口变成 arr[i+1..j]窗口的最大值和最小值的更新结构。然后重复步骤 2，
     * 也就是求所有必须以 arr[i+1]作为第一个元素的子数组中，满足条件的数量有多少个。
     * 4. 根据步骤 2 和步骤 3，依次求出：必须以 arr[0]开头的子数组，满足条件的数量有多少
     * 个；必须以 arr[1]开头的子数组，满足条件的数量有多少个；必须以 arr[2]开头的子数组， 满足
     * 条件的数量有多少个， 全部累加起来就是答案
     */
    public int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0 || num < 0) {
            return 0;
        }
        // 最小值队列保持升序
        LinkedList<Integer> queueMin = new LinkedList<>();
        // 最大值队列保持降序
        LinkedList<Integer> queueMax = new LinkedList<>();
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < arr.length) {
            while (j < arr.length) {
                // 如果队列中海油不是j的值，尝试扩展当前的窗口
                if (queueMin.isEmpty() || queueMin.peekLast() != j) {
                    // 只要当前最大值减去最小值还能达成条件就向后扩展窗口

                    // 更新最小值
                    while (!queueMin.isEmpty() && arr[queueMin.peekLast()] >= arr[j]) {
                        queueMin.pollLast();
                    }
                    queueMin.addLast(j);

                    // 更新最大值
                    while (!queueMax.isEmpty() && arr[queueMax.peekLast()] <= arr[j]) {
                        queueMax.pollLast();
                    }
                    queueMax.addLast(j);
                }
                // 不满足条件就跳出这个循环
                if (arr[queueMax.getFirst()] - arr[queueMin.getFirst()] > num) {
                    break;
                }
                j++;
            }
            // 准备拿掉i
            // 先把i到j的所有答案的值加上
            res += j - i;
            // 同步更新最大值和最小值队列
            if (queueMin.getFirst() == i) {
                queueMin.pollFirst();
            }
            if (queueMax.getFirst() == i) {
                queueMax.pollFirst();
            }
            i++;
        }
        return res;
    }
}