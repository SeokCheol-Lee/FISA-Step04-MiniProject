package model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import model.GradeType;

@Getter
@Setter
@AllArgsConstructor

public class User {


    private String name;
    private String email;
    private GradeType grade;
    
    @Override
    public String toString() {
        return String.format("Person(이름: %s, email: %s , grade: %s)", name, email ,grade);
    }
}
