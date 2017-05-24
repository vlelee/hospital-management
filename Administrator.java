package hospital;

public class Administrator extends Employee {
	String department;
	
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
		String output = eType + " " + name + " " + id + " " + department;
		return output;
	}
	
	public String toString() {
		String output = "Name: " + name + " Employee Number: " + id + " Department: " + department;
		return output;
	}
}
