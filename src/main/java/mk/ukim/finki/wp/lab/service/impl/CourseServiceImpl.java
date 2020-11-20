package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.repository.CourseRepository;
import mk.ukim.finki.wp.lab.repository.StudentRepository;
import mk.ukim.finki.wp.lab.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public CourseServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> listStudentsByCourse(Long courseId) {
        return courseRepository.findAllStudentsByCourse(courseId);
    }

    @Override
    public Course addStudentInCourse(String username, Long courseId) {
        Student student = studentRepository.findByUsername(username);
        Course course = courseRepository.findById(courseId);
        return courseRepository.addStudentToCourse(student, course);
    }

    @Override
    public List<Course> listALl() {
        return courseRepository.findAllCourses();
    }

    @Override
    public Course findById(Long courseId) {
        return courseRepository.findById(courseId);
    }
}
