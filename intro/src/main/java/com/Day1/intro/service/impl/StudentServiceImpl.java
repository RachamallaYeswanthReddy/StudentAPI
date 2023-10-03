package com.Day1.intro.service.impl;

import com.Day1.intro.Controller.model.Student;
import com.Day1.intro.repository.StudentRepository;
import com.Day1.intro.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public boolean saveStudent (Student student){
        Optional<Student> isStudentOptional = studentRepository.existsByEmail(student.getEmail());
        if(isStudentOptional.isPresent()){
            studentRepository.save(student);
            return true;
        }else {
            return false;
        }
    }
    @Override
    public List<Student>  getAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }
    @Override
    public Student getStudentById(Long id){
        Student student = studentRepository.findById(id).orElseThrow();
        return student;
    }
    @Override
    public Student updateStudent(Long id,Student student){
        Student Student1 = studentRepository.findById(id).orElseThrow();
        Student1.setName(student.getName());
        Student1.setEmail(student.getEmail());
        Student1.setDept(student.getDept());
        return  studentRepository.save(Student1);
    }
    @Override
    public boolean deleteStudent(Long id){
        Optional<Student> isStudentOptional =studentRepository.findById(id);
        if(isStudentOptional.isPresent()){
            studentRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }
}
