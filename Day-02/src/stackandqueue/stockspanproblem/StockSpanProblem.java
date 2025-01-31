package stackandqueue.stockspanproblem;
import java.util.Stack;
public class StockSpanProblem {
    public static void main(String[] args) {
        int[] price = {20, 70, 50, 100, 40, 75, 80};
        int[] span = stockSpan(price);

        System.out.println("prices of stock: ");
        for (int prices : price){
            System.out.println(prices + " ");
        }
        System.out.println("\nstock span : ");
        for (int s : span){
            System.out.println(s + " ");
        }
    }

    //method to calculate stock span
    public static int[] stockSpan(int[] price){
        int n = price.length;
        //array to store value of span less in index
        int[] span = new int[n];
        //stack to store index
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<n;i++){
            while (!stack.isEmpty() && price[i] >= price[stack.peek()]){
                stack.pop();
            }

            if(stack.isEmpty()){
                span[i] = i + 1;
            }else {
                span[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return span;
    }
}
