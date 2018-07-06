package problems;

/**
 * 数组中出现次数超过一半的数字 :例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 */
public class MoreThanHalfNum {
    public static int moreThanhalf(int[] array){
        if (array == null)
            return 0;
        int count = 1;
        int num = array[0];
//如果存在这么一个数，在这一for循环肯定会被找出来：因为这个数想超过数组一半必须要至少连续出现两次（核心解题思想）
        for (int i = 1; i < array.length; i++){
            if (array[i] == num)
                count++;
            else
                count--;
            if (count == 0){
                num = array[i];
                count = 1;
            }
        }
//        第二个for验证这个数是否超过数组一半
        count = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] == num) count++;
        }
        if (count > array.length / 2)
            return num;
        return 0;
    }
}
