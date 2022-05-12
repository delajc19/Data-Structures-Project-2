/**
 * Joseph de la Viesca
 * CSC 201
 * Project 2, Question 3
 * 3/25/22
 */
package Question3;
import java.util.Stack;
public class WeirdQueue{
    private Object items[];
    private int size;
    private int k; //final index containing an element of the queue (end of queue)
    
    WeirdQueue(){
        this.size = 10;
        this.k = 0;
        this.items = new Object[size];
    }

    //Time Complexity: O(n)
    public void enqueue(Object item){
        Stack<Object> in_stack = new Stack<Object>();
        Stack<Object> out_stack = new Stack<Object>();
        //Doubles queue size to prevent overflow
        if(this.k > this.size-1){
            this.size *= 2;
            Object new_items[] = new Object[this.size];
            for(int i = 0; i < this.k;i++){
                new_items[i] = this.items[i];
            }
            this.items = new_items;
        }
        in_stack.push(item);
        out_stack.push(in_stack.pop());
        this.items[this.k] = out_stack.pop();
        this.k++;
    }

    //Time Complexity: O(n)
    public Object dequeue(){
        if(k >= 0){
            Stack<Object> in_stack = new Stack<Object>();
            Stack<Object> out_stack = new Stack<Object>();
            in_stack.push(this.items[0]);
            out_stack.push(in_stack.pop());
            //Copy items to new aray
            Object new_items[] = new Object[this.size];
            for(int i = 1; i < k; i++){
                new_items[i-1] = this.items[i];
            }
            //Redefine items data field
            this.items = new_items;
            //Decrement final position of the queue
            k--;
            return out_stack.pop();
        }
        //Returns null and gives an error message when dequeueing an empty queue
        System.out.println("Error: Stack underflow");
        return null;
    }
}
