package hospital;

public class Administrator extends Employee {
	private String department;
	
	public Administrator(char a, String aName, int aId, String aDept) {
		super(a, aName, aId);
		department = aDept;
	}
	
	public void setDepartment(String dept) {
		department = dept;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public String revert() {
		String output = getType() + " " + getName() + " " + getId() + " " + department;
		return output;
	}
	
	public String toString() {
		String output = "Name: " + getName() + " Employee Number: " + getId() + " Department: " + department;
		return output;
	}
}
