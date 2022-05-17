package com.firstSpringbootApp.student.services;

import com.firstSpringbootApp.student.Repositories.*;
import com.firstSpringbootApp.student.domain.*;
import org.slf4j.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final Logger logger=LoggerFactory.getLogger(StudentService.class);


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){
        List<Student> allStudents=studentRepository.findAll();
        logger.info("Found all students {}",allStudents);

        return allStudents;

    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional=studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("The email exists");
                    }
        else{
            studentRepository.save(student);
        }
    }

    public void deleteStudent(Long studentId) {
        boolean exist= studentRepository.existsById(studentId);
        if (!exist){
            throw new IllegalStateException("student doesn't exist");

        }
        studentRepository.deleteById(studentId);
    }

    public Optional<Student> getOneStudent(Long studentId) {

        return studentRepository.findById(studentId);
    }
    public Optional<Student> updateStudentDetails(Long studentId, String name, String email ,String address){
        Optional<Student> studentOptional=studentRepository.findById(studentId);
        logger.info("Found student   {}",studentOptional);

        if(studentOptional.isPresent()){
            Student student=studentOptional.get();
            if (name !=null && name.length() >0  && !Objects.equals(studentOptional.get(),name)) {
                student.setName(name);
                logger.info("Updated student's name to: {}",name);
            }
            if (email !=null && email.length() >0  && !Objects.equals(studentOptional.get(),email)) {
                student.setEmail(email);
                logger.info("Updated student's email to: {}",email);
            }
            if (address !=null && email.length() >0  && !Objects.equals(studentOptional.get(),email)) {
                student.setAddress(address);
                logger.info("Updated student's email to: {}",address);
            }
            return Optional.of(studentRepository.save(student));


        }

        return studentOptional;
    }
}
