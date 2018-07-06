package problems; /**
 * 旋转数组最小数：数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1
 * 按照我一开始的想法，用第一个数作为比较不行，而且也没有处理好相等情况
 * 相等情况不好判断在哪边，这时应该缩小查找范围
 */

import java.util.ArrayList;
public class largest {
    public static int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0)
            return 0;
        int l = 0;
        int r = array.length - 1;
        while (l < r){
            int mid = l + ((r - l) >> 1);
            if (array[mid] > array[r]) {
                l = mid + 1;
                mid = l + ((r - l) >> 1);
            }else if (array[mid] == array[r]){
                r--;
            }else {
                r = mid;
            }
        }
        return array[r];
    }

    public static void main(String[] args){
        int[] arr = new int[]{1,1,1,0,1};
        System.out.println(minNumberInRotateArray(arr));
    }
}
