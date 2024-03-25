package com.shuttle.exer.leetcode.unclassified;

public class Solution33 {

    /**
     * 思路：二分查找，排序数组旋转后，一定还是有一部分是有序的
     * 时间复杂度：O(log N) N 是 nums 数组的长度
     * 空间复杂度：O(1)
     *
     * @param nums   旋转排序数组
     * @param target 目标值
     * @return 目标值在旋转排序数组中的索引位置
     */
    public int search(int[] nums, int target) {
        int numsLen = nums.length;
        if (nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int leftIndex = 0;
        int rightIndex = numsLen - 1;

        while (leftIndex <= rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            if (nums[midIndex] == target) {
                return midIndex;
            }
            // [4, 5, 6, 7, 0, 1, 2] target = 6, midIndex = 3
            // 旋转后一定有一部分是有序的
            if (nums[0] <= nums[midIndex]) {
                // 左边有序
                if (nums[0] <= target && nums[midIndex] > target) {
                    rightIndex = midIndex - 1;
                } else {
                    leftIndex = midIndex + 1;
                }
            } else {
                // [4, 5, 6, 7, 0, 1, 2] target = 1, midIndex = 3
                // 右边有序
                if (nums[midIndex] < target && target <= nums[rightIndex]) {
                    leftIndex = midIndex + 1;
                } else {
                    rightIndex = midIndex - 1;
                }
            }
        }

        return -1;
    }

}
