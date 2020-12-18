package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Student> students;

    @OneToOne(fetch = FetchType.EAGER)
    private Teacher teacher;

    //TODO: add students in the constructor or add a method for adding students to the list
    public Course(String name, String description, List<Student> students, Teacher teacher) {
        this.name = name;
        this.description = description;
        this.students = students;
        this.teacher = teacher;
    }

    public Course() {
    }

    public void addStudent(Student s) {
        this.students.add(s);
    }
}
