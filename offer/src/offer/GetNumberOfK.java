/**
 * 统计一个数字在排序数组中出现的次数
 */
package Offer;

public class GetNumberOfK {
    public int getNumberOfK(int [] array , int k) {
        if (array == null)
            return 0;
        int firstk = getFirstK(array, k, 0, array.length - 1);
        int lastk = getLastK(array, k, 0, array.length - 1);
        if (firstk != -1 && lastk != -1){
            return lastk - firstk + 1;
        }
        return 0;
    }

    public int getFirstK(int[] arr, int k, int l, int r){
        while (r >= l){
            int mid = l + ((r - l) >> 1);
            if (arr[mid] > k){
                r = mid - 1;
            }else if (arr[mid] < k){
                l = mid + 1;
            }else if (mid - 1 >= l && arr[mid - 1] == k){ //也可以写成mid-1 >= 0
                r = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public int getLastK(int[] arr, int k, int l, int r){
        if (l > r)
            return -1;
        int mid = l + ((r - l) >> 1);
        if (arr[mid] > k){
            return getLastK(arr, k, l, mid - 1);
        }else if (arr[mid] < k){
            return getLastK(arr, k, mid + 1, l);
        }else if (mid + 1 <= r && arr[mid + 1] == k){  //也可以写成mid+1 < arr.length
            return getLastK(arr, k, mid + 1, r);
        }else {
            return mid;
        }
    }
}
