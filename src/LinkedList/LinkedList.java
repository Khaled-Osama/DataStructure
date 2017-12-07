package LinkedList;

public class LinkedList {
	Node Head,Tail=null;
	int size=0;
	
	/*Add Node at last position*/
	public void Append(Object val) {
		Node newNode=new Node(val); 
		// make it the head and tail in case the linked list is empty
		if(size==0) {
			Head=Tail=newNode;
			size++;
			return;
		}
		Tail.next=newNode;
		Tail=newNode;
		newNode=null; // to let jvm to remove it at the run time
		size++;
	}
	/*Get LinkedList size*/
	public int Length() {
		return size;
	}
	/*Get element at a specific position*/
	public Object At(int indx) {
		assert indx>=0&&indx<size:" Not valid"; // index out the range
		Node tmp=Head;
		for(int i=0;i<indx;i++) {
			tmp=tmp.next;
		}
		
		return tmp.data;
	}
	/*add element at a specific position*/
	public void InsertAt(Object val,int indx) {
		assert(indx>=0&&indx<=size); //index out the range
		
		Node tmp=Head;
		Node newNode= new Node(val);
		// add it at first position in case the linkedList is empty
		if(indx==0) {
			newNode.next=Head;
			Head=newNode;
		}
		// call append function if we need to add element at last position
		else if(indx==size) {
			Append(val);
		}
		
		else {
		for(int i=0;i<indx-1;i++) {
			tmp=tmp.next;
			}
		newNode.next=tmp.next;
		tmp.next=newNode;
		}
		size++;
	}
	/*Delete an element at a specific position */
	public void DeleteAt(int indx) {
		assert(indx>=0&&indx<size);
		size--;
		Node tmp=Head;
		// if we need to remove the head make the head the next element
		if(indx==0) {
			Head=tmp.next;
			// if LinkedList has one node only  make the tail also null
			if(size==1) Tail=null;
			tmp=null;
			return;
		}
		for(int i=0;i<indx-1;i++) {
			tmp=tmp.next;
		}
		Node delete=tmp.next;
		tmp.next=delete.next;
		// if we need to delete the tail make the previous element the tail
		if(delete.next==null)Tail=tmp;
		delete=tmp=null;
	}
	/*delete all elements from the LinkedList*/
	public void clear() {
		Node tmp=Head;
		while(tmp!=null) {
			DeleteAt(0);
			tmp=tmp.next;
		}
		size=0;
	}
	

}
