package hospital;

public class Nurse extends Employee {
	private int numpatients;
	
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
		String output = getType() + " " + getName() + " " + getId() + " " + numpatients;
		return output;
	}

	public String toString() {
		String output = "Name: " + getName() + " Employee Number: " + getId() + " Number of Patients: " + numpatients;
		return output;
	}
}
