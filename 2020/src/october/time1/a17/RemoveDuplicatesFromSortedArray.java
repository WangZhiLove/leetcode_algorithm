package october.time1.a17;

public class RemoveDuplicatesFromSortedArray {
    /**
     * 26. 删除排序数组中的重复项
     *
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     *
     *
     * 示例1:
     *
     * 给定数组 nums = [1,1,2],
     *
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     *
     * 你不需要考虑数组中超出新长度后面的元素。
     * 示例2:
     *
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     *
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     *
     * 你不需要考虑数组中超出新长度后面的元素。
     */

    /**
     * 时间复杂度 O(n)
     */
    /*public static int removeDuplicates(int[] nums) {
        // 使用一个计数器用来计数相同元素的个数
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int num = 0;
        int result = 1;
        /// 普通循环
        for (int i = 0; i < nums.length - 1; i ++) {
            if (nums[i] == nums[i + 1]) {
                num ++;
            } else {
                if (i + 1 > num) {
                    nums[i - num + 1] = nums[i + 1];
                }
                result ++;
            }
        }
        return result;
    }*/
    // 优化
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                nums[++i] = nums[j++];
            }
        }
        return i + 1;
    }

    public static int removeDuplicates1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[++ i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,2}));
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
        System.out.println(removeDuplicates(new int[]{1,1}));
    }
}
