package hospital;

public class Receptionist extends Administrator {
	char answering;

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
		String output = eType + " " + name + " " + id + " " + department + " " + answering;
		return output;
	}

	public String toString() {
		String output = "Name: " + name + " Employee Number: " + id + " Department: " + department + " Answering: " + answering;
		return output;
	}
}
