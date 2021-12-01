package com.leetCode;

public class xorGame {
    /**
     * 黑板上写着一个非负整数数组 nums[i] 。Alice 和 Bob 轮流从黑板上擦掉一个数字，Alice 先手。如果擦除一个数字后，
     * 剩余的所有数字按位异或运算得出的结果等于 0 的话，当前玩家游戏失败。 (另外，如果只剩一个数字，按位异或运算得到它本身；如果无数字剩余，按位异或运算结果为 0。）
     *
     * 并且，轮到某个玩家时，如果当前黑板上所有数字按位异或运算结果等于 0，这个玩家获胜。
     *
     * 假设两个玩家每步都使用最优解，当且仅当 Alice 获胜时返回 true。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/chalkboard-xor-game
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 
     * 
     * */

    public boolean xorGame(int[] nums) {
        int flag = nums[0];
        for(int i = 1; i < nums.length; i++){
            flag ^= nums[i];
        }

        return flag == 0 || nums.length % 2 == 0;

    }

    /***
     *
     * 思路分析：这种题一般都是技巧题，肯定不能暴搜。
     * 首先我们nums数组中所有的元素进行异或操作，最终得到一个flag数。
     *
     * 如果flag == 0，此时小红先手，不需要进行任何操作即可获胜
     * 如果flag != 0，这时我们判断nums的大小的奇偶性
     * 	如果numsSize为奇数，则小红必定会输，因为num ^ num = 0，即nums数组中出现偶数次的元素异或之后对flag没有影响。
     * 		那么每次按照最优去元素操作，最后单出来的元素一定会被小红去掉，所以小红必输
     * 	否则numsSize为偶数，那么最后一个单出来的元素一定会被小明去掉，所以小明必输。
     *
     * */
}
