package com.leetCode;

import java.util.Collections;

public class computeTwoArea {

    /***
     *
     * 给你 二维 平面上两个 由直线构成的 矩形，请你计算并返回两个矩形覆盖的总面积。
     *
     * 每个矩形由其 左下 顶点和 右上 顶点坐标表示：
     *
     * 第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。
     * 第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rectangle-area
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 不重叠的情况：  ax2 <= bx1  || bx2 <= ax1 || ay1 >= by2 || by1 >= ay2  ||  ax2 <= bx1
     *
     *              result = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1)
     *
     * 有重叠的情况：  1.( bx1 >= ax1 && bx1 < ax2  && ( (by2 > ay1  && by2 <= ay2 )||( by1 >= ay1 && by1 < ay2))) ||
     *                  ( bx2 > ax1 && bx2 <= ax2  && ( (by2 > ay1  && by2 <= ay2 )||( by1 >= ay1 && by1 < ay2))) ||
     *                  ((bx1 <= ax1 && bx2 >= ax2 ) || (ax1 <= bx1 && ax2 >= bx2))
     *
     *
     * */
     public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
                int x1 = Math.max(ax1,bx1);
                int x2 = Math.min(bx1,bx2);
                int y1 = Math.max(ay1,by1);
                int y2 = Math.min(by2,ay2);

                if(ax2 <= bx1  || bx2 <= ax1 || ay1 >= by2 || by1 >= ay2   ){
                    return (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);
                }else {
                    return ( (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1) )- (x2 - x1) * (y2 - y1);
                }
    }
}
