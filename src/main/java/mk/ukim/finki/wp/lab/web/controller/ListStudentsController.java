package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/addStudent")
public class ListStudentsController {

    private final CourseService courseService;

    public ListStudentsController(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping("/{courseId}")
    public String getStudents(@PathVariable Long courseId, @RequestParam(required = false) String error, Model model) {
        List<Student> students = courseService.listStudentsByCourse(courseId);
        model.addAttribute("students", students);
        model.addAttribute("bodyContent", students);

        model.addAttribute("courseId", courseId);
        model.addAttribute("bodyContent, courseId");
        return "listStudents.html";
    }

//    @PostMapping

}
