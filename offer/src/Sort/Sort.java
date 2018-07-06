package Sort;

public class Sort {
    public void bubbleSort(int[] arr){  //冒泡排序
        if (arr == null || arr.length < 2){
            return;
        }
        for (int end = arr.length - 1; end > 0; end--){
            for (int i = 0; i < end; i++){
                int temp;
                if (arr[i] > arr[i+1]){
                    temp = arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                }
            }
        }
    }

    public void selectSort(int[] arr){  //选择排序
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length - 1; i++){
            int minIndex=i;
            for (int j = i+1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            int tmp = arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=tmp;
        }
    }

    public void insertSort(int[] arr){  //插入排序
        if (arr == null || arr.length < 2){
            return;
        }
        for (int i = 1; i < arr.length; i++){
            for (int j = i - 1; j >= 0 && arr[j] > arr[j+1]; j--){
                int tmp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1]=tmp;
            }
        }
    }

    public static void main(String[] args){
        Sort m = new Sort();
        int arr[]={1,8,6,2,5,3,14,10};
     //   m.bubbleSort(arr);
     //   m.selectSort(arr);
        m.insertSort(arr);
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+",");
        }
    }
}
