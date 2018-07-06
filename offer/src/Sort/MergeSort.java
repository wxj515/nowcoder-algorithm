package Sort;

/**
 * 归并排序
 */
public class MergeSort {
    public static void mergeSort(int[] arr){  //主方法
        if (arr == null || arr.length < 2)
            return;
        sortProcess(arr, 0, arr.length - 1);
    }

    public static void sortProcess(int[] arr, int L, int R){
        if (L == R)  //这个范围只有一个数，也就是已经排好了
            return;
        int mid = L + ((R - L) >> 1); //L和R中点的位置
        sortProcess(arr, L, mid);  //T(n/2)子过程：左部分排好
        sortProcess(arr, mid + 1, R);  //T(n/2)右部分排好
    }

    public static void merge(int[] arr, int L, int mid, int R){
        int[] help = new int[R - L + 1]; //辅助数组:用来存放合并后也就是排好序的数组
        int i = 0;
        int p1 = L;  //指向左侧部分最小值
        int p2 = mid + 1;  //指向右侧部分最小值
        while (p1 <= mid && p2 <= R){  //如果p1超过mid，说明左侧已经排完，右侧同理
            help[i++] = arr[p1] < arr[p2] ? arr[p1] : arr[p2];  //谁小谁就往辅助数组里填
        }
        while (p2 <= R){  //假如是p1越界也就是排完了
            help[i++] = arr[p2++];
        }
        while (p1 <= mid){  //不用额外判断p2 > R && p1 <= mid,只是后面那个有用，且满足后面那个说明肯定是前面那个越界
            help[i++] = arr[p1++];
        }
        for (i = 0; i < arr.length; i++){
            arr[L + i] = help[i];  //将辅助数组复制到原数组，注意不能直接arr[i],因为merge()要在递归过程中多次被调用，所以左边界不一定是0
        }
    }
}
