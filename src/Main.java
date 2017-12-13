import LinkedList.LinkedList;
import Stack.Stack;
import QueueImplementation.Queue;
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
		System.out.println(queue.top());
		System.out.println(queue.empty());
		
	}

}
