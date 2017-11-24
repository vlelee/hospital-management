package hospital;

public class Employee {
	private char eType;
	private String name;
	private int id;
	
	public Employee() {
		eType = '';
		name = "";
		id = 0;
	}
	
	public Employee(char e, String ename, int eid) {
		eType = e;
		name = ename;
		id = eid;
	}
	
	public void setType(char e) {
		eType = e;
	}
	
	public void setName(String sname) {
		name = sname;
	}
	
	public void setId(int sid) {
		id = sid;
	}
	
	public char getType() {
		return eType;
	}
	
	public String getName() {
		return name; 
	}
	
	public int getId() {
		return id;
	}
	
	public String revert() {
		String output = eType + " " + name + " " + id;
		return output;
	}
	
	public String toString() {
		String output = "Name: " + name + " Employee Number: " + id;
		return output;
	}
}
