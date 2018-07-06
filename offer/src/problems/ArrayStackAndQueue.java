package Problems;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ArrayStackAndQueue{

    public static class ArrayStack {
        private int[] arr;
        private int index;

        public ArrayStack(int initSize){
            if (initSize < 0){
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new int[initSize];
            index = 0;
        }

        public Integer peek(){ //返回栈顶元素，但不删除
            if (index == 0)
                return null;
            return arr[index - 1];
        }

        public void push(int obj){
            if (index == arr.length)
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            arr[index++] = obj;
        }

        public Integer pop(){
            if (index == 0)
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            return arr[--index];
        }
    }

    public static class ArrayQueue{
        private Integer[] arr;
        private Integer size;
        private Integer start;
        private Integer end;

        public ArrayQueue(int initSize) {
            if (initSize < 0)
                throw new IllegalArgumentException("The init size is less than 0");
            arr = new Integer[initSize];
            size = 0;
            start = 0;
            end = 0;
        }

        public Integer peek(){
            if (size == 0)
                return null;
            return arr[start];
        }

        public void push(int obj){
            if (size == arr.length)
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            size++;
            arr[end] = obj;
            end = end == arr.length - 1 ? 0 : end + 1;
        }

        public Integer poll(){
            if (size == 0)
                return null;
            size--;
            int tmp = start;
            start = start == arr.length - 1 ? 0 : start + 1;
            return arr[tmp];
        }
    }

    public static void main(String[] args) {
        ArrayQueue arrayStack = new ArrayQueue(3);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        System.out.println(arrayStack.poll());
        System.out.println(arrayStack.peek());
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator iterator = list.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
        System.out.println(new Date());
    }
}



