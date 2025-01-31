package stackandqueue.sortstackusingrecursion;
import java.util.Stack;
public class SortStackRecursion {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(32);
        stack.push(3);
        stack.push(21);
        stack.push(10);
        System.out.println("Original stack is: " + stack);

        //call the pop and sort method
        popAndSort(stack);
        System.out.println("Sorted stack: ");
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
    // method to sort stack in ascending with recursion
    public static void popAndSort(Stack<Integer> stack){
        //base case
        if (stack.isEmpty()){
            System.out.println("Stack empty");
            return;
        }
        //pop all elememt
        int top = stack.pop();

        //sort the stack again call itself
        popAndSort(stack);

        //insert pop element back in sorted
        insertStack(stack, top);
    }

    // method to insert the element into sorted stack
    public static void insertStack(Stack<Integer> stack, int top){
       if (stack.isEmpty() || stack.peek() >= top){
           stack.push(top);
           return;
       }
       int temp = stack.pop();
       insertStack(stack, top);

       stack.push(temp);
    }
}
