package mk.ukim.finki.wp.lab.repository.impl;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseInMemoryRepository {

    public List<Course> findAllCourses() {
        return DataHolder.courses;
    }

    public Course findById(Long courseId) {
        return DataHolder.courses.stream().filter(course -> course.getId().equals(courseId)).findFirst().get();
    }

    public List<Student> findAllStudentsByCourse(Long courseId) {
        return DataHolder.courses.stream().filter(course -> course.getId().equals(courseId)).findFirst().get().getStudents();
    }

    public Course addStudentToCourse(Student student, Course course) {
        findById(course.getId()).addStudent(student);
        return findById(course.getId());
    }

    public Course save(Course course) {
        DataHolder.courses.removeIf(x -> x.getName().equals(course.getName()));
        DataHolder.courses.add(course);
        return course;
    }
}
