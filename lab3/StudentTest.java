package lab3;
import java.util.List;
import java.util.ArrayList;

public class StudentTest {

    public static void main(String[] args) {

        Student student1 = new Student();
        Student student2 = new Student("Sak", 42, "SE");
        

        student1.setUpdateName("Lyda");
        student1.setUpdateID(1);
        student1.setUpdatemajor("SE");

        List<Student> students = new ArrayList<Student>();
        
        students.add(student1);
        students.add(student2);
        
        students.add(new Student("Theary", 44, "SE"));
        students.add(new Student("Inthera", 19, "SE"));
        students.add(new Student("Van heng", 25, "SE"));
  
        for (Student s : students) {
            s.print();
        }
    }

} 
