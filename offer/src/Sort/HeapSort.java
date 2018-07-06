package Sort;

public class HeapSort {
    public static void heapSort(int[] arr){
        if (arr == null || arr.length < 2)
            return;
        for (int i = 0; i < arr.length; i++){ //
            heapInsert(arr, i);
        }
        int heapsize = arr.length;
        swap(arr, 0, --heapsize);
        while (heapsize > 0){
            heapify(arr, 0, heapsize);  //重新调整出一个大根堆
            swap(arr, 0, --heapsize);   //将最大值放到最后
        }
    }

    public static void heapInsert(int[] arr, int index){
        while (arr[index] > arr[(index - 1) / 2]){
            swap(arr, index, (index - 1) / 2);
        }
    }

    public static void heapify(int[] arr, int index, int heapsize){
        int left = index * 2 + 1;
        while (left < heapsize){  //左孩子存在，没越界
            int largest = left + 1 < heapsize && arr[left + 1] > arr[left]
                    ? left + 1
                    : left;
            largest = arr[largest] > arr[index] ? largest : index;//我左右两个孩子和我哪个大（三者），哪个大哪个是largest
            if (largest == index)
                break;
            swap(arr, largest, index); //说明孩子比index大，还需要往下沉
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args){
        int[] arr = new int[]{5, 4, 8, 0, 1, 6};
        heapSort(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i]);
    }
}
