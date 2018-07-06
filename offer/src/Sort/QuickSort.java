package Sort;

/**
 * 快速排序分经典快排和随机快排
 * 经典快排：选最后一个数作为基准，平均复杂度为O(n*logn)
 * 随机快排：随机选一个数，复杂度是按数学期望算出来的，也就是从第一个数到最后一个树逐个选择，
 * 选i的概率*以i为基准的复杂度，时间复杂度一样，额外空间O(logn),是最常用的排序方式，因为规模一样，但常数项小，比如归并排序有很多while()
 * 额外空间是用来记录断点的，也就是代码中的p，也是相等部分的边界，最差的情况是O(N),最好的情况是O(logn),所以也是个概率问题，长期期望是O(logn),所以最终是O(logn)
 * 稳定性不是说一个算法的复杂度忽高忽低，一个东西变成概率，长期期望就是它的复杂度，而稳定性有它特定的含义
 */
public class QuickSort {
    public static void quickSort(int[] arr){
        if (arr == null || arr.length < 2)
            return;
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int L, int R){
        if (L < R){
           //加了这句就是随机快排，因为经典快排都是选最后一个数，所以随机选个数换到最后
            swap(arr, L + (int)(Math.random() * (R - L + 1)), R);
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1);
            quickSort(arr, p[0] + 1, R);
        }
    }

    public static int[]  partition(int[] arr, int L, int R){
        int less = L - 1;
        int more = R + 1;
        //如果想继续用荷兰国旗的代码，就必须记住一开始arr[R],因为arr[R]会变(变成第一个被找到比原arr[R]大的数)
        //或者直接more=R;就是最后一个数直接进more域，不参与比较，最后再调换
        int num = arr[R];
        while (L < more) {  //结束条件：当前cur和more重合
            if (arr[L] < num)
                swap(arr, ++less, L++);
            else if (arr[L] > num)
                swap(arr, --more, L);
            else
                L++;
        }
       //swap(arr, more, R);
        return new int[]{less + 1, more}; //放回相同部分的左边界后后边界
    }

    public static void swap(int[] arr, int i, int j){
//        int tmp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = tmp;
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[j]^arr[i];
        arr[i] = arr[i]^arr[j];
//        arr[i] ^= arr[j];
//        arr[j] ^= arr[i];
//        arr[i] ^= arr[j];
    }

    public static void main(String[] args){
        int[] arr = new int[]{5, 4, 8, 0, 1, 6};
        quickSort(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i]);
    }
}
