package com.example.spring.gradle.repository;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.spring.gradle.confing.JooqConfig;
import com.example.spring.gradle.dto.StudentDto;

import static com.example.generated.tables.Students.STUDENTS;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class StudentRepository {

    private final DSLContext dslContext;
    
    public List<StudentDto> getAll() {
        return dslContext.select().from(STUDENTS).fetchInto(StudentDto.class);
    }

    public Optional<StudentDto> getById(Integer id) {
        return Optional.ofNullable(
            dslContext
                .select()
                .from(STUDENTS)
                .where(STUDENTS.ID.eq(id))
                .fetchOneInto(StudentDto.class)
        );
    }

    public StudentDto create(StudentDto studentDto) {
    	return dslContext
        .insertInto(STUDENTS)
        .set(STUDENTS.FIRSTNAME, studentDto.getFirstname())
        .set(STUDENTS.MIDDLENAME, studentDto.getMiddlename())
        .set(STUDENTS.LASTNAME, studentDto.getLastname())
        .returning()
        .fetchOne()
        .into(StudentDto.class);
    }

    public StudentDto update(StudentDto studentDto) {
    	return dslContext
                .update(STUDENTS)
                .set(STUDENTS.FIRSTNAME, studentDto.getFirstname())
                .set(STUDENTS.MIDDLENAME, studentDto.getMiddlename())
                .set(STUDENTS.LASTNAME, studentDto.getLastname())
                .where(STUDENTS.ID.eq(studentDto.getId()))
                .returning()
                .fetchOne()
                .into(StudentDto.class);
    }

    public void delete(Integer id) {
        dslContext
            .deleteFrom(STUDENTS)
            .where(STUDENTS.ID.eq(id))
            .execute();
    }
    
}

