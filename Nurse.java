package hospital;

public class Nurse extends Employee {
	int numpatients;
	
	public Nurse(char n, String nName, int nId, int nPatients) {
		super(n, nName, nId);
		numpatients = nPatients;
	}
	
	public void setNumpatients(int nPatients) {
		numpatients = nPatients;
	}
	
	public int getNumpatients() {
		return numpatients;
	}
	
	public String revert() {
		String output = eType + " " + name + " " + id + " " + numpatients;
		return output;
	}

	public String toString() {
		String output = "Name: " + name + " Employee Number: " + id + " Number of Patients: " + numpatients;
		return output;
	}
}
