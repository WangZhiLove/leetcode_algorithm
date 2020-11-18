package november.time1.a14;

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
     * 存放每个元素出现的次数
     */
    Map<Integer, Integer> freq;

    /**
     * 存放元素的顺序，这个数据结构声明的精髓
     */
    Map<Integer, Stack<Integer>> group;

    int maxFreq;

    public MaximumFrequencyStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int x) {
        int count = freq.getOrDefault(x, 0) + 1;
        freq.put(x, count);
        if (count > maxFreq) {
            maxFreq = count;
        }
        group.computeIfAbsent(count, k -> new Stack<>()).push(x);
    }

    public int pop() {
        Integer result = group.get(maxFreq).pop();
        freq.put(result, freq.get(result) - 1);
        // 理解这步判断的操作，其实就是避免个数相同的元素
        if (group.get(maxFreq).size() == 0) {
            maxFreq --;
        }
        return result;
    }
}
