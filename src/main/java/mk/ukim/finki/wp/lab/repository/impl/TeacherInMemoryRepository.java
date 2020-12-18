package mk.ukim.finki.wp.lab.repository.impl;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Teacher;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;

@Repository
public class TeacherInMemoryRepository {
    public List<Teacher> findAll() {
        return DataHolder.teachers;
    }

    public Teacher findById(Long id) {
        return DataHolder.teachers.stream().filter(teacher -> teacher.getId().equals(id)).findFirst().get();
    }
}
