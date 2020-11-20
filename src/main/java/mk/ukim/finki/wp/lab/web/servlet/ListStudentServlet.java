package mk.ukim.finki.wp.lab.web.servlet;

import mk.ukim.finki.wp.lab.service.CourseService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "student-list-servlet", urlPatterns = "/addStudent")
public class ListStudentServlet extends HttpServlet {

    private final CourseService courseService;
    private final SpringTemplateEngine springTemplateEngine;

    public ListStudentServlet(SpringTemplateEngine springTemplateEngine, CourseService studentService) {
        this.springTemplateEngine = springTemplateEngine;
        this.courseService = studentService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());
        Long courseId = null;
        try {
            courseId = Long.parseLong(req.getSession().getAttribute("courseId").toString());
        } catch (Exception e) {
            resp.sendRedirect("/listCourses");
            return;
        }
        context.setVariable("courseId", courseId);
        context.setVariable("students", this.courseService.listStudentsByCourse(courseId));
        this.springTemplateEngine.process("listStudents.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        Long courseId = Long.parseLong(req.getSession().getAttribute("courseId").toString());
        courseService.addStudentInCourse(username, courseId);
        resp.sendRedirect("/StudentEnrollmentSummary");
    }
}
