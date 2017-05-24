package hospital;

public class Janitor extends Administrator {
	char sweeping;
	
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
		String output = eType + " " + name + " " + id + " " + department + " " + sweeping;
		return output;
	}
	
	public String toString() {
		String output = "Name: " + name + " Employee Number: " + id + " Department: " + department + " Sweeping: " + sweeping;
		return output;
	}
}
