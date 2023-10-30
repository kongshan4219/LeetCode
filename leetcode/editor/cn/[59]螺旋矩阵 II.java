//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1190 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        //一圈一圈画，从外到内
        //区间 左闭右开
        int[][] res = new int[n][n];
        int loop = n / 2;//总圈数
        int mid = n / 2; // 矩阵中间的位置，例如：n为3， 中间的位置就是(1，1)，n为5，中间位置为(2, 2)
        int count = 1; // 用来给矩阵中每一个空格赋值
        int offset = 1; // 需要控制每一条边遍历的长度，每次循环右边界收缩一位
        int x,y;
        int startx = 0;
        int starty = 0;
        while(loop>0){
            x = startx;
            y = starty;
            //上
            while (x < n-offset){
                res[starty][x] = count;
                count++;
                x++;
            }
            //右
            while (y < n-offset){
                res[y][x] = count;
                count++;
                y++;
            }
            //下
            while (x > startx){
                res[y][x] = count;
                count++;
                x--;
            }
            //左
            while (y > starty){
                res[y][startx] = count;
                y--;
                count++;
            }
            startx++;
            starty++;
            offset++;
            loop--;
        }
        // 如果n为奇数的话，需要单独给矩阵最中间的位置赋值
        if (n % 2 == 1) {
            res[mid][mid] = count;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
