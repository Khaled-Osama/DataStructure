package AVLTree;
/*
 * The node have the following variables
 * val stores integer that represent the value of the node
 * freq stores the number of frequency of the node (then we can add the same node several time without growing the tree)
 * height represent the maximum path height from the node to any leaf node
 * bf represent the balance factor of the node the balance factor is the difference between the height of 2 children
 * rightChild represent the right child of the node 
 * leftChild represent the left child of the node
 * */
  class Node {
	
	// when no node it's freq,height, bf=0
	int val,freq=0,height=0,bf=0;
	Node leftChild,rightChild;
	Node(){
		leftChild=rightChild=null;
	}
	Node(int val){
		// we assigned a new node so the height and freq =1
		this.val=val;
		leftChild=rightChild=null;
		height=freq=1;
	}

}
