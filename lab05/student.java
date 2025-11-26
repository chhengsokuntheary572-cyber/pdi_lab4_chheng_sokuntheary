package lab05;

class Student {
	int ID;
	String name;
	
	Student(int ID, String name) {
		this.ID = ID;
		this.name = name;
	}
	void print() {
		System.out.println(ID+" " + name);
	}

}
