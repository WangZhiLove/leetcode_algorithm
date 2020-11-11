package november.time1.a8;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    /**
     * 295. 数据流的中位数
     * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
     *
     * 例如，
     *
     * [2,3,4]的中位数是 3
     *
     * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
     *
     * 设计一个支持以下两种操作的数据结构：
     *
     * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
     * double findMedian() - 返回目前所有元素的中位数。
     * 示例：
     *
     * addNum(1)
     * addNum(2)
     * findMedian() -> 1.5
     * addNum(3)
     * findMedian() -> 2
     * 进阶:
     *
     * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
     * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
     */

    /**
     * 暴力破解，可以实现，每次插入的时候使用插入排序进行数字的插入，然后迁移数组，或者使用链表，使用链表要记录长度
     *
     * 简单破解：
     *  中位数危废就是将全部的元素分成了两部分，左右两部分，这道题目有个隐藏的条件就是这个数据流是升序的，这样的话我们维护
     *  两个优先队列，左边的优先队列全部小于中间元素，右边的元素全部大于中间元素，那左边的优先队列维护一个大顶堆，右边的
     *  优先队列维护一个小顶堆，这是难点1的考虑使用的数据结构
     *  难点2在于如何维护这两个堆，其实就是如何保证两个堆的元素平衡呢，考虑进行插入的时候一直向大顶堆进行插入，当大顶堆的元素
     *  的个数 - 小顶堆的元素的个数 = 1的时候，将大顶堆的元素放入小顶堆
     */

    PriorityQueue<Integer> maxHeap;

    PriorityQueue<Integer> minHeap;

    /** initialize your data structure here. */
    public FindMedianFromDataStream() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 这块的目的知道，保持maxHeap，这里还得在研究下
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == 0) {
            return 0.0;
        }
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) * 0.5;
        } else {
            return maxHeap.peek();
        }
    }
}
