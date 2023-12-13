package ru.necklace.outer.docpreparator.data.tags;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public enum FieldTag {
    DOC_NUMBER("номер"),
    DATE("дата"),
    EXAMENATOR_SURNP("Фамилия ИО экзаменатора"),
    EXAM_TYPE("Тип сдачи"),
    EXAM_NAME("Название предмета"),
    STUDENT_FIO("ФИО ученика"),
    STUDENT_SURNAME("Фамилия ученика"),
    STUDENT_NAME("Имя ученика"),
    STUDENT_PATRONIM("Отчество");

    public String name;

    FieldTag(String name) {
        this.name = "%{" + name.replaceAll(" ", "_") + "}";
    }

    static {

    }

    public static FieldTag getByName(String name) {
        return Arrays.stream(values())
                .filter(it -> StringUtils.equals(it.name, name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("FieldTag for " + name + " not found"));
    }
}
