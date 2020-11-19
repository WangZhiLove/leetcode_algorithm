package november.time2.a14;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaximumFrequencyStack {
    /**
     * 895. 最大频率栈
     * 实现 FreqStack，模拟类似栈的数据结构的操作的一个类。
     *
     * FreqStack 有两个函数：
     *
     * push(int x)，将整数 x 推入栈中。
     * pop()，它移除并返回栈中出现最频繁的元素。
     * 如果最频繁的元素不只一个，则移除并返回最接近栈顶的元素。
     *
     *
     * 示例：
     *
     * 输入：
     * ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
     * [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
     * 输出：[null,null,null,null,null,null,null,5,7,5,4]
     * 解释：
     * 执行六次 .push 操作后，栈自底向上为 [5,7,5,7,4,5]。然后：
     *
     * pop() -> 返回 5，因为 5 是出现频率最高的。
     * 栈变成 [5,7,5,7,4]。
     *
     * pop() -> 返回 7，因为 5 和 7 都是频率最高的，但 7 最接近栈顶。
     * 栈变成 [5,7,5,4]。
     *
     * pop() -> 返回 5 。
     * 栈变成 [5,7,4]。
     *
     * pop() -> 返回 4 。
     * 栈变成 [5,7]。
     *
     *
     * 提示：
     *
     * 对 FreqStack.push(int x) 的调用中 0 <= x <= 10^9。
     * 如果栈的元素数目为零，则保证不会调用  FreqStack.pop()。
     * 单个测试样例中，对 FreqStack.push 的总调用次数不会超过 10000。
     * 单个测试样例中，对 FreqStack.pop 的总调用次数不会超过 10000。
     * 所有测试样例中，对 FreqStack.push 和 FreqStack.pop 的总调用次数不会超过 150000。
     */

    /**
     * 数子出现的频率
     */
    private Map<Integer, Integer> freq;

    /**
     * 频率的长度
     */
    private Map<Integer, Stack<Integer>> lenStack;

    private Integer maxLen;

    public MaximumFrequencyStack() {
        freq = new HashMap<>();
        lenStack = new HashMap<>();
        maxLen = 0;
    }

    public void push(int x) {
        Integer len = freq.getOrDefault(x, 0) + 1;
        freq.put(x, len);
        if (len > maxLen) {
            maxLen = len;
        }
        // 根据键值对去查找并初始化赋值
        lenStack.computeIfAbsent(x, k -> new Stack<>()).push(x);
    }

    public int pop() {
        Integer pop = lenStack.get(maxLen).pop();
        freq.put(pop, freq.get(pop) - 1);
        if (lenStack.get(maxLen).size() == 0) {
            maxLen --;
        }
        return pop;
    }
}
