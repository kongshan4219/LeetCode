//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100] 
//
// 示例 2： 
//
// 
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 已按 非递减顺序 排序 
// 
//
// 
//
// 进阶： 
//
// 
// 请你设计时间复杂度为 O(n) 的算法解决本问题 
// 
//
// Related Topics 数组 双指针 排序 👍 902 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        int[] res = new int[nums.length];
        int idx = nums.length-1;
        while (left<=right){
            if ( nums[left]*nums[left]>nums[right]*nums[right]){
                res[idx] = nums[left]*nums[left];
                left++;
                idx--;
            }else {
                res[idx] = nums[right]*nums[right];
                right--;
                idx--;
            }
        }
        return res;

        //while (left<=right){
        //    //比较左右边界 例子：初始 [-9,-4,0,3,10]
        //    //[-9,-4,0,3,100].
        //    //[3,-4,0,-9,100]
        //    if (nums[left]*nums[left]>nums[right]*nums[right]){
        //        //左边界大于右边界，但还不能确定左边界的平方是不是最大的，[3,-4,0,81,100]
        //        //因为此时左边界不一定是原始的左边界，可能是从右边界交换过来的，像这样[3,-4,0,81,100]
        //        if (nums[left]*nums[right]>0){
        //            //此时,可以确定 左方 大于 右方，且 左方 为当前最大值
        //            int tmp = nums[right];
        //            nums[right] = nums[left]*nums[left];
        //            nums[left] = tmp;
        //            right--;
        //        }else {
        //            //此时， 不确定 左方 是不是最大
        //            int tmp = nums[right];
        //            nums[right] = nums[left];
        //            //nums[left] = tmp*tmp;
        //            //left++;
        //        }
        //    }else {
        //        //[3,-4,0,-9,100]
        //       //左边界方小于右边界方， 但 左方 不一定是最小，但右方确定最大
        //        if (nums[left]*nums[right]<0){
        //            nums[right] = nums[right]*nums[right];
        //            right--;
        //            //此时 左方 最小
        //            //nums[left] = nums[left]*nums[left];
        //            //left++;
        //        }else {
        //            //nums[right] = nums[right]*nums[right];
        //            //right--;
        //            nums[left] = nums[left]*nums[left];
        //            left++;
        //        }
        //    }
        //}
        //return nums;

        //for循环计算后排序
        //for(int i=0;i<nums.length;i++){
        //    nums[i] = nums[i]*nums[i];
        //}
        //Arrays.sort(nums);
        //return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
