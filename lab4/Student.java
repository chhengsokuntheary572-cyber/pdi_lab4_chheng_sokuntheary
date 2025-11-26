package lab4;

public class Student {
    private String name;
    private String id;
    private String gender;

    public Student(String name, String id, String gender) {
        this.name = name;
        this.id = id;
        this.gender = gender;
    }
    
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }
    
    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + id + ", Gender: " + gender;
    }
}
