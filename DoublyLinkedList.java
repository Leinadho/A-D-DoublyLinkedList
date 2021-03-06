//import java.util.Iterator;
//import java.util.ListIterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  Daniel Cosgrove
 *  @version 13/10/16 18:15
 */


/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * @param <T> This is a type parameter. T is used as a class name in the
 * definition of this class.
 *
 * When creating a new DoublyLinkedList, T should be instantiated with an
 * actual class name that extends the class Comparable.
 * Such classes include String and Integer.
 *
 * For example to create a new DoublyLinkedList class containing String data: 
 *    DoublyLinkedList<String> myStringList = new DoublyLinkedList<String>();
 *
 * The class offers a toString() method which returns a comma-separated sting of
 * all elements in the data structure.
 * 
 * This is a bare minimum class you would need to completely implement.
 * You can add additional methods to support your code. Each method will need
 * to be tested by your jUnit tests -- for simplicity in jUnit testing
 * introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>>
{

    /**
     * private class DLLNode: implements a *generic* Doubly Linked List node.
     * nested classes
     */
    private class DLLNode
    {
        public final T data; // this field should never be updated. It gets its
                             // value once from the constructor DLLNode.
        public DLLNode next;
        public DLLNode prev;
    
        /**
         * Constructor
         * @param theData : data of type T, to be stored in the node
         * @param prevNode : the previous Node in the Doubly Linked List
         * @param nextNode : the next Node in the Doubly Linked List
         * @return DLLNode
         */
        public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) 
        {
          data = theData;
          prev = prevNode;
          next = nextNode;
        }
    }

    // Fields head and tail point to the first and last nodes of the list.
    private DLLNode head, tail;
    private boolean reversed;
    private int size;

    /**
     * Constructor
     * @return DoublyLinkedList
     */
    public DoublyLinkedList() 
    {
      head = null;
      tail = null;
      
      size = 0;
      reversed = false;
    }
    
    public DoublyLinkedList(T data)
    {
    	head = new DLLNode(data, tail, tail);
    	tail = head;
    }

    /**
     * Tests if the doubly linked list is empty
     * @return true if list is empty, and false otherwise
     *
     * Worst-case asymptotic runtime cost: TODO
     *
     * Justification:
     *  TODO
     */
    public boolean isEmpty()
    {
      if(head==null & tail==null)
      {
    	  return true;	//DLL empty iff both head & tail are null
      }	
      return false;
    }

    /*
    public Iterator<DLLNode> iterator(){
    	
    	DLLNode currentNode = head;
    	
    	public boolean hasNext(){	//returns true iff iteration has more elements, else returns false
    		if(currentNode != tail){return true;}
    		return false;
    	}
    	
    	public DLLNode next(){	//returns next element in iteration
    		currentNode = currentNode.next;
    		return currentNode;
    	}
    	
    	public void remove(){	//removes last element returned by iterator (optional operation)
    		
    		currentNode.prev.next = currentNode.next;
    		currentNode.next.prev = currentNode.prev;
    			
    	}
    	return ;
    
    }	
*/
    
    
    /**
     * Inserts an element in the doubly linked list
     * @param pos : The integer location at which the new data should be
     *      inserted in the list. We assume that the first position in the list
     *      is 0 (zero). If pos is less than 0 then add to the head of the list.
     *      If pos is greater or equal to the size of the list then add the
     *      element at the end of the list.
     * @param data : The new data of class T that needs to be added to the list
     * @return none
     *
     * Worst-case asymptotic runtime cost: TODO
     *
     * Justification:
     *  TODO
     */
    public void insertBefore( int pos, T data ) 
    {
      if(pos<0){
    	  DLLNode newNode = new DLLNode(data,tail,head);	//is head's previous node tail?????
    	  head.prev = newNode;
    	  head = newNode;
      	}
      else if(pos>=size){
    	  DLLNode newNode = new DLLNode(data,tail,head);	//is head's previous node tail?????
    	  tail.next = newNode;
    	  tail = newNode;
      }
      else {
    	  DLLNode nextNode = head;
    	  for(int i=0; i<pos ; i++ )	//iterate through list sequentially (using links), until position pos is reached
    	  {
    		  nextNode = nextNode.next;
    	  }
    	  //insert new node
    	  DLLNode newNode = new DLLNode(data,nextNode.prev,nextNode);
    	  nextNode.prev.next = newNode;
    	  nextNode.prev = newNode;
      }
      size++;
      return;
    }

    /**
     * Returns the data stored at a particular position
     * @param pos : the position
     * @return the data at pos, if pos is within the bounds of the list, and null otherwise.
     *
     * Worst-case asymptotic runtime cost: TODO
     *
     * Justification:
     *  TODO
     *
     * Worst-case precise runtime cost: TODO
     *
     * Justification:
     *  TODO
     */
    public T get(int pos) 
    {
    	if(pos > -1 & pos < size){
	    	DLLNode nextNode = head;
	    	for(int i=0; i<pos ; i++ )	//iterate through list sequentially (using links), until position pos is reached
		  	{
	    		nextNode = nextNode.next;
		  	}
	    	return nextNode.data;
	    }
    	else{
    		return null;
    	}
    }

    /**
     * Deletes the element of the list at position pos.
     * First element in the list has position 0. If pos points outside the
     * elements of the list then no modification happens to the list.
     * @param pos : the position to delete in the list.
     * @return true : on successful deletion, false : list has not been modified. 
     *
     * Worst-case asymptotic runtime cost: TODO
     *
     * Justification:
     *  TODO
     */
    public boolean deleteAt(int pos) 
    {
    	DLLNode nextNode = head;
    	if(pos >-1 && pos < size)
    	{
	    	for(int i=0; i<pos ; i++ )	//iterate through list sequentially (using links), until position pos is reached
		  	{
	    		nextNode = nextNode.next;
		  	}
	    	if(nextNode != null){
	    		nextNode.prev.next = nextNode.next;
	    		nextNode.next.prev = nextNode.prev;
	    		return true;
	    	}
    	}
    	return false;
    }

    /**
     * Reverses the list.
     * If the list contains "A", "B", "C", "D" before the method is called
     * Then it should contain "D", "C", "B", "A" after it returns.
     *
     * Worst-case asymptotic runtime cost: TODO
     *
     * Justification:
     *  TODO
     */
    public void reverse()
    {
    	reversed = !reversed;
    }


    /*----------------------- STACK */
    /**
     * This method should behave like the usual push method of a Stack ADT.
     * If only the push and pop methods are called the data structure should behave like a stack.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to push on the stack
     *
     * Worst-case asymptotic runtime cost: TODO
     *
     * Justification:
     *  TODO
     */
    public void push(T item) 
    {
    	if(isEmpty())
    	{
    		DLLNode newNode = new DLLNode(item,tail,head);
    		tail = newNode;
    		head = newNode;
    		size++;
    	}
      DLLNode newNode = new DLLNode(item, tail, head);
      tail.next = newNode;
      tail = newNode;
      size++;
    }

    /**
     * This method should behave like the usual pop method of a Stack ADT.
     * If only the push and pop methods are called the data structure should behave like a stack.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @return the last item inserted with a push; or null when the list is empty.
     *
     * Worst-case asymptotic runtime cost: TODO
     *
     * Justification:
     *  TODO
     */
    public T pop() 
    {
    	if(this.isEmpty())
    	{
    		return null;
    	}
    	DLLNode topNode = tail;
    	tail = tail.prev;
    	tail.next = head;
    	size--;
    	return topNode.data;
    	
    }

    /*----------------------- QUEUE */
 
    /**
     * This method should behave like the usual enqueue method of a Queue ADT.
     * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to be enqueued to the stack
     *
     * Worst-case asymptotic runtime cost: TODO
     *
     * Justification:
     *  TODO
     */
    public void enqueue(T item) 
    {
      DLLNode newNode = new DLLNode(item, head, tail);
      head.prev = newNode;
      head = newNode;
      size++;
    }

     /**
     * This method should behave like the usual dequeue method of a Queue ADT.
     * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @return the earliest item inserted with a push; or null when the list is empty.
     *
     * Worst-case asymptotic runtime cost: TODO
     *
     * Justification:
     *  TODO
     */
    public T dequeue() 
    {
    	if(this.isEmpty())
    	{
    		return null;
    	}
    	DLLNode topNode = tail;
    	tail = tail.prev;
    	tail.next = head;
    	size--;
    	return topNode.data;
    }
 

    /**
     * @return a string with the elements of the list as a comma-separated
     * list, from beginning to end
     *
     * Worst-case asymptotic runtime cost:   Theta(n)
     *
     * Justification:
     *  We know from the Java documentation that StringBuilder's append() method runs in Theta(1) asymptotic time.
     *  We assume all other method calls here (e.g., the iterator methods above, and the toString method) will execute in Theta(1) time.
     *  Thus, every one iteration of the for-loop will have cost Theta(1).
     *  Suppose the doubly-linked list has 'n' elements.
     *  The for-loop will always iterate over all n elements of the list, and therefore the total cost of this method will be n*Theta(1) = Theta(n).
     */
    public String toString() 
    {
      StringBuilder s = new StringBuilder();
      boolean isFirst = true; 

      // iterate over the list, starting from the head
      for (DLLNode iter = head; iter != null; iter = iter.next)
      {
        if (!isFirst)
        {
          s.append(",");
        } else {
          isFirst = false;
        }
        s.append(iter.data.toString());
      }

      return s.toString();
    }


}

