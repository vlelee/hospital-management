package hospital;

public class Janitor extends Administrator {
	private char sweeping;
	
	public Janitor(char j, String jname, int jId, String dept, char jsweep) {
		super(j, jname, jId, dept);
		sweeping = jsweep;
	}
	
	public void setSweeping(char sweep) {
		sweeping = sweep;
	}
	
	public char getSweeping() {
		return sweeping;
	}
	
	public String revert() {
		String output = getType() + " " + getName() + " " + getId() + " " + getDepartment() + " " + sweeping;
		return output;
	}
	
	public String toString() {
		String output = "Name: " + getName() + " Employee Number: " + getId() + " Department: " + getDepartment() + 
			" Sweeping: " + sweeping;
		return output;
	}
}
