package com.lcwd.SpringMvcproject.Controller;

import com.lcwd.SpringMvcproject.models.Student;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {
    // create student
    //data required

    //we are receiving data in json format
    // json --> java object ==>  deserialization
    @PostMapping("/create")
    public ResponseEntity<List<Student>> createStudent(@RequestBody List<Student> students) {
        System.out.println(students.size()) ;
        System.out.println(students);

        ResponseEntity<List<Student>> response = new ResponseEntity<>(students , HttpStatus.OK) ;

        return response ;
    }
}
