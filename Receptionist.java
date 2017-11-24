package hospital;

public class Receptionist extends Administrator {
	private char answering;

	public Receptionist(char r, String rname, int rId, String rDept, char rAns) {
		super(r, rname, rId, rDept);
		answering = rAns;
	}
	
	public void setAnswering(char ans) {
		answering = ans;
	}
	
	public char getAnswering() {
		return answering;
	}
	
	public String revert() {
		String output = getType() + " " + getName() + " " + getId() + " " + getDepartment() + " " + answering;
		return output;
	}

	public String toString() {
		String output = "Name: " + getName() + " Employee Number: " + getId() + " Department: " + getDepartment() + 
			" Answering: " + answering;
		return output;
	}
}
