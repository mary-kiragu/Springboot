package com.firstSpringbootApp.student.ResourceControler;

import com.firstSpringbootApp.student.domain.*;
import com.firstSpringbootApp.student.services.*;
import org.slf4j.*;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.*;

@RestController
@RequestMapping(path="/api/students")
public class StudentController {
    private final StudentService studentService;
    private final Logger logger=LoggerFactory.getLogger(StudentController.class);

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        System.out.println("student controller - getAllStudents");
        return studentService.getAllStudents();
    }
    @GetMapping(path = "/{studentId}")
    public Optional<Student> getOneStudent(@PathVariable Long studentId){
        return studentService.getOneStudent(studentId);
    }

    @PostMapping
    public void addNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
    studentService.deleteStudent(studentId);

    }
    @PutMapping(path = "/{studentId}")
    public void updateStudentDetails(
            @PathVariable("studentId") Long studentId,
            @RequestBody StudentVM studentVM
           ){
        logger.info("REST request to updateStudent studentId: {}, studentVm: {}",studentId,studentVM);
        studentService.updateStudentDetails(studentId,studentVM.getName(),studentVM.getEmail(),studentVM.getAddress());


    }


}
class  StudentVM implements Serializable {
    Long studentId;
    String name;
    String email;
    String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "StudentVM{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}