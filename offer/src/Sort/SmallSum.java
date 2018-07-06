package Sort;

/**
 * 最小和问题
 */
public class SmallSum {
    public static int smallSum(int[] arr){
        if (arr == null || arr.length < 2)
            return 0;
        return mergeSort(arr, 0, arr.length - 1);
    }
    public static int mergeSort(int[] arr, int l, int r){
        if (l == r)
            return 0;
        int mid = l + ((r - l) >> 1);  //(l+r)/2不安全容易溢出
        return mergeSort(arr, l, mid)
                +mergeSort(arr, mid + 1, r)
                +merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int mid, int r){
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = 1;
        int p2 = mid + 1;
        int res = 0;
        while (p1 <= mid && p2 <= r){
            res += arr[p2] > arr[p1] ? (r - p2 + 1)*arr[p1] : 0;
            help[i++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
        }
        while (p1 <= mid){
            help[i++] = arr[p1++];
        }
        while (p2 <= r){
            help[i++] = arr[p2++];
        }
        for (i = 0; i < arr.length; i++){
            arr[l + i] = help[i];
        }
        return res;
    }
}
