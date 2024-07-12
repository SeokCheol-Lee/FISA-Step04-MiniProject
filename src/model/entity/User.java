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
@ToString
public class User {

    private String name;
    private String email;
    private GradeType grade;
}
