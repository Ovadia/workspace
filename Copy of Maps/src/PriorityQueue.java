/** Priority Queue implementation based on Min-Heap */
public class PriorityQueue {
 
    private final int MAX_SIZE;
    private static final int DEFAULT_SIZE = 16;
    private static final int ROOT = 1;
    private static final int NULL = -1;
    private Path[ ] theHeap;
    private int lastIndex = ROOT;
 
    /** Constructs a priority queue with the specified size */
    public PriorityQueue() {
        MAX_SIZE = 16;
        theHeap = new Path[ MAX_SIZE ];
        int Count=0;
    }
 
    /** Constructs a priority queue with the default size */
  
 
    /** Adds a new element to the theHeap while maintaining the min-heap property */
    public void add( Path element ) {
        if( element.getCost() < 0 || lastIndex == MAX_SIZE ) {
            return;
        }
 
        int elementIndex = lastIndex++;
        theHeap[ elementIndex ] = element;
 
        while( theHeap[ elementIndex ].getCost() < theHeap[ parent( elementIndex ) ].getCost()) {
            swap( elementIndex, parent( elementIndex ) );
            elementIndex = parent( elementIndex );
        }
    }
 
    /** Returns the parent index */
    private int parent( int index ) {
        return index / 2;
    }
 
    /** Returns the left child index */
    private int leftChild( int index ) {
        return 2 * index;
    }
 
    /** Returns the right child index */
    private int rightChild( int index ) {
        return 2 * index + 1;
    }
 
    /** Returns the smallest child index */
    private int minChild( int index ) {
 
        int leftChildIndex = leftChild( index );
        int rightChildIndex = rightChild( index );
 
        if( leftChildIndex >= MAX_SIZE && rightChildIndex >= MAX_SIZE ) return NULL;
        else if( rightChildIndex >= MAX_SIZE ) return leftChildIndex;
 
        if(theHeap[leftChildIndex].getCost()== NULL && theHeap[ rightChildIndex ].getCost()== NULL ) return NULL;
        else if( theHeap[ rightChildIndex ].getCost() == NULL ) return leftChildIndex;
 
        return theHeap[ leftChildIndex ].getCost() <= theHeap[ rightChildIndex ].getCost() ? leftChildIndex : rightChildIndex;	
    }
 
    /** Returns the minimum element from the heap */
    public Path min() {
        return theHeap[ ROOT ];
    }
 
    /** Returns and removes the minimum element from the heap */
    public Path removeMin() {
 
        Path rootElement = theHeap[ ROOT ];
        int elementIndex = --lastIndex;
        Path element = theHeap[ elementIndex ];
 
        theHeap[ ROOT ] = element;
        theHeap[ elementIndex ] = null;
        elementIndex = ROOT;
 
        for( int minChildIndex; ( ( minChildIndex = minChild( elementIndex ) ) != NULL ) 
            && ( theHeap[ elementIndex ].getCost() > theHeap[ minChildIndex ].getCost() ); ) {
 
            swap( elementIndex, minChildIndex );
            elementIndex = minChildIndex;			
        }
 
        return rootElement;
    }
 
    /** Checks if the heap is empty */
    public boolean isEmpty( ) {
        return lastIndex == ROOT;
    }
 
    /** Helper method for swapping elements in the theHeap */
    private void swap( int a, int b ) {
        Path temp = theHeap[ a ];
        theHeap[ a ] = theHeap[ b ];
        theHeap[ b ] = temp;
    }
 
    @Override
    public String toString( ) {
        StringBuffer sb = new StringBuffer( "[" );
        for( int i = 1; i < lastIndex; i++ ) {
            sb.append( theHeap[ i ] );
            if( i + 1 < lastIndex ) sb.append( ", " );
        }
        sb.append( "]" );
        return sb.toString( );
    }
}