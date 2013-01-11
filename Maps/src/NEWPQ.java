public class NEWPQ {

    private Path[] theHeap; //array that holds the PQ theHeap
    private int lastIndex;// index of last element in the PQ
    private  int MAX_SIZE=500;
    private int maxIndex; 



    public NEWPQ() {
    theHeap = new Path[MAX_SIZE];
    lastIndex = -1;
    maxIndex = MAX_SIZE - 1;
    }
   
    public boolean isEmpty()
    // Determines whether this priority queue is empty.
    {
      return (lastIndex == -1);
    }
    public boolean isFull()
    // Determines whether this priority queue is full.
    {
      return (lastIndex == maxIndex);
    }
    
    private void reheapUp(Path item)
    // Current lastIndex position is empty
    // Inserts item into the tree and ensures shape and order properties
    {
      int hole = lastIndex;
      while ((hole > 0)                                       // hole is not root
             &&                                               // short circuit
             (item.compareTo(theHeap[(hole - 1) / 2]) > 0))  // item > hole's parent
      {
        theHeap[hole] = theHeap[(hole - 1) / 2];            // move hole's parent down
        hole = (hole - 1) / 2;                                // move hole up
      }

      theHeap[hole] = item;                        // place item into final hole
    }
    
    private int newHole(int hole, Path item)
    // If either child of hole is larger than item this returns the index
    // of the larger child; otherwise it returns the index of hole
    {
      int left = (hole * 2) + 1;
      int right = (hole * 2) + 2;

      if (left > lastIndex)
        // hole has no children
        return hole;         
      else
      if (left == lastIndex)
        // hole has left child only
        if (item.compareTo(theHeap[left]) < 0)             
          // item < left child
          return left;
        else
          // item >= left child
          return hole;
      else
      // hole has two children 
      if (theHeap[left].compareTo(theHeap[right]) < 0)
        // left child < right child
        if (theHeap[right].compareTo(item) <= 0)
          // right child <= item
          return hole;
        else
          // item < right child
          return right;
      else
      // left child >= right child
      if (theHeap[left].compareTo(item) <= 0)
        // left child <= item
        return hole;
      else
        // item < left child
        return left;
    }

    private void reheapDown(Path item)
    // Current root position is "empty";
    // Inserts item into the tree and ensures shape and order properties
    {
      int hole = 0;      // current index of hole
      int newhole;       // index where hole should move to

      newhole = newHole(hole, item);   // find next hole
      while (newhole != hole)
      {
        theHeap[hole] = theHeap[newhole];  // move element up
        hole = newhole;                      // move hole down
        newhole = newHole(hole, item);       // find next hole
      }
      theHeap[hole] = item;           // fill in the final hole
    }
    
    

    // add a new element at the end and "bubble" it up
    public void enqueue(Path item)
    // Adds item to this priority queue.
    {
        lastIndex = lastIndex + 1;
        reheapUp(item);
      }
    

    // removes the top element and then refactors remaining theHeap
    public Path dequeue() 
    // Removes element with highest priotity from this priority queue 
    // and returns a reference to it.
    // Throws PriQUnderflowException if priority queue is empty.
    {
      Path hold;      // item to be dequeued and returned
      Path toMove;    // item to move down heap

    
      {
        hold = theHeap[0];            // remember item to be returned
        toMove = theHeap[lastIndex];  // item to reheap down
        lastIndex = lastIndex - 1;     // decrease priority queue size
        reheapDown(toMove);            // rstore heap properties
        return hold;                   // return largest element
      }
    }
    
    public int getCount(){
    return lastIndex;}
    
 
    
    
    
    
    public String toString()
    {
    	String theS="";
    	for(int y=0; y<lastIndex; y++)
    	{
    		theS+=theHeap[y].toString()+"\n";
    		
    	}
    	
    	return theS;
    }
    
    
    
}