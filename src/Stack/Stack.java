package Stack;
/*
 * stack is a data structure that implement a last input first output rule 
 * if we put book on another and we have about 5 books
 * when we need the bottom book that was put first we need to remove four books that were put after
 * it so we called it as first in last output
 * 
 * */
public class Stack {
	int size=1000; //initialize an array with initial size 1000
	Object[]array=new Object[size]; //this array we can store in it our data
	int elem=0; //number of elements in our stack
	
	/*put the element in top*/
	public void push(Object val) {
		// if our array is full w need to expand it
		if(elem==size) {
			expandArray();
		}
		array[elem]=val;
		elem++;
		
	}
	/*remove the top element from the stack*/
	public void pop() {
		//check whether the stack is empty or not
		assert(elem>0);
		elem--;
		
	}
	/*return the top element*/
	public Object top() {
		return array[elem-1];
	}
	/*return the length of our stack*/
	public int length() {
		return elem;
	}
	/*expand our array */
	private void expandArray() {
		size*=2;
		Object[] newArr=new Object[size];
		//copy data to our new array
		for(int i=0;i<size/2;i++) {
			newArr[i]=array[i];
		}
		array=newArr;
		newArr=null;
	}

	
}
