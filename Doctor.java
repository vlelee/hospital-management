package hospital;

public class Doctor extends Employee {
	String specialty;
	
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
		String output = eType + " " + name + " " + id + " " + specialty;
		return output;
	}
	
	public String toString() {
		String output = "Name: " + name + " Employee Number: " + id + " Specialty: " + specialty;
		return output;
	}

}
