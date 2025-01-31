package stackandqueue.implementqueueusingstacks;
import java.util.Stack;
import java.util.Queue;
public class ImplementQueue {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    // enqueue method
    public void enqueue(int value){
        //push each value in stack1
        stack1.push(value);
    }
    // dequeue method
    public int dequeue(){
        if (stack1.isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        while (!stack1.isEmpty()){
           // remove element from stack1 and push it in stack 2
            stack2.push(stack1.pop());
        }
        int value = stack2.pop();
        while (!stack2.isEmpty()){
            // remove elements from stack 2 and push back in stack 1
            stack1.push(stack2.pop());
        }
        return value;
    }
    public int peek(){
        if (stack1.isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        while (!stack1.isEmpty()){
            // remove element from stack1 and push it in stack 2
            stack2.push(stack1.pop());
        }
        int value = stack2.peek();
        while (!stack2.isEmpty()){
            // remove elements from stack 2 and push back in stack 1
            stack1.push(stack2.pop());
        }
        return value;
    }

    public static void main(String[] args) {
      ImplementQueue queue = new ImplementQueue();


      queue.enqueue(1);
      queue.enqueue(2);
      queue.enqueue(3);
      queue.enqueue(4);
        System.out.println("Top element: " + queue.peek());
        queue.dequeue();
        System.out.println("New top element: " + queue.peek());
    }
}
