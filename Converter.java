import java.util.LinkedList;
import java.util.Queue;

public class Converter {
	
	/*
	 * I decided to use Queue instead of just a List, but all of the code could have just as easily
	 * been implemented using a List and indexing at 0 instead of peek() (->get(0)) and poll() (->get(0) and remove(0))
	 */

	public static void main(String[] args){
		Queue<Heading> example = new LinkedList<Heading>();
		example.offer(new Heading(1, "All About Birds"));
		example.offer(new Heading(2, "Kinds of Birds"));
		example.offer(new Heading(3, "The Finch"));
		example.offer(new Heading(3, "The Swan"));
		example.offer(new Heading(4, "Black Swan"));
		example.offer(new Heading(2, "Habitats"));
		example.offer(new Heading(3, "Wetlands"));
		
		Node test = outline(example);
		
		dfsPrint(test);
	}
	
	/*
	 * Helper method to get the recursive process started.
	 */
	public static Node outline(Queue<Heading> headingList){
		Node root = new Node();
		
		return outlineHelper(headingList, root);
	}
	
	/*
	 * Recursive method that creates the Node tree structure.
	 */
	public static Node outlineHelper(Queue<Heading> headingList, Node prevNode){		
		while(!headingList.isEmpty()){
			//check the current node in the list
			Node currNode = new Node(headingList.peek()); //peek but don't remove from list
			
			//if the previous node is greater than or equal the current node then
			//the previous node is a leaf node of it's subtree and we return it to
			//end the recursive process it's subtree
			//(i.e. it does not have any further children if the condition is true)
			if(prevNode.getHeading().getWeight() >= currNode.getHeading().getWeight())
				return prevNode;
			
			//if the above condition is not true, then it means that the current node was in fact
			//a child of the previous node, so we add it the the current subtree, remove it
			//from the list of headings and keep recursing
			Node child = new Node(headingList.poll()); //now we actually remove it from the list
			prevNode.addChild(outlineHelper(headingList, child));
		}
		
		return prevNode;
	}
	
	/*
	 * Simple depth first search tree traversal algorithm to print the Node tree contents
	 */
	public static void dfsPrint(Node node){
		if(node.getChildren().isEmpty()){
			return;
		}
		
		for(Node n: node.getChildren()){
			System.out.println(n.getHeading().getWeight() + ", " + n.getHeading().getText());
			dfsPrint(n);
		}
	}
}
