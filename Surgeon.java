package hospital;

public class Surgeon extends Doctor {
	char operating;
	
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
		String output = eType + " " + name + " " + id + " " + specialty + " " + operating;
		return output;
	}
	
	public String toString() {
		String output = "Name: " + name + " Employee Number: " + id + " Specialty: " + specialty + " Operating: " + operating;
		return output;
	}
}
