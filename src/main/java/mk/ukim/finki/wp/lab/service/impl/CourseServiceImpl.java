package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.repository.jpa.CourseRepository;
import mk.ukim.finki.wp.lab.repository.jpa.StudentRepository;
import mk.ukim.finki.wp.lab.service.CourseService;
import mk.ukim.finki.wp.lab.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final TeacherService teacherService;

    public CourseServiceImpl(StudentRepository studentRepository,
                             CourseRepository courseRepository,
                             TeacherService teacherService) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.teacherService = teacherService;
    }

    @Override
    public List<Student> listStudentsByCourse(Long courseId) {
        return courseRepository.findById(courseId).get().getStudents();
    }

    @Override
    public Course addStudentInCourse(String username, Long courseId) {
        Student student = studentRepository.findByUsername(username);
        Course course = courseRepository.findById(courseId).get();
        course.getStudents().add(student);
        return this.courseRepository.save(course);
    }

    @Override
    public List<Course> listALl() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(Long courseId) {
        return courseRepository.findById(courseId).get();
    }

    @Override
    @Transactional
    public Course save(String name, String description, Long teacherId) {
        Teacher teacher = teacherService.findById(teacherId);
        return courseRepository.save(new Course(name, description, new ArrayList<>(), teacher));
    }

    @Override
    public void delete(Long courseId) {
        Course course = findById(courseId);
        courseRepository.delete(course);
    }
}
