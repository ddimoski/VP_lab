package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Grade;

import java.util.List;

public interface GradeService {
    Character getGradeByStudentId(Long studentId, Long courseId);

    List<Grade> findAllByCourse(Long courseId);
}
