package Question2;

//Node class
public class Node{
    //Private data fields
    private Object item;
    private Node prev;
    private Node next;

    //Constructor with 
    Node(Object item){
        this.item = item;
        this.prev = null;
        this.next = null;
    }

    //Setter for item
    public void setItem(Object item){
    this.item = item;
    }

    //Getter for item
    public Object getItem(){
    return this.item;
    }
    //Setter for next
    public void setNext(Node next){
        this.next = next;
    }

    //Getter for next
    public Node getNext(){
        return this.next;
    }

    //Setter for prev
    public void setPrev(Node prev){
        this.prev = prev;
    }

    //Getter for prev
    public Node getPrev(){
        return this.prev;
    }
}