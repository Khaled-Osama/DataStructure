package QueueImplementation;

/*
 * Queue Data Structure is a data structure that organize the elements as first in first output
 * for example if we are in a restaurant and we are five persons for example the  first who will take his order the first he came 
 * next the second he came and so on.
 * the queue data structure will take these persons and will organize who are going to leave first .
 * 
 * */


public class Queue {
	int front,back; //front is the first element and back is the last element
	int elements=0,sizeOfArray;
	Object []arr;  // to store our elements in it
	
	// taking the size of queue from user to initialize the size of our array
	public Queue(int sizeOfQueue) {
		sizeOfArray=sizeOfQueue;
		arr=new Object[sizeOfArray];
		front=back=-1;
	}
	// check whether the array or queue is full or not
	
	public boolean full() {
		return (sizeOfArray==elements);
	}
	// check whether the array or queue is empty (have no elements) or not
	public boolean empty() {
		return (elements==0);
		
	}
	/*
	 * we have to take a new element of the user and push it in the queue and make it the back of the queue 
	 * in case of the queue is empty so this new element will be the front and back 
	 * in case the the back of the queue in the last position of our array we can recycle the index and store in the first position in the array
	 * so we can take the new position Mod sizeOf array
	 * */
	public void push(Object newElement) {
		assert(!full()):"The queue is full you should increase the size of queue";
		if(elements==0)
			front=0;
		back=(back+1)%sizeOfArray;
		arr[back]=newElement;
		elements++;
	}
	/*
	 * in this function we will remove the front element in the queue and make the front who is next
	 * in case there is one element we can make front and back with -1 that indicates that no front and no back in queue (queue is empty)
	 * in case the front is the last element in array so , we need to make the front is the element in position zero so we can take the new Index with Mod sizeOfArray
	 * 
	 * */
	public void pop() {
		assert(!empty());
		if(elements==1)front=back=-1;
		else
			front=(front+1)%sizeOfArray;
		elements--;
	}
	/*
	 * This function return the front of the queue
	 * */
	public Object top() {
		assert(!empty()):"the queue is empty and has no elements to get";
		return arr[front];
		
	}
	

}
