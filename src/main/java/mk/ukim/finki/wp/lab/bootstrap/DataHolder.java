package mk.ukim.finki.wp.lab.bootstrap;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Student> students = new ArrayList<>(5);
    public static List<Course> courses = new ArrayList<>(5);

    @PostConstruct
    public void init() {
        Student s1 = new Student("student1", "pass", "Student", "One");
        Student s2 = new Student("student2", "pass", "Student", "Two");
        Student s3 = new Student("student3", "pass", "Student", "Three");
        Student s4 = new Student("student4", "pass", "Student", "Four");
        Student s5 = new Student("student5", "pass", "Student", "Five");

        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);

        courses.add(new Course(1L, "Web Programming", "Backend course", students));
        courses.add(new Course(2L, "Probability and Statistics", "Math course", students));
        courses.add(new Course(3L, "Design of Educational Software", "Designing software for education", students));
        courses.add(new Course(4L, "Advanced Interaction Human-Computer", "Human-machine interaction course", students));
        courses.add(new Course(5L, "Methodology of research in ICT", "Theoretical course in research", students));
    }
}
