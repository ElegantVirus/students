package net.fourfinance.entity;

/**
 * Student data object, consists of name and grade
 */
public class StudentDto {
    String name;
    String grade;

    public StudentDto(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

}
