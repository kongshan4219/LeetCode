//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 2514 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        /*
          * 注意！！！！
          * 找出的左右边界不是target的左右边界
          * 左边界是小于target的数的索引，有边界是大于target的数的索引
        */
        //找左边界
        int leftBorder = getLeftBorder(nums,target);
        //找右边界
        int rightBorder = getRightBorder(nums,target);
        //target超出数组范围哦，即大于nums最大值（leftBoder不会更新）或小于最小值（rightBoder不会更新）
        if (leftBorder == -2 || rightBorder == -2){
            return new int[] {-1,-1};
        }
        //taget在数组中存在
        else if (rightBorder - leftBorder > 1) {
            return  new int[] {leftBorder + 1,rightBorder - 1};
        }
        //target在数组最大最小值之间，但是数组中不存在target
        else {
            return new int[] {-1,-1};
        }
    }
    int getLeftBorder(int[] nums, int target) {
        //左边界
        int left = 0;
        int right = nums.length - 1;
        int leftBorder = -2; // 记录是否找到
        while (left <= right) {
            int idx = (left + right) / 2;
            //要找到小于target的,将target算作大于target的
            //[?,target]
            if (nums[idx] < target){
                //[idx+1,right]
                left = idx + 1;
            }else if (nums[idx] >= target){
                //[left,idx-1]
                right = idx - 1;
                leftBorder = right;
            }
        }
        return leftBorder;
    }
    int getRightBorder(int[] nums, int target) {
        //右边界
        int left = 0;
        int right = nums.length - 1;
        int rightBorder = -2; // 记录是否找到
        while (left <= right) {
            //要找到大于target的,将target算作小于target的
            //[taget,?]
            int idx = (left + right) / 2;
            if (nums[idx] <= target) {
                //[idx+1,right]
                left = idx + 1;
                rightBorder = left;
            }else if (nums[idx] > target) {
                //[left,idx-1]
                right = idx - 1;
            }
        }
        return rightBorder;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
