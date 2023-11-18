package com.example.spring.gradle.transformer;

import com.example.spring.gradle.dto.StudentDto;

public class StudentDtoTransformer {
    
    public static StudentDto toStudentDto(Integer id, String firstname, String middlename, String lastname) {
        return StudentDto.builder()
                .id(id)
                .firstname(firstname)
                .middlename(middlename)
                .lastname(lastname)
                .build();
    }

    public static StudentDto toStudentDto(Integer id, StudentDto studentDto) {
        return toStudentDto(id, studentDto.getFirstname(), studentDto.getMiddlename(), studentDto.getLastname());
    }
}
