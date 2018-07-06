package problems; /**
 * 问题：奇数在左边，偶数在右边
 * 思路：不能用荷兰国旗解决，因为partition过程不能保证稳定性，所以需要用到类似外排的方式
 */

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class oddAndeven {
    public static void reOrderArray(int [] array) {
        if (array == null)
            return;
        int sum = array.length;
        int[] arr = new int[sum];
        int less = -1;
        int cur = 0;
        int oddcount = 0;
        while (cur < sum){
            if (array[cur] % 2 != 0){
                swap(array, ++less, cur++);
            }else {
                arr[oddcount++] = array[cur++];
            }
        }
        for (int i = 0, j = sum - oddcount; j < sum; j++){
            array[j] = arr[i++];
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        reOrderArray(arr);
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
        }
    }
}
