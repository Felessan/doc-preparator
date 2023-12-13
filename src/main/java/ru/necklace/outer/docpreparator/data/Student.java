package ru.necklace.outer.docpreparator.data;

import lombok.Data;

@Data
public class Student {
    private String name;
    private String surname;
    private String patronim;
    private String group;
    private byte grade;
    private String specialization;
    private String educationForm;
}
