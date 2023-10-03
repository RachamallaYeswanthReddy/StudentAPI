package com.Day1.intro.Controller;

import com.Day1.intro.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Day1.intro.Controller.model.Student;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class Controller {

    @Autowired
    private StudentService studentService;
//    This is the  JSON format to send the data
//    {
//        "name":"Yeswanth Reddy",
//        "email":"yeswanthrachamalla@gmail.com",
//        "dept": "cse"
//    }
//    If we use the random data
//    {
//        "name":"{{$randomFullName}}",
//        "email":"{{$randomEmail}}",
//        "dept": "cse"
//    }
//    POST method:   http://localhost:8011/api/v1/student/save
    @PostMapping("/save")
    public ResponseEntity<String> saveStudent(@RequestBody Student student){
        boolean isDataSaved = studentService.saveStudent(student);
        return isDataSaved ? ResponseEntity.status(200).body("Student Data Saved Sucessfully"):
                ResponseEntity.status(404).body("Something went Wrong");
    }
    // Getting all student list
//    http://localhost:8011/api/v1/student/all
    @GetMapping("/all")
    public ResponseEntity<List<Student>>getAllStudent(){
        List<Student> studentList= studentService.getAllStudent();
        return studentList.size()>0? ResponseEntity.status(200).body(studentList):
                ResponseEntity.status(404).body(null);
    }
//  http://localhost:8011/api/v1/student/1
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        Student student = studentService.getStudentById(id);
        return ResponseEntity.status(200).body(student);
    }
//    This get method is used to take by passing the request
//    http://localhost:8011/api/v1/student/getStudent?id=1
//    @GetMapping("/getStudent")
//    public ResponseEntity<Student> getStudentById(@RequestParam Long id){
//        Student studen    t = studentService.getStudentById(id);
//        return ResponseEntity.status(200).body(student);
//    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updatestudent(@RequestBody Student student,@PathVariable Long id){
        Student student1= studentService.updateStudent(id,student);
        return ResponseEntity.status(200).body(student1);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        boolean isDeleted = studentService.deleteStudent(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body("Student Data Deleted Successfully");
        } else {
            return ResponseEntity.status(404).body("Student not found or Something went Wrong");
        }
    }

}
