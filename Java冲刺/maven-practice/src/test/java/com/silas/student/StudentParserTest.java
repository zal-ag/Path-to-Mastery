package com.silas.student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StudentParserTest {

    @Test
    void parseValidRecord() {
        Student student = StudentParser.parse("1001,张三,20,北京");
        Assertions.assertEquals("1001",student.getId());
        Assertions.assertEquals("张三",student.getName());
        Assertions.assertEquals(20,student.getAge());
        Assertions.assertEquals("北京",student.getAddress());
    }

    @Test
    void parseValidRecordWithSpaces() {
        Student student = StudentParser.parse(" 1001 , 张三 , 20 , 北京 ");
        Assertions.assertEquals("1001",student.getId());
        Assertions.assertEquals("张三",student.getName());
        Assertions.assertEquals(20,student.getAge());
        Assertions.assertEquals("北京",student.getAddress());
    }

    @Test
    void rejectsNull() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> StudentParser.parse(null)
        );
    }

    @Test
    void rejectsInsufficient() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> StudentParser.parse("1001,张三,20")
        );
    }

    @Test
    void rejectsBlankAddress() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> StudentParser.parse("1001,张三,20,")
        );
    }

    @Test
    void rejectsAgeFormatError() {
        Assertions.assertThrows(
                NumberFormatException.class,
                () -> StudentParser.parse("1001,张三,abc,北京")
        );
    }

    @Test
    void rejectsAgeAboveMaximum() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> StudentParser.parse("1001,张三,121,北京")
        );
    }
}
