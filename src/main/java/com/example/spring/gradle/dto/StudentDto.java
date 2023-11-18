package com.example.spring.gradle.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {
    private Integer id;
    private String firstname;
    private String middlename;
    private String lastname;
}
