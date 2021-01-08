package mk.ukim.finki.wp.lab;

import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.repository.jpa.StudentRepository;
import mk.ukim.finki.wp.lab.service.impl.StudentServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {
    @Mock
    private StudentRepository studentRepository;

    private StudentServiceImpl service;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        Student student = new Student("student", "student", "student", "student");
        Mockito.when(this.studentRepository.save(Mockito.any(Student.class))).thenReturn(student);

        service = Mockito.spy(new StudentServiceImpl(this.studentRepository));
    }

    @Test
    public void testEmptyUsername() {
        Student s = this.service.save("", "something", "something", "something");;
        Mockito.verify(this.service).save("", "something", "something", "something");

        Assert.assertNull("Object is null as expected", s);
    }

    @Test
    public void testEmptyPassword() {
        Student s = this.service.save("something", "", "something", "something");;
        Mockito.verify(this.service).save("something", "", "something", "something");

        Assert.assertNull("Object is null as expected", s);
    }

    @Test
    public void testEmptyName() {
        Student s = this.service.save("something", "something", "", "something");;
        Mockito.verify(this.service).save("something", "something", "", "something");

        Assert.assertNull("Object is null as expected", s);
    }

    @Test
    public void testEmptySurname() {
        Student s = this.service.save("something", "something", "something", "");;
        Mockito.verify(this.service).save("something", "something", "something", "");

        Assert.assertNull("Object is null as expected", s);
    }

    @Test
    public void testSuccessfulSave() {
        Student s = this.service.save("something", "something", "something", "something");;
        Mockito.verify(this.service).save("something", "something", "something", "something");

        Assert.assertEquals(new Student("something", "something", "something", "something"), s);
    }


}
