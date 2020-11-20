package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepository {

    public List<Course> findAllCourses() {
        return DataHolder.courses;
    }

    public Course findById(Long courseId) {
        return DataHolder.courses.stream().filter(course -> course.getCourseId().equals(courseId)).findFirst().get();
    }

    public List<Student> findAllStudentsByCourse(Long courseId) {
        return DataHolder.courses.stream().filter(course -> course.getCourseId().equals(courseId)).findFirst().get().getStudents();
    }

    public Course addStudentToCourse(Student student, Course course) {
        findById(course.getCourseId()).addStudent(student);
        return findById(course.getCourseId());
    }

    public Course save(Course course) {
        DataHolder.courses.removeIf(x -> x.getName().equals(course.getName()));
        DataHolder.courses.add(course);
        return course;
    }
}
