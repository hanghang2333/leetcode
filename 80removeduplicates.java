//给定一个排序的有重复的数组，可以允许有两个重复的，超过两个的只留两个。
//方法:对数组元素依次遍历，利用其已经排序这个特性，对于前两个元素直接留下，之后的每个元素都和其前两位的比较大小，等于的扔掉不管，大于的才输入。
//这里还使用了foreach循环。
public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }
}
