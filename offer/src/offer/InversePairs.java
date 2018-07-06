/**
 * 逆序对问题
 */
package Offer;

public class InversePairs {
    public static int inversePairs(int[] array){
        if (array == null || array.length < 2)
            return 0;
        return mergeSort(array, 0, array.length - 1);
    }

    public static int mergeSort(int[] arr, int L, int R){
        if (L == R)
            return 0;
        int mid = L + ((R - L) >> 1);
        return (mergeSort(arr, L, mid)
                +mergeSort(arr, mid + 1, R)
                +merge(arr, L, mid, R)) % 1000000007;
    }

    public static int merge(int[] arr, int L, int mid, int R){
        int[] help = new int[R - L + 1];
        int i = 0;
        int count = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R){
            count += arr[p2] < arr[p1] ? (mid - p1 + 1) : 0;
            count %= 1000000007;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid){
            help[i++] = arr[p1++];
        }
        while (p2 <= R){
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++){
            arr[L + i] = help[i];
        }
        return count;
    }
}
