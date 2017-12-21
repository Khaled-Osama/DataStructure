import LinkedList.LinkedList;
import Stack.Stack;
import QueueImplementation.Queue;
import BinaryTree.BinaryTree;
import AVLTree.AVLTree;
public class Main {

	public static void main(String[] args) {
		
		/*Test LinkedList*/
		LinkedList l=new LinkedList();
		l.Append(5);
		
		l.Append(4);
		l.Append(8);
		/*test length func*/
		System.out.println(l.Length());
		/*test At func*/
		System.out.println(l.At(1));
		/*test deleteAt func*/
		l.DeleteAt(1);
		System.out.println(l.At(1));
		/*test clear func*/
		l.clear();
		
		
		/*Test Stack*/
		Stack stk=new Stack();
		stk.push(5);
		stk.push(6);
		
		System.out.println(stk.top());
		stk.pop();
		System.out.println(stk.top());
		
		
		
		/*Test Queue*/
		System.out.println("Queue Tests");
		Queue queue=new Queue(5);
		queue.push(3);
		queue.push(6);
		queue.push(7);
		System.out.println(queue.empty());
		System.out.println(queue.top());
		queue.pop();
		System.out.println(queue.top());
		queue.pop();
		System.out.println(queue.top());
		queue.pop();

		System.out.println(queue.empty());
		
		/*Test Binary Tree*/
		System.out.println("Testing Binary Tree \n\n");
		BinaryTree tree=new BinaryTree();
		tree.addNode(5);
		tree.addNode(8);
		tree.addNode(6);
		tree.addNode(9);
		tree.addNode(7);
		tree.addNode(10);
		
		System.out.println("Val 11 exist or not ?"+tree.exist(11));
		System.out.println("Val 9 exist or not ?"+tree.exist(9));
		System.out.println("Val 8 exist or not ?"+tree.exist(8));
		System.out.println("Print tree sorted in ascending Order");
		tree.inOrder();
		System.out.println("\nPrint tree sorted in ascending Order");
		tree.postOrder();
		/*AVL Tree*/
		System.out.println("\n\nTesting AVL Tree \n\n");
		AVLTree avl=new AVLTree();
		avl.insert(15);
		avl.insert(10);
		avl.insert(8);
		avl.insert(19);
		System.out.println("Val 15 exist or not ?"+avl.exist(15));
		System.out.println("Val 8 exist or not ?"+avl.exist(8));
		System.out.println("Val 19 exist or not ?"+avl.exist(19));
		System.out.println("Val 20 exist or not ?"+avl.exist(20));
	}

}
