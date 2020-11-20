package mk.ukim.finki.wp.lab.bootstrap;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Student> students = new ArrayList<>(5);
    public static List<Course> courses = new ArrayList<>(5);
    public static List<Teacher> teachers = new ArrayList<>(5);

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

        Teacher t1 = new Teacher("Teacher 1", "One");
        Teacher t2 = new Teacher("Teacher 2", "Two");
        Teacher t3 = new Teacher("Teacher 3", "Three");
        Teacher t4 = new Teacher("Teacher 4", "Four");
        Teacher t5 = new Teacher("Teacher 5", "Five");

        teachers.add(t1);
        teachers.add(t2);
        teachers.add(t3);
        teachers.add(t4);
        teachers.add(t5);

        courses.add(new Course("Web Programming", "Backend course", students, t1));
        courses.add(new Course("Probability and Statistics", "Math course", students, t2));
        courses.add(new Course("Design of Educational Software", "Designing software for education", students, t3));
        courses.add(new Course("Advanced Interaction Human-Computer", "Human-machine interaction course", students, t4));
        courses.add(new Course("Methodology of research in ICT", "Theoretical course in research", students, t5));
    }
}
