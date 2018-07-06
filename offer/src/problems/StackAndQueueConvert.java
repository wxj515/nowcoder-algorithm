package Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueueConvert {
    public static class TwoStacksQueue{
        Stack<Integer> stackPush = new Stack<>();
        Stack<Integer> stackPop = new Stack<>();

        public void push(int o){
            stackPush.push(o);
        }

        public int pop(){
            if (stackPush.isEmpty() && stackPop.isEmpty())
                throw new RuntimeException("The stack is empty");

            if (stackPop.isEmpty())
                while (!stackPush.isEmpty())
                    stackPop.push(stackPush.pop());

            return stackPop.pop();
        }
    }
    public static class TwoQueueStack{
        private Queue<Integer> data;
        private Queue<Integer> help;

        public TwoQueueStack(){
            data = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }

        public void push(int o){
            data.add(o);
        }

        public int poll(){
            if (data.isEmpty()){
                throw new RuntimeException("The queue is empty");
            }

            while (data.size() > 1){
                help.add(data.poll());
            }
            swap();
            return data.poll();
        }

        public int peek(){
            if (data.isEmpty()){
                throw new RuntimeException("The queue is empty");
            }
//            int res = 0;  我的写法，下面左神
//            while (data.size() > 0){
//                res = data.poll();
//                help.add(res);
//            }
            while (data.size() != 1)
                help.add(data.poll());
            int res = data.poll();
            help.add(res);
            swap();
            return res;
        }

        public void swap(){
            Queue<Integer> tmp = help;
            help = data;
            data = tmp;
        }
    }
}
