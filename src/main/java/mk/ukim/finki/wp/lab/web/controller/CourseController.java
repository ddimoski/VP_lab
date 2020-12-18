package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public String getCoursesPage(@RequestParam(required = false) String error, Model model) {
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Course> products = this.courseService.listALl();
        model.addAttribute("courses", products);

        return "redirect:/listCourses";
    }

    @PostMapping("courses/add")
    public String saveCourse(@RequestParam String name, @RequestParam String description, @RequestParam Long teacherId) {
        courseService.save(name, description, teacherId);
        return "redirect:/listCourses";
    }

    @DeleteMapping("courses/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.delete(id);
        return "redirect:/listCourses";
    }

    @GetMapping("/courses/edit-form/{id}")
    public String getEditCoursePage(@PathVariable Long id, Model model) {
        try {
            Course course = courseService.findById(id);
            Teacher teacher = course.getTeacher();
            model.addAttribute("courseId", course.getId());
            model.addAttribute("teacherId", teacher.getId());
            return "add-course";
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/listCourses";
    }
}
