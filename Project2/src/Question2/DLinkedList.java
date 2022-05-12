/**
 * Joseph de la Viesca
 * CSC 201
 * Project 2, Question 2
 * 3/25/22
 */
package Question2;

public class DLinkedList implements MyList{
    private Node head;
    private Node tail;
    
    //Setter for head
    public void setHead(Node head){
        this.head = head;
    }

    //Getter for head
    public Node getHead(){
        return this.head;
    }

    //Setter for tail
    public void setTail(Node tail){
        this.tail = tail;
    }

    //Getter for tail
    public Node getTail(){
        return this.tail;
    }

    //Douby linked list functions

    //insert item at index
    //Worst Case: O(n)
    public boolean insert(int index, Object item) {
        //If the chosen index is out of bounds, insert will return false and print an error message
        if(index >= 0 || index <= size() - 1){
            //Assign the node that will be the new node's next node
            //to the head and iteratively assign the next_new_node
            //to its next node index times so next_new_node is at 
            //the right position. 
            Node next_new_node = head;
            for(int i = 0; i < index; i++){
                next_new_node = next_new_node.getNext(); 
            }
            Node new_node = new Node(item);
            Node prev_new_node = next_new_node.getPrev();
            //Reassign pointers on the left side of the new node
            prev_new_node.setNext(new_node);
            new_node.setPrev(prev_new_node);
            //Reassign pointers on the right side of the new node
            new_node.setNext(next_new_node);
            next_new_node.setPrev(new_node);
            
            return true;
        }
        else if(head.getNext() == null){
            System.out.println("Error: Cannot insert into a singleton or empty list.");
        }
        System.out.printf("Error: Index %d out of bounds\n",  index);
        return false;
    }

    //append item to the end of the list
    //Worst Case: O(1)
    public boolean append(Object item) {
        //If item is null, the function exits with an error message and a false return value.
        if(item != null){
            //Instantiate a new node with item as the data field
            Node new_node = new Node(item);

            //If head is null, then set the new node as both the head and the tail because it is the only element
            if(this.head == null){
                this.head = new_node;
                this.tail = new_node;                
            }
            //Else, make tail point forward to the new node and the new node point backward to the tail and reassign tail to new node
            else{
                this.tail.setNext(new_node);
                new_node.setPrev(this.tail);
                
                
            }
            this.tail = new_node;
            return true;
        }
        System.out.println("Error: Cannot append null item");
        return false;
    }

    //clear entire list
    //Worst Case: O(1)
    public void clear() {
        this.head = null;
    }

    //returns true if the list is empty. returns false otherwise
    //Worst Case: O(n)
    public boolean isEmpty() {
        if(size() < 0){
            return true;
        }
        return false;
    }

    //returns the size of the list
    //Worst Case: O(n)
    public int size() {
        //Increment a counter through list until it reaches the tail and returns the counter
        if(head != null){
            Node curr = head;
            int i = 0;
            while(curr != null){
                i++;
                curr = curr.getNext();
            }
            return i;
        }
        //If head is null, then -1 is returned for size (empty array)
        return -1;
    }

    //replace item at a node of a chosen index with the another item
    //Worst Case: O(n)
    public boolean replace(int index, Object item) {
        //If the chosen index is out of bounds, replace returns false and an error message is printed
        if(index > -1 || index < size()){
            Node rep_node = head;
            for(int i = 0; i < index; i++){
                rep_node = rep_node.getNext();
            }
            rep_node.setItem(item);
            return true;
        }
        System.out.printf("Error: Index %d out of bounds\n", index);
        return false;
    }

    //removes the node at a given index
    //Worst Case: O(n)
    public boolean remove(int index) {
        //If the chosen index is out of bounds, remove returns false and an error message is printed
        if(index > -1 || index < size()){
            //Assign the node that will be the node to delete's next node
            //to the head and iteratively assign the next_del_node
            //to its next node index times so del_node is at 
            //the right position. 
            Node del_node = head;
            for(int i = 0; i < index; i++){
                del_node = del_node.getNext(); 
            }
            //for removing the head, swap the head and the head's next node
            //to prevent deleting the list
            if(del_node == head){
                this.head = del_node.getNext();
                del_node = null;
            }
            //for removing the tail, replace the tail with the tail's
            //previous node
            else if(del_node == tail){
                this.tail = del_node.getPrev();
                del_node = null;
            }
            else{
                Node next_del_node = del_node.getNext(); //initialize a new node for the node after the node to delete
                Node prev_del_node = del_node.getPrev(); //initialize a new node for the node before the node to delete

                //Connect the two new nodes by swapping the pointers from del_node, leaving del_node to garbage collection
                prev_del_node.setNext(next_del_node);
                next_del_node.setPrev(prev_del_node);
            }

            return true;
        }
        System.out.printf("Error: Index %d out of bounds\n",  index);
        return false;
        
    }

    //returns the item at a given index
    //Worst Case: O(n)
    public Object get(int index) {
        Node curr = head;
        for(int i = 0; i < index; i++){
            curr = curr.getNext();
        }
        if(curr.getItem() != null){
            return curr.getItem();
        }
        //Returns null if item is null
        return null;
    }
}
