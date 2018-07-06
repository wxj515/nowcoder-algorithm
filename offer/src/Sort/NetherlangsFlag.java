package Sort;

/**
 * 荷兰国旗问题：给定num和数组arr，将小于num放数组左边，等于num放中间，大于num放数组右边
 */
public class NetherlangsFlag {
    public static int[]  partition(int[] arr, int L, int R, int num){
        int less = L - 1;
        int more = R + 1;
        int cur = L;
        while (cur < more) {  //结束条件：当前cur和more重合
            if (arr[cur] < num)
                swap(arr, ++less, cur++);
            else if (arr[cur] > num)
                swap(arr, --more, cur);
            else
                cur++;
        }
        return new int[]{less + 1, more - 1}; //放回相同部分的左边界后后边界
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args){
        int[] arr = new int[]{5, 4, 8, 0, 1, 6};
        partition(arr, 0, arr.length - 1, 6);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i]);
    }
}

