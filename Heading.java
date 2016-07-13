
public class Heading {
	
	private int weight;
	private String text;
	
	public Heading(){
		this(0, "");
	}
	
	public Heading(int weight, String text){
		this.weight = weight;
		this.text = text;
	}

	public int getWeight() {
		return weight;
	}

	public String getText() {
		return text;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setText(String text) {
		this.text = text;
	}
}
