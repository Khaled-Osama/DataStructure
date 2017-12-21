package AVLTree;


/*
 * AVL (Adelson-Velskii and Landis) Tree that is the the same of normal Tree but have 1 more feature
 * AVL tree takes care about height of tree and when inserting a new node keeps it balanced
 * the tree is balanced when the difference between the longest height in right branch and the longest height in left branch
 * not greater than 2
 * 
 * 
 * */
public class AVLTree {
	
	Node Root; //Root of the tree
	public AVLTree() {
		Root=null;
	}
	/*
	 * This function adds node to the tree there are 2 cases 
	 * 1 - the tree is empty make it the root of the tree
	 * 2-  the tree isn't empty add it in it's correct position and balance the tree  
	 * 
	 * */
	public void insert(int val) {
		// the tree is empty 
		if(Root==null)Root=new Node(val);
		// call a helper function to insert the node in the correct position and balance the tree
		else
			insertNode(val,Root);	
		
	}
	
	public Node insertNode(int val,Node ...node) {
		Node curr=node[0];
		if(curr==null)return new Node(val);
		if(val==curr.val) {
			curr.freq++;
			return curr;
		}
		if(val<curr.val) 
			curr.leftChild=insertNode(val,curr.leftChild);
		else
			curr.rightChild=insertNode(val,curr.rightChild);
		if(curr.leftChild==null&&curr.rightChild!=null) {curr.height=curr.rightChild.height;curr.bf=curr.rightChild.height;}
		else if(curr.leftChild!=null&&curr.rightChild==null) {curr.height=curr.leftChild.height;curr.bf=curr.leftChild.height;}
		else if(curr.leftChild==null&&curr.rightChild==null)curr.bf=0;
		else
		{curr.height=Math.max(curr.leftChild.height,curr.rightChild.height)+1; // the height from the node and the farthest leaf node equal the maximum height between it's branches +1
		curr.bf=curr.leftChild.height-curr.rightChild.height; // calculate the balance factor for the the node by subtracting the height of right child from the height of left child
		}
		balance(curr); // balance the tree
		return curr;
	}
	/*
	 * This function checks that the tree need to be balanced or not (balance factor equal 2 or -2)
	 * when bf equal 2 so , the longest path from left child to the farthest leaf node is larger than that  in right child
	 * when bf equal -2 so, the longest path from right child to the farthest leaf node is larger than that  in left child
	 * if bf equal 2 so we need to rotate the tree right
	 * if bf equal -2 so we need to rotate the tree left
	 * 
	 * */
	
	public void balance(Node curr) {
		if(curr.bf==2) {
			/*
			 * 		    O
			 * 		   /
			 * 		  O
			 * 		   \
			 * 		    O
			 * in this case the left branch is larger than the right branch by 2
			 * but we need to rotate the left branch left first to make the tree as the following
			 * 
			 * 	    O
			 *         /
			 *        O
			 *       /
			 *      O
			 * 	then rotate the tree right to become
			 * 
			 * 		     O
			 *		   /   \
			 *		  O     O
			 * */
			if(curr.leftChild.bf==-1)curr.leftChild=leftRotation(curr.leftChild);
			curr=rightRotation(curr);
		}
		// apply the same as the previous but toggle the type of the rotation
		else if(curr.bf==-2) {
			if(curr.rightChild.bf==1)curr.rightChild=rightRotation(curr.rightChild);
			curr=leftRotation(curr);
		}
		
	}
	/*
	 * this function rotate the specific node right that make it's left child to be the parent with it's left child
	 *  and make the node itself the right child with the left child of the current parent in the left branch on it
	 *  and have the same right child without changing
	 * */
	public Node rightRotation(Node curr) {
		Node ret=curr.leftChild;
		curr.leftChild=ret.rightChild;
		ret.rightChild=curr;
		curr.height=Math.max(curr.leftChild.height, curr.rightChild.height)+1;
		ret.height=Math.max(ret.leftChild.height, ret.rightChild.height)+1;
		return ret;
	}
	/*
	 * This function rotate the specific node left that make it's right child to be the parent with it's right child
	 * and make the node itself the left child with the right child of the current parent in the right branch on it
	 * and have the same left child without changing
	 * 
	 * */
	
	public Node leftRotation(Node curr) {
		Node ret=curr.rightChild;
		curr.rightChild=ret.leftChild;
		ret.leftChild=curr;
		curr.height=Math.max(curr.leftChild.height, curr.rightChild.height)+1;
		ret.height=Math.max(ret.leftChild.height, ret.rightChild.height)+1;
		return ret;
	}
	/*
	 * This function check whether the node exists in the tree or not
	 * */
	
	public boolean exist(int elem) {
		if(Root==null)return false;
		
		Node tmp=Root; // start from root
		
		/* here move left or right depend on the node's value due to the current node until reaching to the node  
		 * when the checking is over and we can't found the node so,the node doesn't exist in the tree
		 */
		while(tmp!=null&&tmp.val!=elem) {
			if(tmp.val<elem)tmp=tmp.rightChild;
			else tmp=tmp.leftChild;
			
			
		}
		return(tmp!=null);
		
	}

}
