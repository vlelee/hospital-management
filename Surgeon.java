package hospital;

public class Surgeon extends Doctor {
	private char operating;
	
	Surgeon(char s, String sname, int sid, String sSpecialty, char sOp) {
		super(s, sname, sid, sSpecialty);
		operating = sOp;
	}
	
	void setOperating(char sOp) {
		operating = sOp;
	}
	
	char getOperatingStatus() {
		return operating;
	}
	
	public String revert() {
		String output = getType() + " " + getName() + " " + getId() + " " + getSpecialty() + " " + operating;
		return output;
	}
	
	public String toString() {
		String output = "Name: " + getName() + " Employee Number: " + getId() + " Specialty: " + getSpecialty() + 
			" Operating: " + operating;
		return output;
	}
}
