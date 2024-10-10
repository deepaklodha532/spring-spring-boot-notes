package com.lcwd.orm.services;

import com.lcwd.orm.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentReository extends JpaRepository<Student, Integer> {


}
