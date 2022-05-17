package com.firstSpringbootApp.student.Repositories;

import com.firstSpringbootApp.student.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    Optional<Student> findStudentByEmail(String email);

}
