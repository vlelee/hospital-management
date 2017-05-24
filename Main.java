package hospital;
import java.io.*;
import java.util.*;

public class Main {
	
	//getEmployeeDetails function splits a string with a whitespace delimiter
	public static Employee getEmployeeDetails(String line, Employee person) {
		String[] employer = line.split("\\s+");
		char empType = employer[0].charAt(0);
		
		return findEmployeeType(empType, employer, person);
	}
	
	//findEmployeeType function creates a new class object depending on the employer's eType
	public static Employee findEmployeeType(char eType, String[] employer, Employee person) {
	
		switch(eType) {
		case 'h': person = new Employee(eType, employer[1], Integer.parseInt(employer[2]));
				break;
		case 'd': person = new Doctor(eType, employer[1], Integer.parseInt(employer[2]), employer[3]);
				break;		
		case 's': person = new Surgeon(eType, employer[1], Integer.parseInt(employer[2]), employer[3], employer[4].charAt(0));
				break;	
		case 'n': person = new Nurse(eType, employer[1], Integer.parseInt(employer[2]), Integer.parseInt(employer[3]));
				break;	
		case 'a': person = new Administrator(eType, employer[1], Integer.parseInt(employer[2]), employer[3]);
				break;
		case 'r': person = new Receptionist(eType, employer[1], Integer.parseInt(employer[2]), employer[3], employer[4].charAt(0));
				break;
		case 'j': person = new Janitor(eType, employer[1], Integer.parseInt(employer[2]), employer[3], employer[4].charAt(0));
				break;	
		default: System.out.println("Invalid Employee Type");
				break;
		}
		
		return person;
	}
	
	//display function sorts, counts and prints the details of all employees in the Hospital
	public static void display(Employee[] persons) {
		String[] typelist = {"\nHospital Employees: ", "\nDoctors: ", "\nSurgeons: ", "\nNurses: ", "\nAdministrators: ",  "\nReceptionists: ", "\nJanitors: "};
		char[] typechar = {'h', 'd', 's', 'n', 'a', 'r', 'j'};
		int total = checkCount(persons);
		
		Employee[] employeelist = new Employee[persons.length];
		int j = 0;
		int prev = 0;
		
		
		System.out.println("The Hospital has the following employees: ");
		
		for (int k = 0; k < typelist.length; k++) {
			for (int i = 0; i < total; i++) {
				if (persons[i].getType() == typechar[k]) {
					employeelist[j] = persons[i];
					j++;
				}
			}

			displayEmployees(employeelist, typelist[k], prev, j);
			prev = j;
		}
		
		System.out.println("\nTotal number of Employees: " + prev);
	}

	//displayEmployees function prints the employees of a specific type
	public static void displayEmployees(Employee[] epersons, String selectType, int start, int end) {
		int total = end - start;
		System.out.println(selectType + total);
		
		for (int i = start; i < end; i++) {
			System.out.println(epersons[i].toString());
		}
	}
	
	public static Employee add(Employee[] persons) {
		String newEmployee;
		Employee newEmp = null;
		Scanner reader = new Scanner(System.in);
		int total = checkCount(persons);
		
		System.out.println("Please add the employee (format: role name id..), otherwise enter '1' to go back to main menu:");
		newEmployee = reader.nextLine();
		
		if(newEmployee.length() > 3) {
			System.out.println(newEmployee);
			persons[total] = getEmployeeDetails(newEmployee, persons[total]);
			newEmp = persons[total];
			total++;
			
			System.out.println(newEmp.getName() + " is added to the Hospital Employee list.");
			display(persons);
		}
		else {
			getCommand(persons);
		}

		return newEmp;
	}
	

	
	public static Employee[] delete(Employee[] persons) {
		char etype = 0;
		String ename;
		String confirm;
		Scanner reader = new Scanner(System.in);
		
		boolean checkflag = false;
		while (!checkflag) {
			System.out.println("Employee role: h (hospital employee), d (doctor), s (surgeon), n (nurse), a (administrator), r (receptionist), j (janitor)");
			System.out.println("Please type the employee role letter and press enter:");
			etype = reader.next().charAt(0);
			
			checkflag = checkType(etype);
		}
		checkflag = false;
		
		while (!checkflag) {
			System.out.println("Please type the employee name and press enter:");
			ename = reader.next();
			checkflag = checkName(ename);
			
			if (checkflag) {
				persons = deleteEmployee(persons, etype, ename);
				System.out.println(ename + " is deleted from the Hospital Employee list.");
			}
		}
		
		return persons;
	}
	
	public static boolean checkType(char t) {
		boolean flag = false;
		char[] typechar = {'h', 'd', 's', 'n', 'a', 'r', 'j'};
		for (int i = 0; i < typechar.length; i++) {
			if (t == typechar[i]) {
				flag = true;
			}
		}
		
		return flag;
	}
	
	public static boolean checkName(String n) {
		boolean flag = false;
		if (n.length() > 1) {
			flag = true;
		}
		
		return flag;
	}
	
	public static Employee[] deleteEmployee(Employee[] list, char role, String name) {
		int total = checkCount(list);
		int newtotal = total - 1;
		Employee[] employeelist = new Employee[list.length];
		int j = 0;
		
		for (int i = 0; i < total; i++) {
			if (list[i].getType() != role && list[i].getName() != name) {
				employeelist[j] = list[i];
				j++;
			}
		}
		display(employeelist);
		return employeelist;
	}
	
	public static int checkCount(Employee[] list) {
		int j = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i] != null) {
				j++;
			}
		}
		
		return j;
	}
	
	public static void save(Employee[] persons) {
		String filename = "text.txt";
		String line;
		int total = checkCount(persons);
		int x = 0; 
		
		try {
			FileWriter filewriter = new FileWriter(filename);
			BufferedWriter bufferedWriter = new BufferedWriter(filewriter);
			
			while(x < total) {
				bufferedWriter.write("\n" + persons[x].revert());
				x++;
			}
						
			bufferedWriter.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Unable to open file '" + filename + "'");
		}
		catch(IOException e) {
			System.out.println("Error reading file '" + filename + "'");
		}
	}
	
	public static void exit(Employee[] persons) {
		save(persons);
		System.exit(0);
	}
	
	//showMenu function displays the menu at the start of the program
	public static void showMenu() {
		System.out.println("\nHospital Management Menu Command");
		System.out.println("(1) Display Hospital Employees");
		System.out.println("(2) Add a Hospital Employee");
		System.out.println("(3) Delete a Hospital Employee");
		System.out.println("(4) Exit");
	}
	
	//getCommand function takes user input from a list of menu commands
	public static void getCommand(Employee[] persons) {
		int answer = 0;
		Scanner reader = new Scanner(System.in);
		showMenu();
		System.out.println("Please enter a command number: ");
		answer = reader.nextInt();

		if (answer < 1 || answer > 4) {
			getCommand(persons);
		}
		else {
			setCommand(answer, persons);
		}
	}
	
	//setCommand function executes one operation based on user input from getCommand
	public static void setCommand(int input, Employee[] persons) {
		int total = checkCount(persons);
		
		switch(input) {
		case 1: display(persons);
			getCommand(persons);
			break;
		case 2: persons[total] = add(persons);
			getCommand(persons);
			break;
		case 3: persons = delete(persons);
			getCommand(persons);
			break;
		case 4: exit(persons);
			break;
		}
	}
	
	public static void readFile() {
		String filename = "text.txt";
		String line;
		Employee[] hperson = new Employee[20];
		int x = 0;
		try {
			FileReader filereader = new FileReader(filename);
			BufferedReader bufferedReader = new BufferedReader(filereader);
			
			while((line = bufferedReader.readLine()) != null) {
				hperson[x] = getEmployeeDetails(line, hperson[x]);
				x++;
			}
			
			getCommand(hperson);
			
			bufferedReader.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Unable to open file '" + filename + "'");
		}
		catch(IOException e) {
			System.out.println("Error reading file '" + filename + "'");
		}
	}
	
	public static void main(String[] args) {
		readFile();
		System.exit(0);

	}
	

}
