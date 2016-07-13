import java.util.ArrayList;
import java.util.List;

public class Node {

	private Heading heading;
	private Node parent;
	private List<Node> children;
	
	public Node(){
		this.heading = new Heading(0, "");
		this.children = new ArrayList<Node>();
	}
	
	public Node(Heading heading){
		this.heading = heading;
		this.children = new ArrayList<Node>();
	}
	
	public Node(Heading heading, List<Node> children){
		this.heading = heading;
		this.children = children;
	}
	
	public Heading getHeading() {
		return heading;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setHeading(Heading heading) {
		this.heading = heading;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}
	
	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public void addChild(Node child){
		this.children.add(child);
	}
}
