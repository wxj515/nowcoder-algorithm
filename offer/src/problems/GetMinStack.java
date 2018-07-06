/**
 * 实现getmin方法获取栈最小元素，要求时间复杂度O(1)
 * 思路1：建立两个栈，一个专门存最小值，进栈元素大于当前stackmin栈顶元素的时候不进，反之进
 * 思路2：min栈和data栈元素总量完全同步，重复存最小值
 */
package Problems;

import java.util.Stack;

public class GetMinStack {
    public static class MyStack1{
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack1(){
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        public void push(int num){
            if (stackMin.isEmpty())
                stackMin.push(num);
            else if (getmin() >= num)
                stackMin.push(num);
            stackData.push(num);
        }

        public int pop(){
            if (stackData.isEmpty())
                throw new RuntimeException("Your stack is empty");
            int value = stackData.pop();
            if (value == getmin())
                stackMin.pop();
            return value;
        }

        public int getmin(){
            if (stackMin.isEmpty())
                throw new RuntimeException("Your stack is empty");
            return stackMin.peek();
        }
    }

    public static class MyStack2{
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack2(){
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        public void push(int num){
            if (stackMin.isEmpty())
                stackMin.push(num);
            else if (getmin() >= num)
                stackMin.push(num);
            else
                stackMin.push(getmin());
            stackData.push(num);
        }

        public int pop(){
            if (stackData.isEmpty())
                throw new RuntimeException("Your stack is empty");
            stackMin.pop();
            return stackData.pop();
        }

        public int getmin(){
            if (stackMin.isEmpty())
                throw new RuntimeException("Your stack is empty");
            return stackMin.peek();
        }
    }
}
