package hospital;

public class Doctor extends Employee {
	private String specialty;
	
	public Doctor(char d, String dname, int dId, String dspecialty) {
		super(d, dname, dId);
		specialty = dspecialty;
	}
	
	public void setSpecialty(String special) {
		specialty = special;
	}
	
	public String getSpecialty() {
		return specialty;
	}
	
	public String revert() {
		String output = getType() + " " + getName() + " " + getId() + " " + specialty;
		return output;
	}
	
	public String toString() {
		String output = "Name: " + getName() + " Employee Number: " + getId() + " Specialty: " + specialty;
		return output;
	}

}
