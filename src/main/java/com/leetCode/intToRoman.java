package com.leetCode;

import java.util.HashMap;

public class intToRoman {


    /***
     * 例如， 罗马数字 2 写做II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。
     * 这个特殊的规则只适用于以下六种情况：
     *
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给你一个整数，将其转为罗马数字。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/integer-to-roman
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 1 <= num <= 3999
     * */
    public static String intToRoman(int num) {

        HashMap<Integer,String > map = new HashMap<>();
        map.put(1,"I");
        map.put(2,"II");
        map.put(3,"III");
        map.put(4,"IV");
        map.put(5,"V");
        map.put(9,"IX");
        map.put(10,"X" );
        map.put(40,"XL" );
        map.put(50,"L");
        map.put(90,"XC");
        map.put(100,"C");
        map.put(400,"CD");
        map.put(500,"D");
        map.put(900,"CM");
        map.put(1000,"M");

        StringBuilder result = new StringBuilder();

        /***  1234  4位数  1*1000  M  2*100 MCC 3*10 MCCXXX 4*1 MCCXXXIV
         *      981  3位数 9*100 CM
         *      851   500+300 DCCC
         *      2586 2*1000 MM 500
         *      308  CCCVIII
         *      68  length = 2 6>5 5*Math.pow(10,length-1)+(6-5)*Math.pow(10,length-1) + 8>5 5*Math.pow(10,length-2)+(8-5)*Math.pow(10,length-2)
         *                    map.get(5*Math.pow(10,length-1))+map.get((6-5)*Math.pow(10,length-1))+map.get(5*Math.pow(10,length-2))+map.get((8-5)*Math.pow(10,length-2))
         *                    map.get(50)+map.get(10)+map.get(5)+map.get(3)
         *                    LXVIII
         *       481  length = 3 4<5  map.get(4*Math.pow(10,length-1)) + map.get(5*Math.pow(10,length-2))+map.get((8-5)*Math.pow(10,length-2)) + map.get(1)
         *
         *       698    length = 3  6>5 5*Math.pow(10,length-1)+(6-5)*Math.pow(10,length-1) +
         *
         *       783  D
         *
         *       308
         *        9 5 4 可以直接在map取值
         * */
        //不是整数
       int length = (num+"").length(); //数字长度
       if (map.get(num) == null){
            while (num > 0){
               int  curr = (int) (num/Math.pow(10,length-1));//取出每一位数字
                //这一位是9 5 4 ，则取相关的值
                if (curr == 9 || curr == 5 || curr == 4){
                    result.append(map.get((int)(curr*Math.pow(10,length-1))));
                }
                if (curr > 5 && curr < 9){
                    result.append(map.get((int)(5*Math.pow(10,length-1)))); // 70 50 20

                    int number =  (int)((curr - 5)*Math.pow(10,length-1)); // 200
                    if (number <10){
                        result.append(map.get(number));
                    }else {
                        for (int i = 0 ; i < (curr - 5); i++){
                            result.append(map.get((int)(1*Math.pow(10,length-1))));
                        }
                    }
                }
               if (curr < 4 && curr >0){
                  int number =  (int)(curr*Math.pow(10,length-1)); // 200
                  if (number <10){
                       result.append(map.get(number));
                  }else {
                      for (int i = 0 ; i < curr; i++){
                          result.append(map.get((int)(1*Math.pow(10,length-1))));
                      }
                  }

               }
                num -= (int)(curr*Math.pow(10,length-1));
                length--;
            }
            return result.toString();
       }else return map.get(num);
    }

    public static void main(String[] args) {
        int num = 308;
        System.out.println(intToRoman(num));

    }

    /***
     * 贪心算法
     *
     * */
    class Solution {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        public String intToRoman(int num) {
            StringBuffer roman = new StringBuffer();
            for (int i = 0; i < values.length; ++i) {
                int value = values[i];
                String symbol = symbols[i];
                while (num >= value) {
                    num -= value;
                    roman.append(symbol);
                }
                if (num == 0) {
                    break;
                }
            }
            return roman.toString();
        }

    }
}
