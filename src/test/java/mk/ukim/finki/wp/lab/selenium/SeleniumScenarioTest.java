package mk.ukim.finki.wp.lab.selenium;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.model.Teacher;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SeleniumScenarioTest {

    private HtmlUnitDriver driver;

    public static List<Student> students = new ArrayList<>(5);
    public static List<Course> courses = new ArrayList<>(5);
    public static List<Teacher> teachers = new ArrayList<>(5);

    @BeforeEach
    private void setup() {
        this.driver = new HtmlUnitDriver(true);
        initData();
    }

    private void initData() {
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

    @AfterEach
    public void destroy() {
        if (this.driver != null) {
            this.driver.close();
        }
    }

    @Test
    public void testScenario() {
        driver.get("http://localhost:8080/courses");
        CoursesPage coursesPage = CoursesPage.to(this.driver);
        coursesPage.assertElements(0, 0, 5);

        driver.get("http://localhost:8080/login");
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin");
        driver.findElement(By.cssSelector(".btn")).click();

        driver.get("http://localhost:8080/courses");

        Assert.assertTrue(driver.findElement(By.id("username")).isDisplayed());

    }
}
