package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudenRepository studentRepositoy;

    @Autowired
    public StudentService(StudenRepository studentRepositoy) {
        this.studentRepositoy = studentRepositoy;
    }

    public List<Student> getStudents(){
        return studentRepositoy.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepositoy.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentRepositoy.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepositoy.existsById(studentId);
        if (!exists){
            throw new IllegalStateException("student with id" + studentId + " does not exists");
        }
        studentRepositoy.deleteById(studentId);
    }
}
