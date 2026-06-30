package com.spring.spring_rest.mapper;

import com.spring.spring_rest.dto.StudentDto;
import com.spring.spring_rest.entity.Student; 

public class StudentMapper {

    // Method will map Student to StudentDto
    public static StudentDto mapToStudentDto(Student theStudent) {
        return new StudentDto(
                theStudent.getId(),
                theStudent.getFirstName(),
                theStudent.getLastName(),
                theStudent.getEmail()
        );
    }

    // Method will map StudentDto to Student
    // Fixed: Cleaned up the method signature return type to just 'Student'
    public static Student mapToStudent(StudentDto theStudentDto) {
        return new Student(
                theStudentDto.getId(),
                theStudentDto.getFirstName(),
                theStudentDto.getLastName(),
                theStudentDto.getEmail()
        );
    }
}