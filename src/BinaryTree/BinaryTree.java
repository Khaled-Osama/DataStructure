package BinaryTree;

/*
 * that's Binary tree data structure have the following properties
 * 1- every element in the tree act as a node
 * 2- values of Node can't be repeated so the Node must be in the tree at most once
 * 3- every node have at most 2 children (right child - left child).
 * 4- left child has a value less the value of the node and right child has value greater than the value of the node.
 * 5- every tree has a Root Node and it's considered as a start node of our tree from it we can reach to any other Node
 * 
 * we can use it to find a specific element in the tree , we can use array to do this task but the tree give us better complexity 
 * to do it.
 * we can do it by checking the node that we search for greater than root so move to right child and do the previous operation with the right child
 * if it larger than the root we move to the left child and also do the previous operation with left child node
 * So , if we need a specific node from our tree we can move in the worst case the height of the tree only because in each move 
 * we remove a branch and enter the other branch
 * 
 * */
public class BinaryTree {
	Node Root;
	public BinaryTree() {
		Root=null;  // our root now is null because the tree is empty
	}
	/*
	 * This function will add a node in the right position to make it sorted ِ according to our rule (largest to right and smaller to left) 
	 * 
	 * */
	public void addNode(int value) {
		Node newNode=new Node(value); // make a new Node have this value
		// if the tree is empty make the new node as Root
		if(Root==null) {
			Root=new Node();
			Root.val=value;
		}
		else {
			Node tmp=Root;
			
			while(true) {
				// if the new node is larger than the current Node
				if(value>tmp.val) {
					// if this position is empty so , put our new node in this place and break
					if(tmp.rightChild==null) {
						tmp.rightChild=newNode;
						break;
					}
					else tmp=tmp.rightChild;
				
				}
				// if the new node is smaller than the current node
				else if(value<tmp.val) {
					// if the position is empty so, put our new node in this place and break
				if(tmp.leftChild==null) {
				tmp.leftChild=newNode;
				break;
				}
					
				else tmp=tmp.leftChild;	
				}
				else break;
				
			}
			
			
			
		}
		
		
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
	
	// this function return us the node that contains a specific value
	public Node findNode(int elem) {
		
		Node tmp=Root;
		while(tmp.val!=elem&&tmp!=null) {
			if(elem>tmp.val) 
				tmp=tmp.rightChild;
			else
				tmp=tmp.leftChild;

		}
		return tmp;
		
	}
	/*
	 * This function delete a specific node in the tree we have four different cases
	 * 1- if the node we need to delete is a leaf node (doesn't have children) so we can make it's parent not to point to it
	 * 2- if the node have right child only we can make the parent's right child the right child of the deleted node
	 * 3-if the node have left child only make the parent's left child the left child of the deleted node
	 * 4- if the node have right and left children we can get the minimum greater value than the node and put it instead the deleted node
	 * we can get this node from right branch and take the minimum from it (far left node) then delete it from the tree;
	 *  
	 * */
	public void delete(int val) {
		
		Node del =findNode(val);
		// delete a leaf Node
		if(del.rightChild==null&&del.leftChild==null) {
			if(del==Root) {
				Root=null;
				return;
			}
			Node parent=findParent(val);
			if(parent.rightChild==del)parent.rightChild=null;
			else parent.leftChild=null;
		}
		// delete a node that have left children only
		else if(del.rightChild==null) {
			if(del==Root) {
				Root=Root.leftChild;
				del=null;
				return;
			}
			Node parent=findParent(val);
			parent.leftChild=del.leftChild;
			del=null;
		}
		// delete a node that have right children only
				else if(del.rightChild==null) {
					if(del==Root) {
						Root=Root.rightChild;
						del=null;
						return;
					}
					Node parent=findParent(val);
					parent.rightChild=del.rightChild;
					del=null;
				}
		// delete a node that have right and left children
				else {
					Node minn=getMin(del.rightChild);
					del.val=minn.val;
					Node minParent=findParent(minn.val);
					if(minParent==del)
						minParent.rightChild=del.rightChild;
					else
						minParent.leftChild=del.rightChild;
					minn=minParent=null;
				}

	}
	/*
	 * This function get the parent node for a specific element
	 * */
	public Node findParent(int val) {
		Node tmp=Root;
		while(true) {
			if(val>tmp.val) {
				if(tmp.rightChild.val==val)return tmp;
				tmp=tmp.rightChild;
			}
			else {
				if(tmp.leftChild.val==val)return tmp;
				tmp=tmp.leftChild;
			}
		}
		
		
		
	}

	/*
	 * This is a helper function give us the minimum node from a specific node by getting the far left node
	 * we use it when we need to delete a node that has right and left children to get the minimum node and put it instead the deleted node
	 * */
	public Node getMin(Node tmp) {
		while(tmp.leftChild!=null)
			tmp=tmp.leftChild;
		return tmp;
		
	}
	/*
	 * This is a type to display the tree this type print the tree from left to right so the tree display sorted in ascending order
	 * 
	 * */
	public void inOrder(Node ...node) {
		Node tmp=Root;
		if(node.length!=0)tmp=node[0];
		if(tmp==null) return;
		inOrder(tmp.leftChild);
		System.out.print(tmp.val+" ");
		inOrder(tmp.rightChild);
	}
	/*
	 * that's another type of displaying nodes in the tree that display root first then left child then right child
	 * when we displaying the root we can go to the left child and treat it as a root and print it first then go to the left child and so on ..
	 * */
	public void preOrder(Node ...node) {
		Node tmp=Root;
		if(node.length!=0)tmp=node[0];
		if(tmp==null)return;
		System.out.print(tmp.val+" ");
		preOrder(tmp.leftChild);
		preOrder(tmp.rightChild);
		
	}
	/*
	 * This is another type of of displaying the tree that's print the array sorted to descending order 
	 * it can display the right child first (large) then the root then the left child (small)
	 * */
	public void postOrder(Node ...node) {
		Node tmp=Root;
		if(node.length!=0)tmp=node[0];
		if(tmp==null)return;
		postOrder(tmp.rightChild);
		System.out.print(tmp.val+" ");
		postOrder(tmp.leftChild);
		
	}
	
}
