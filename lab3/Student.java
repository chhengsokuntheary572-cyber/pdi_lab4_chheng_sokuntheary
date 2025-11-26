package lab3;

public class Student {
public static void main(String[] args) {}
    // Variables
    String name;
    int ID;
    String major;

    // Constructors
    Student() {
    }

    Student(String newName, int ID, String major) {
        this.name = newName;
        this.ID = ID;
        this.major = major;
    }

    public void setUpdateName(String name) {
        this.name = name;
    }

	public void setUpdateID(int ID) {
		this.ID = ID;
		
	}

	public void setUpdatemajor(String major) {
		this.major = major;
		
	}

// Methods
public void print() {
    System.out.println("Name of student: " + name);
    System.out.println("ID: " + ID);
    System.out.println("Major: " + major);
    System.out.println("----------------------\n");
}
}